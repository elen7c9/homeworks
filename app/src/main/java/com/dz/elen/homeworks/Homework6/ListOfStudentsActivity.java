package com.dz.elen.homeworks.Homework6;

import android.app.Dialog;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.support.v4.app.Fragment;

import com.dz.elen.homeworks.R;

import java.util.ArrayList;
import java.util.List;

public class ListOfStudentsActivity extends FragmentActivity {

    private RecyclerView studentsRecyclerView;
    private List<Student> students;

    EditText nameEditText, mailEditText;
    Button saveBtn;
    ImageButton addBtn;

    EditText search;

    StudentAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_students);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        ItemFragment fragment = new ItemFragment();
        fragmentTransaction.add(R.id.item_fragment, fragment);
        fragmentTransaction.commit();



         search= (EditText) findViewById(R.id.search);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });

        studentsRecyclerView = (RecyclerView) findViewById(R.id.students_recyclerview);
        studentsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        students = StudentsBase.get().getStudents();

        adapter = new StudentAdapter(students,this);
        studentsRecyclerView.setAdapter(adapter);

        addBtn = (ImageButton)findViewById(R.id.btnAddNewStudent);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayDialog();
            }
        });

    }




    private void filter(String text){
        ArrayList<Student> filter = new ArrayList<>();
        for (Student s:students){
            if(s.getName().toLowerCase().contains(text.toLowerCase())){
                filter.add(s);
            }
        }
        adapter.filterList(filter);
    }
    private void displayDialog(){

        final Dialog d = new Dialog(this);
        d.setTitle("ADD NEW STUDENT");
        d.setContentView(R.layout.edit_dialog);
       nameEditText = (EditText) d.findViewById(R.id.nameEditText);
        mailEditText = (EditText) d.findViewById(R.id.mailEditText);
        saveBtn = (Button) d.findViewById(R.id.saveBtn);

       saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Student s = new Student();
                s.setName(nameEditText.getText().toString());
                s.setMail(mailEditText.getText().toString());

                if(StudentsBase.get().addNew(s)){
                    nameEditText.setText("");
                    mailEditText.setText("");
                    s.setImage(R.drawable.noimage);

                    studentsRecyclerView.setAdapter(adapter);
                }
                d.dismiss();
            }
        });
        d.show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        studentsRecyclerView.setAdapter(adapter);


    }
}


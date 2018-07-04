package com.dz.elen.homeworks.Homework6;

import android.app.Dialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.dz.elen.homeworks.R;

import java.util.ArrayList;
import java.util.List;

public class ListOfStudentsActivity extends AppCompatActivity {

    private RecyclerView studentsRecyclerView;
    private List<Student> students;

    EditText nameEditText, mailEditText;
    Button saveBtn;
    ImageButton addBtn;

    StudentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_students);

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


package com.dz.elen.homeworks.Homework6;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dz.elen.homeworks.R;

import java.util.ArrayList;
import java.util.List;

public class ListOfStudentsActivity extends AppCompatActivity {

    private RecyclerView studentsRecyclerView;
    private List<Student> students;
    RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_students);

        studentsRecyclerView = (RecyclerView) findViewById(R.id.students_recyclerview);
        studentsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        students = StudentsBase.get().getStudents();

        adapter = new StudentAdapter(students,this);
        studentsRecyclerView.setAdapter(adapter);
    }

}

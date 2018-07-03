package com.dz.elen.homeworks.Homework6;

import com.dz.elen.homeworks.R;

import java.util.ArrayList;
import java.util.List;

public class StudentsBase {

    private List<Student> students;

    private StudentsBase() {
        students = new ArrayList<>();
        for (int i = 0; i<100; i++){
           Student student = new Student();
           student.setName("Иванова Анна Михайловна");
           student.setMail("ann@gmail.com");
           student.setImage(R.drawable.img_student);
           students.add(student);
        }
    }

    public List<Student> getStudents(){
        return students;
    }

    private static StudentsBase studentsBase;

    public static StudentsBase get(){
        if(studentsBase==null){
            studentsBase = new StudentsBase();
        }

        return studentsBase;
    }
}

package com.dz.elen.homeworks.Homework6;

import com.dz.elen.homeworks.R;

import java.util.ArrayList;
import java.util.List;

public class StudentsBase {

    private List<Student> students;

    private StudentsBase() {
        students = new ArrayList<>();
        students.add(new Student("Иванова Анна Михайловна", "ann.ivanova@gmail.com",R.drawable.img_student1));
        students.add(new Student("Петров Сергей Андреевич", "serg512@gmail.com",R.drawable.img_student2));
        students.add(new Student("Жук Полина Ивановна", "zhuk.polina@gmail.com",R.drawable.img_student3));
        students.add(new Student("Сенько Артем Петрович", "artem831@gmail.com",R.drawable.img_student4));
        students.add(new Student("Красько Илья Владимирович", "i.krasko@gmail.com",R.drawable.img_student5));
        students.add(new Student("Синица Ольга Дмитриевна", "sini4ka@gmail.com",R.drawable.img_student6));
        students.add(new Student("Волков Андрей Викторович", "sini4ka@gmail.com",R.drawable.img_student7));



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

    public  boolean addNew(Student student){
        try {
            students.add(0,student);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean edit(int position, Student newStudent){
        try {
            students.remove(position);
            students.add(position,newStudent);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int pos){
        try {
            students.remove(pos);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}

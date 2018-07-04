package com.dz.elen.homeworks.Homework6;

public class Student {
    private String name;
    private String mail;
    private int image;


    public Student(String name, String mail, int image) {
        this.name = name;
        this.mail = mail;
        this.image = image;
    }

    public Student() {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}

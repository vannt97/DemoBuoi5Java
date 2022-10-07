package com.java.model;

import java.util.Scanner;

public class Student extends Person{
    static Student m_Instance;
    public static Student getInstance(){
        if(m_Instance == null){
            m_Instance = new Student();
        }
        return m_Instance;
    }

    public Student() {
    }
    public Student(String hoTen, int age) {
        super(hoTen, age);
    }

    @Override
    public void nhap(String chuoi) {
        System.out.println("Allo");
    }


    @Override
    public void nhap(Scanner scanner) {

    }
}

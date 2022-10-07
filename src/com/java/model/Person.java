package com.java.model;

import java.util.Scanner;

public abstract class Person implements NhapXuat {
    protected String hoTen;
    protected int age;

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
    }

    public Person(String hoTen, int age) {
        this.hoTen = hoTen;
        this.age = age;
    }

    public void nhap(String chuoi){
        System.out.println("helllo");
    }



    public void TinhLuong(){

    }

    public void TinhTuoi(){
        System.out.println("lop cha asbstract");
    }

    static void TinhA(){

    }
}

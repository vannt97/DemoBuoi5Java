package com.java.model;

import java.util.Scanner;

public interface NhapXuat {
    static String vi = null;
    public void nhap(Scanner scanner);
     default void Xuat(){
        System.out.println("xuat");
    };

    static void TinhA() {
        System.out.println("TInhA");
    }

}

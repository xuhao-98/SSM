package com.stx.pojo;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生成绩：");
        int x = scanner.nextInt();
        if (x >= 90 && x <= 100) {
            System.out.println("这个学生是优等生！");
        } else if (x > 60 && x < 90) {
            System.out.println("这个学生是良等生！");
        } else if (x > 0 && x < 60) {
            System.out.println("这个学生是差等生！");
        } else {
            System.out.println("成绩无效");
        }
    }
}



package com.edu;

import com.edu.service.StudentStaticArrayService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        StudentStaticArrayService stdStatic = new StudentStaticArrayService();
        System.out.println("nhap so luong cua mang");
        stdStatic.initStudentArray(sc.nextInt());
        boolean isExit = false;

        do {
            System.out.println(" 1.create students ");
            System.out.println(" 2.read students ");
            System.out.println(" 3.update students ");
            System.out.println(" 4.delete students ");

            int choice = sc.nextInt();
            switch (choice){
                case 1 :
                    System.out.println(" create students ");
                    stdStatic.addStudents();
                    break;
                case 2 :
                    System.out.println(" read students ");
                    stdStatic.readStudents();
                    break;
                case 3:
                    System.out.println(" update students ");
                    stdStatic.updateStudents();
                    break;
                case 4:
                    System.out.println(" delete students ");
                    stdStatic.deleteStudents1();
                    break;
                default:
                    System.out.println("!");
                    isExit = true;
                    break;
            }
        }while (!isExit);

    }
}
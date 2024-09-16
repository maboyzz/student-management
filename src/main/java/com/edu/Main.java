package com.edu;

import com.edu.service.StudentStaticArrayService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        boolean isExit = false;
        boolean isBreak = false;


        do {
            System.out.println("\nStudents management\n");
            System.out.println(" 1.Students Static Array ");
            System.out.println(" 2.Students Dynamic Array");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    do {
                        StudentStaticArrayService stdStatic = new StudentStaticArrayService();
                        System.out.println("Enter the size of the array.");
                        stdStatic.initStudentArray(sc.nextInt());
                        System.out.println("\nStudents Static Array\n");
                        System.out.println(" 1.create students ");
                        System.out.println(" 2.read students ");
                        System.out.println(" 3.update students ");
                        System.out.println(" 4.delete students ");

                        int choice1 = sc.nextInt();
                        switch (choice1) {
                            case 1:
                                System.out.println(" create students ");
                                stdStatic.addStudents();
                                break;
                            case 2:
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
                            case 5:
                                System.out.println("!");
                                isBreak = true;
                                break;
                            default:
                                System.out.println("!");
                                isBreak = true;
                                break;
                        }
                    } while (!isBreak);
                    break;
                case 2:
                    System.out.println(" read students ");
                    break;
                default:
                    isExit = true;
                    break;
            }

        }while (!isExit) ;

    }
}
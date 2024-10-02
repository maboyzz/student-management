package com.edu;

import com.edu.service.StudentDynamicArrayService;
import com.edu.service.StudentStaticArrayService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        boolean isExit = false;
        boolean isBreakStatic = false;
        boolean isBreakDynamic = false;
        StudentDynamicArrayService stdDynamic = new StudentDynamicArrayService();
        StudentStaticArrayService stdStatic = new StudentStaticArrayService();


        do {
            System.out.println("\nStudents management\n");
            System.out.println(" 1.Students Static Array ");
            System.out.println(" 2.Students Dynamic Array");
            System.out.println(" every thing out");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Enter the size of the array.");
                    stdStatic.initStudentArray(sc.nextInt());
                    do {
                        System.out.println("\nStudents Static Array\n");
                        System.out.println(" 1.create students ");
                        System.out.println(" 2.read students ");
                        System.out.println(" 3.update students ");
                        System.out.println(" 4.delete students ");
                        System.out.println(" every thing out");


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
                            default:
                                System.out.println("!");
                                isBreakStatic = true;
                                break;
                        }
                    } while (!isBreakStatic);
                    break;
                case "2":
                    do {
                        System.out.println("\nStudents Dynamic Array\n");
                        System.out.println(" 1.create students ");
                        System.out.println(" 2.read students ");
                        System.out.println(" 3.update students ");
                        System.out.println(" 4.delete students ");
                        System.out.println(" 5.sort students academic ranking %");
                        System.out.println(" 6.sort students GPA %");
                        System.out.println(" every thing out");

                        String choice1 = sc.nextLine();
                        switch (choice1) {
                            case "1":
                                System.out.println(" create students ");
                                stdDynamic.addStudents();
                                break;
                            case "2":
                                System.out.println(" read students ");
                                stdDynamic.readStudents();
                                break;
                            case "3":
                                System.out.println(" update students  ");
                                stdDynamic.updateStudents();
                                break;
                            case "4":
                                System.out.println(" delete students ");
                                stdDynamic.deleteStudents();
                                break;
                            case "5":
                                System.out.println("Sort by academic ranking %");
                                stdDynamic.sortStudentsAcademicRanking();
                                break;
                            case "6":
                                System.out.println("Sort by academic GPA %");
                                stdDynamic.sortStudentsGPA();
                                break;

                            default:
                                System.out.println("!");
                                isBreakDynamic = true;
                                break;
                        }
                    } while (!isBreakDynamic);
                    break;
                default:
                    isExit = true;
                    break;
            }

        } while (!isExit);

    }
}
package com.edu.service;

import com.edu.constants.CommonConstants;
import com.edu.constants.EnumAcademicRanking;
import com.edu.model.Person;
import com.edu.model.Student;
import com.edu.validator.StudentValidator;

import java.time.LocalDate;
import java.util.Scanner;

import static com.edu.constants.CommonConstants.DOB_FORMATTER;
import static com.edu.constants.EnumAcademicRanking.*;
import static com.edu.constants.EnumAcademicRanking.EXCELLENT;
import static com.edu.validator.StudentValidator.*;
import static com.edu.validator.StudentValidator.isValidDob;
import static com.edu.validator.StudentValidator.isValidFullName;

public class StudentStaticArrayService {

    Student[] arrStudent = null;

    public void initStudentArray(int size) {

        arrStudent = new Student[size];

    }

    String checkCode;


    private Student inputStudentInfo() {
        Student st = new Student();
        Scanner sc = new Scanner(System.in);
        String fullName;
        String address;
        String dobText;
        String heightText;
        String weightText;
        String studentCode;
        String schoolName;
        String yearOfCollegeText;
        String gpaText;


        do {
            System.out.println("Enter full name : ");
            fullName = sc.nextLine();

            if (isValidFullName(fullName)) {
                st.setFullName(fullName);
                break;
            }

        } while (true);
        do {

            System.out.println("Enter your birthdate (yyyy-mm-dd) :");
            dobText = sc.nextLine();

            if (isValidDob(dobText)) {

                st.setDateOfBirth(LocalDate.parse(dobText, DOB_FORMATTER));
                break;
            }

        } while (true);
        do {
            System.out.println("Enter your address : ");
            address = sc.nextLine();
            if (isValidAddress(address)) {
                st.setAddress(address);
                break;
            }
        } while (true);
        do {
            System.out.println("Enter your height: ");
            heightText = sc.nextLine();
            if (isValidHeight(heightText)) {
                st.setHeight(Float.parseFloat(heightText));
                break;
            }
        } while (true);
        do {
            System.out.println("Enter your weight : ");
            weightText = sc.nextLine();
            if (isValidWeight(weightText)) {
                st.setWeight(Float.parseFloat(weightText));
                break;
            }
        } while (true);

        tmp:
        do {
            System.out.println("Enter student code : ");
            studentCode = sc.nextLine();
            if (isValidStudentCode(studentCode)) {
                for (int i = 0; i < arrStudent.length; i++) {
                    if (arrStudent[i] != null && arrStudent[i].getCode().equals(studentCode)) {
                        System.out.println("Error: ");
                        continue tmp;
                    }
                }
                st.setCode(studentCode);
                break;
            }

        } while (true);
        do {
            System.out.println("Enter school name :");
            schoolName = sc.nextLine();
            if (isValidSchoolName(schoolName)) {
                st.setSchool(schoolName);
                break;
            }
        } while (true);

        do {
            System.out.println("Enter year of college :");
            yearOfCollegeText = sc.nextLine();
            if (isStartYearOfCollege(yearOfCollegeText)) {
                st.setStartYearOfCollege(Integer.parseInt(yearOfCollegeText));
                break;
            }
        } while (true);

        do {
            System.out.println("Enter GPA : ");
            gpaText = sc.nextLine();
            if (isGpa(gpaText)) {
                st.setGpa(Float.parseFloat(gpaText));
                break;
            }
        } while (true);

        return st;
    }

    private Student updateStudentInfo(Student st) {
        Scanner sc = new Scanner(System.in);
        String fullName;
        String address;
        String dobText;
        String heightText;
        String weightText;
        String studentCode;
        String schoolName;
        String yearOfCollegeText;
        String gpaText;

        boolean isClose = false;
        String choice;

        do {
            System.out.println("What information do you want to edit for the student? :");
            System.out.println("1. edit full name");
            System.out.println("2. edit date of birth");
            System.out.println("3. edit address");
            System.out.println("4. edit height");
            System.out.println("5. edit weight");
            System.out.println("6. edit school name");
            System.out.println("7. edit start year of college");
            System.out.println("8. edit gpa");
            System.out.println("9. out");

            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    do {
                        System.out.println("Enter full name : ");
                        fullName = sc.nextLine();

                        if (isValidFullName(fullName)) {
                            st.setFullName(fullName);
                            break;
                        }

                    } while (true);
                    break;


                case "2":
                    do {

                        System.out.println("Enter your birthdate (yyyy-mm-dd) :");
                        dobText = sc.nextLine();

                        if (isValidDob(dobText)) {

                            st.setDateOfBirth(LocalDate.parse(dobText, DOB_FORMATTER));
                            break;
                        }

                    } while (true);
                    break;
                case "3":
                    do {
                        System.out.println("Enter your address : ");
                        address = sc.nextLine();
                        if (isValidAddress(address)) {
                            st.setAddress(address);
                            break;
                        }
                    } while (true);
                    break;
                case "4":
                    do {
                        System.out.println("Enter your height: ");
                        heightText = sc.nextLine();
                        if (isValidHeight(heightText)) {
                            st.setHeight(Float.parseFloat(heightText));
                            break;
                        }
                    } while (true);
                    break;
                case "5":
                    do {
                        System.out.println("Enter your weight : ");
                        weightText = sc.nextLine();
                        if (isValidWeight(weightText)) {
                            st.setWeight(Float.parseFloat(weightText));
                            break;
                        }
                    } while (true);
                    break;
                case "6":
                    do {
                        System.out.println("Enter school name :");
                        schoolName = sc.nextLine();
                        if (isValidSchoolName(schoolName)) {
                            st.setSchool(schoolName);
                            break;
                        }
                    } while (true);

                    break;
                case "7":
                    do {
                        System.out.println("Enter year of college :");
                        yearOfCollegeText = sc.nextLine();
                        if (isStartYearOfCollege(yearOfCollegeText)) {
                            st.setStartYearOfCollege(Integer.parseInt(yearOfCollegeText));
                            break;
                        }
                    } while (true);
                    break;
                case "8":
                    do {
                        System.out.println("Enter GPA : ");
                        gpaText = sc.nextLine();
                        if (isGpa(gpaText)) {
                            st.setGpa(Float.parseFloat(gpaText));
                            break;
                        }
                    } while (true);

                    break;
                case "9":
                    isClose = true;
                    break;
            }

        } while (!isClose);

        return st;
    }

    public void addStudents() {

        for (int i = 0; i < arrStudent.length; i++) {
            System.out.println("Enter student information : ");
            Student st = inputStudentInfo();
            st.setAcademicRanking(academicRanking(st.getGpa()));
            st.setId(i + 1);
            arrStudent[i] = st;
        }
        System.out.println("Student has been entered");
        for (Student student : arrStudent) {
            if (student != null) {
                System.out.println(student.toString());
            }
        }
    }

    public void readStudents() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter the code to search for");
            checkCode = sc.nextLine();
            if (StudentValidator.isValidStudentCode(checkCode)) {
                for (int i = 0; i < arrStudent.length; i++) {
                    if (arrStudent[i] == null) {
                        System.out.println("The student has no data");
                        return;
                    }
                    if (checkCode.equals(arrStudent[i].getCode())) {
                        System.out.println(arrStudent[i].toString());
                        return;
                    }

                }
                System.out.println("No matching data");
                break;
            }

        } while (true);
    }

    public void updateStudents() {
        Scanner sc = new Scanner(System.in);


        do {
            System.out.println("Enter the code to edit.");
            checkCode = sc.nextLine();
            if (StudentValidator.isValidStudentCode(checkCode)) {
                for (int i = 0; i < arrStudent.length; i++) {
                    if (arrStudent[i] == null) {
                        System.out.println("The student has no data");
                        return;
                    }
                    if (checkCode.equals(arrStudent[i].getCode())) {
                        System.out.println(arrStudent[i]);
                        updateStudentInfo(arrStudent[i]);
                        arrStudent[i].setAcademicRanking(academicRanking(arrStudent[i].getGpa()));
                        System.out.println(arrStudent[i]);
                        return;
                    }

                }
                System.out.println("No matching data");
                break;
            }
        } while (true);


    }

    public void deleteStudents1() {
        Scanner sc = new Scanner(System.in);


        do {
            Integer index = null;
            if (arrStudent == null || arrStudent.length == 0) {
                System.out.println(" The array has no elements");
                return;
            }
            System.out.println("Enter the student code to delete.");
            checkCode = sc.nextLine();
            if (StudentValidator.isValidStudentCode(checkCode)) {
                for (int i = 0; i < arrStudent.length; i++) {
                    if (arrStudent[i] != null && checkCode.equals(arrStudent[i].getCode())) {
                        index = i;
                        break;
                    }
                }
                if (index == null) {
                    System.out.println("No matching data");
                    return;
                }
                System.out.println("Student deleted: " + arrStudent[index].toString());
                if (arrStudent.length >= 2) {
                    for (int i = index; i <= arrStudent.length - 2; i++) {
                        arrStudent[i] = arrStudent[i + 1];
                    }
                }
                arrStudent[arrStudent.length - 1] = null;

                System.out.println("Student list after deletion.");
                for (int i = 0; i < arrStudent.length; i++) {
                    if (arrStudent[i] != null) {
                        System.out.println(arrStudent[i].toString());
                    }
                }
                break;
            }
        } while (true);


    }

    private EnumAcademicRanking academicRanking(float gpa) {

        EnumAcademicRanking check = null;
        if (gpa < 3) {
            check = POOR;
        } else if (gpa >= 3 && gpa < 5) {
            check = BELOW_AVERAGE;
        } else if (gpa >= 5 && gpa < 6.5) {
            check = AVERAGE;
        } else if (gpa >= 6.5 && gpa < 7.5) {
            check = FAIR;
        } else if (gpa >= 7.5 && gpa < 9) {
            check = GOOD;
        } else {
            check = EXCELLENT;
        }

        return check;
    }
}



package com.edu.service;

import com.edu.constants.CommonConstants;
import com.edu.model.Person;
import com.edu.model.Student;
import com.edu.validator.StudentValidator;

import java.time.LocalDate;
import java.util.Scanner;

import static com.edu.constants.CommonConstants.DOB_FORMATTER;
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
            System.out.println("nhap full name : ");
            fullName = sc.nextLine();

            if (isValidFullName(fullName)) {
                st.setFullName(fullName);
                break;
            }

        } while (true);
        do {

            System.out.println("nhap ngay thang nam sinh (yyyy-mm-dd) :");
            dobText = sc.nextLine();

            if (isValidDob(dobText)) {

                st.setDateOfBirth(LocalDate.parse(dobText, DOB_FORMATTER));
                break;
            }

        } while (true);
        do {
            System.out.println("nhap dia chi : ");
            address = sc.nextLine();
            if (isValidAddress(address)) {
                st.setAddress(address);
                break;
            }
        } while (true);
        do {
            System.out.println("nhap chieu cao : ");
            heightText = sc.nextLine();
            if (isValidHeight(heightText)) {
                st.setHeight(Float.parseFloat(heightText));
                break;
            }
        } while (true);
        do {
            System.out.println("nhap can nang : ");
            weightText = sc.nextLine();
            if (isValidWeight(weightText)) {
                st.setWeight(Float.parseFloat(weightText));
                break;
            }
        } while (true);

        tmp:
        do {
            System.out.println("nhap code : ");
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
            System.out.println("nhap truong :");
            schoolName = sc.nextLine();
            if (isValidSchoolName(schoolName)) {
                st.setSchool(schoolName);
                break;
            }
        } while (true);

        do {
            System.out.println("nhap nam theo hoc");
            yearOfCollegeText = sc.nextLine();
            if (StudentValidator.isStartYearOfCollege(yearOfCollegeText)) {
                st.setStartYearOfCollege(Integer.parseInt(yearOfCollegeText));
                break;
            }
        } while (true);

        do {
            System.out.println("nhap diem trung binh : ");
            gpaText = sc.nextLine();
            if (StudentValidator.isGpa(gpaText)) {
                st.setGpa(Float.parseFloat(gpaText));
                break;
            }
        } while (true);

        return st;
    }

    public void addStudents() {

        for (int i = 0; i < arrStudent.length; i++) {
            System.out.println("nhap thong tin sinh vien : ");
            Student st = inputStudentInfo();
            st.setId(i + 1);
            arrStudent[i] = st;
        }
        System.out.println("Sinh viên đã nhập");
        for (Student student : arrStudent) {
            if (student != null) {
                System.out.println(student.toString());
            }
        }
    }

    public void readStudents() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma code sinh vien can tim kiem");
        checkCode = sc.nextLine();
        for (int i = 0; i < arrStudent.length; i++) {
            if (checkCode.equals(arrStudent[i].getCode())) {
                System.out.println(arrStudent[i].toString());
                return;
            }

        }
        System.out.println("khong co du lieu phu hop");
    }
}



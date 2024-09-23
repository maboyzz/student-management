package com.edu.service;

import com.edu.constants.EnumAcademicRanking;
import com.edu.model.Student;
import com.edu.validator.StudentValidator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static com.edu.constants.CommonConstants.DOB_FORMATTER;
import static com.edu.constants.EnumAcademicRanking.*;
import static com.edu.validator.StudentValidator.*;

public class StudentDynamicArrayService {

    ArrayList<Student> studentArrayList = new ArrayList<Student>();


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
                for (Student student : studentArrayList) {
                    if (student != null && student.getCode().equals(studentCode)) {
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
            System.out.println("ban muon sua j :");
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
            switch (choice){
                case "1" :
                    do {
                        System.out.println("Enter full name : ");
                        fullName = sc.nextLine();

                        if (isValidFullName(fullName)) {
                            st.setFullName(fullName);
                            break;
                        }

                    } while (true);
                    break;


                case "2" :
                    do {

                        System.out.println("Enter your birthdate (yyyy-mm-dd) :");
                        dobText = sc.nextLine();

                        if (isValidDob(dobText)) {

                            st.setDateOfBirth(LocalDate.parse(dobText, DOB_FORMATTER));
                            break;
                        }

                    } while (true);
                    break;
                case "3" :
                    do {
                        System.out.println("Enter your address : ");
                        address = sc.nextLine();
                        if (isValidAddress(address)) {
                            st.setAddress(address);
                            break;
                        }
                    } while (true);
                    break;
                case "4" :
                    do {
                        System.out.println("Enter your height: ");
                        heightText = sc.nextLine();
                        if (isValidHeight(heightText)) {
                            st.setHeight(Float.parseFloat(heightText));
                            break;
                        }
                    } while (true);
                    break;
                case "5" :
                    do {
                        System.out.println("Enter your weight : ");
                        weightText = sc.nextLine();
                        if (isValidWeight(weightText)) {
                            st.setWeight(Float.parseFloat(weightText));
                            break;
                        }
                    } while (true);
                    break;
                case "6" :
                    do {
                        System.out.println("Enter school name :");
                        schoolName = sc.nextLine();
                        if (isValidSchoolName(schoolName)) {
                            st.setSchool(schoolName);
                            break;
                        }
                    } while (true);

                    break;
                case "7" :
                    do {
                        System.out.println("Enter year of college :");
                        yearOfCollegeText = sc.nextLine();
                        if (isStartYearOfCollege(yearOfCollegeText)) {
                            st.setStartYearOfCollege(Integer.parseInt(yearOfCollegeText));
                            break;
                        }
                    } while (true);
                    break;
                case "8" :
                    do {
                        System.out.println("Enter GPA : ");
                        gpaText = sc.nextLine();
                        if (isGpa(gpaText)) {
                            st.setGpa(Float.parseFloat(gpaText));
                            break;
                        }
                    } while (true);

                    break;
                case "9" :
                    isClose = true;
                    break;
            }

        }while (!isClose);

        return st;
    }

    int ID = 0;

    public void addStudents() {

        System.out.println("Enter student information : ");
        Student st = inputStudentInfo();
        st.setAcademicRanking(academicRanking(st.getGpa()));
        st.setId(getMaxId() + 1);
        studentArrayList.add(st);
        System.out.println(st);
    }

    private int getMaxId() {


        if (studentArrayList == null) {
            return 0;
        }
        int maxId = 0;
        for (Student student : studentArrayList) {
            if (student != null && student.getId() > maxId) {
                maxId = student.getId();
            }
        }
        return maxId;

    }

    public void readStudents() {

        if (studentArrayList == null) {
            System.out.println("Error : No matching data ");
            return;
        }
        Scanner sc = new Scanner(System.in);
        String code;

        do {
            System.out.println("Enter the code to search for");
            code = sc.nextLine();
            if (StudentValidator.isValidStudentCode(code)) {
                for (Student student : studentArrayList) {
                    if (student == null) {
                        System.out.println("The student has no data ");
                        return;
                    }
                    if (code.equals(student.getCode())) {
                        System.out.println("\n" + student.toString());
                        return;
                    }
                }
                System.out.println("No matching data ");
                break;
            }

        } while (true);

    }

    public void updateStudents() {
        Student st;
        if (studentArrayList == null) {
            System.out.println("Error : No matching data ");
            return;
        }
        Scanner sc = new Scanner(System.in);
        String code;

        do {
            System.out.println("Enter the code to edit.");
            code = sc.nextLine();
            if (StudentValidator.isValidStudentCode(code)) {
                for (Student student : studentArrayList) {
                    if (student == null) {
                        System.out.println("The student has no data ");
                        return;
                    }
                    if (code.equals(student.getCode())) {

                        System.out.println(student);
                        updateStudentInfo(student);
                        student.setAcademicRanking(academicRanking(student.getGpa()));

                        System.out.println("\n" + student);
                        return;
                    }
                }
                System.out.println("No matching data ");
                break;
            }

        } while (true);
    }

    public void deleteStudents() {
        if (studentArrayList == null) {
            System.out.println("Error : No matching data ");
            return;
        }
        Scanner sc = new Scanner(System.in);
        String code;

        do {
            System.out.println("Enter the student code to delete");
            code = sc.nextLine();
            if (StudentValidator.isValidStudentCode(code)) {
                for (Student student : studentArrayList) {
                    if (code.equals(student.getCode())) {
                        if (student == null) {
                            System.out.println("The student has no data ");
                            return;
                        }
                        System.out.println("Student deleted:" + student.toString());
                        studentArrayList.remove(student);

                        System.out.println("Student list after deletion.");
                        System.out.println(studentArrayList);
                        return;
                    }
                }
                System.out.println("No matching data ");
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
        }else {
            check = EXCELLENT;
        }

        return check;
    }

}

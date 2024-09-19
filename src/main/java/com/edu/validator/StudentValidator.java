package com.edu.validator;

import com.edu.constants.CommonConstants;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

import static com.edu.constants.CommonConstants.DOB_FORMATTER;
import static com.edu.constants.CommonConstants.NUMBER_PATTERN;

public class StudentValidator {

    private static final int MAXIMUM_LENGTH_OF_FULL_NAME = 100;
    private static final int MINIMUM_YEAR_OF_BIRTH = 1900;
    private static final int MAXIMUM_LENGTH_OF_ADDRESS = 300;
    private static final double MAXIMUM_OF_HEIGHT = 300.0;
    private static final double MINIMUM_OF_HEIGHT = 50.0;
    private static final double MAXIMUM_OF_WEIGHT = 1000.0;
    private static final double MINIMUM_OF_WEIGHT = 5.0;

    private static final int STUDENT_CODE_LENGTH = 10;
    private static final int MAXIMUM_LENGTH_OF_SCHOOL_NAME = 200;

    private static final int MINIMUM_YEAR_START_OF_COLLEGE = 1900;
    private static final int YEAR_START_OF_COLLEGE_LENGTH = 4;
    private static final double MAXIMUM_OF_GPA = 10.0;
    private static final double MINIMUM_OF_GPA = 0.0;

    private static final String ERROR_MESS_CANNOT_BE_BLANK = "Error: %S cannot be left blank";

    public static boolean isValidFullName(String fullName) {

        if (fullName == null || fullName.isEmpty() || fullName.trim().isEmpty()) {
            System.out.println(String.format(ERROR_MESS_CANNOT_BE_BLANK, "Full name"));
            return false;
        }
        if (fullName.length() > MAXIMUM_LENGTH_OF_FULL_NAME) {
            System.out.println("Error: Full name exceeds maximum length");
            return false;
        }
        return true;
    }

    public static boolean isValidDob(String dobText) {

        if (dobText == null || dobText.isEmpty() || dobText.trim().isEmpty()) {
            System.out.println(String.format(ERROR_MESS_CANNOT_BE_BLANK, "Date of birth"));
            return false;
        }
        try {
            LocalDate dob = LocalDate.parse(dobText, DOB_FORMATTER);

            if (dob.getYear() < MINIMUM_YEAR_OF_BIRTH) {
                System.out.println("Error : Year of birth must be from 1900");
                return false;
            }
        } catch (DateTimeParseException e) {
            System.out.println("Error: Incorrect date of birth format (yyyy-mm-dd)");
            return false;
        }
        return true;

    }

    public static boolean isValidAddress(String address) {
        if (address == null || address.isEmpty() || address.trim().isEmpty()) {
            System.out.println(String.format(ERROR_MESS_CANNOT_BE_BLANK, "address"));
            return false;
        }
        if (address.length() > MAXIMUM_LENGTH_OF_ADDRESS) {
            System.out.println("Error: Address exceeds maximum length");
            return false;
        }

        return true;
    }

    public static boolean isValidHeight(String heightText) {
        if (heightText == null || heightText.isEmpty() || heightText.trim().isEmpty()) {
            System.out.println(String.format(ERROR_MESS_CANNOT_BE_BLANK, "Height"));
            return false;
        }
        float height = Float.parseFloat(heightText);
        if (height > MAXIMUM_OF_HEIGHT || height < MINIMUM_OF_HEIGHT) {
            System.out.println("Error: Enter height out of bounds (50.0 - 300.0)");
            return false;
        }
        return true;
    }

    public static boolean isValidWeight(String weightText) {
        if (weightText == null || weightText.isEmpty() || weightText.trim().isEmpty()) {
            System.out.println(String.format(ERROR_MESS_CANNOT_BE_BLANK, "Weight"));
            return false;
        }
        float height = Float.parseFloat(weightText);
        if (height > MAXIMUM_OF_WEIGHT || height < MINIMUM_OF_WEIGHT) {
            System.out.println("Error: Enter Weight out of bounds (5.0 - 1000.0)");
            return false;
        }
        return true;
    }

    public static boolean isValidStudentCode(String code) {
        if (code == null || code.isEmpty() || code.trim().isEmpty()) {
            System.out.println(String.format(ERROR_MESS_CANNOT_BE_BLANK, "Student code"));
            return false;
        }
        if (code.length() != STUDENT_CODE_LENGTH) {
            System.out.println("Error: Incorrectly entered student code structure");
            return false;
        }

        return true;
    }

    public static boolean isValidSchoolName(String schoolName) {
        if (schoolName == null || schoolName.isEmpty() || schoolName.trim().isEmpty()) {
            System.out.println(String.format(ERROR_MESS_CANNOT_BE_BLANK, "School Name"));
            return false;
        }
        if (schoolName.length() > MAXIMUM_LENGTH_OF_SCHOOL_NAME) {
            System.out.println("Error: School name exceeds maximum length");
            return false;
        }

        return true;
    }

    public static boolean isStartYearOfCollege(String yearOfCollegeText) {
        if (yearOfCollegeText == null || yearOfCollegeText.isEmpty() || yearOfCollegeText.trim().isEmpty()) {
            System.out.println(String.format(ERROR_MESS_CANNOT_BE_BLANK, "Start year of college"));
            return false;
        }
        Pattern pattern = Pattern.compile(NUMBER_PATTERN);
        if (!pattern.matcher(yearOfCollegeText).matches()) {
            System.out.println("Error: year of college must be a number");
            return false;

        }
        if (yearOfCollegeText.length() != 4) {
            System.out.println("Error: Entered wrong format year of college ");
            return false;
        }
        if (Integer.parseInt(yearOfCollegeText) < MINIMUM_YEAR_START_OF_COLLEGE) {
            System.out.println("Error: Entered wrong year of college (1900)");
            return false;
        }

        return true;
    }

    public static boolean isGpa(String gpa) {
        if (gpa == null || gpa.isEmpty() || gpa.trim().isEmpty()) {
            System.out.println(String.format(ERROR_MESS_CANNOT_BE_BLANK, "GPA"));
            return false;
        }
        if (Integer.parseInt(gpa) > MAXIMUM_OF_GPA || Integer.parseInt(gpa) < MINIMUM_OF_GPA) {
            System.out.println("Error: Enter GPA out of bounds (0.0 - 10.0)");
            return false;
        }

        return true;
    }


}

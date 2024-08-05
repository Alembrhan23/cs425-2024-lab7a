package edu.miu.cs.cs425.studentrecordsmgmtapp;

import edu.miu.cs.cs425.studentrecordsmgmtapp.model.Student;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class MyStudentRecordsMgmtApp {

    public static void main(String[] args) {

        Student s1 = new Student(110001, "Dave", LocalDate.of(1951, 11, 18));
        Student s2 = new Student(110002, "Anna", LocalDate.of(1990, 12, 7));
        Student s3 = new Student(110003, "Erica", LocalDate.of(1974, 1, 31));
        Student s4 = new Student(110004, "Carlos", LocalDate.of(2009, 8, 22));
        Student s5 = new Student(110005, "Bob", LocalDate.of(1994, 8, 5));

        Student[] students = {s1, s2, s3, s4, s5};

        printListOfStudents(students);


        List<Student> platinumAlumniStudents = getListOfPlatinumAlumniStudents(students);

        System.out.println("List of Platinum Students:");
        for (Student student : platinumAlumniStudents) {
            System.out.println(student.getName() + " Admission Date: " + student.getDateOfAdmission());
        }


        Integer[] arr4 = {11, 11};
        Integer[] arr3 = {3, 3, 3, 3, 3};
        Integer[] arr1 = {1, 2, 3, 4, 5};
        Integer[] arr2 = {19, 9, 11, 0, 12};


        helloWorld(arr1);
        helloWorld(arr2);
        helloWorld(arr3);
        helloWorld(arr4);


        Integer [] inputArray1 = {1, 2, 3, 4, 5};
        Integer [] inputArray2 = {19, 9, 11, 0, 12};

        System.out.println("Second biggest: " + findSecondBiggest(inputArray1));
        System.out.println("Second biggest: " + findSecondBiggest(inputArray2));


    }

    public static void printListOfStudents(Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static List<Student> getListOfPlatinumAlumniStudents(Student[] students) {
        List<Student> platinumAlumniStudents = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        for (Student student : students) {
            if (Period.between(student.getDateOfAdmission(), currentDate).getYears() >= 30) {
                platinumAlumniStudents.add(student);
            }
        }
        return platinumAlumniStudents;
    }

    public static void helloWorld(Integer [] inputIntegers){
        for(Integer integer: inputIntegers){
            if(integer%5==0 && integer%7==0)
                System.out.println("Hello World");
            else if(integer%5==0)
                System.out.println("World");
        }
    }
    public static int findSecondBiggest(Integer [] inputIntegers){
        if (inputIntegers == null || inputIntegers.length < 2) {
            throw new IllegalArgumentException("Input Array must contain at least two elements");
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest  = Integer.MIN_VALUE;

        for (int num : inputIntegers) {
            if (num > largest ) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        if (secondLargest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Input Array must contain at least two distinct elements");
        }

        return secondLargest;
    }
}

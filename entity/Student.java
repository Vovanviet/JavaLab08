package vn.com.entity;

import java.util.Scanner;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private double mark;
    public Student() {
    }

    public Student(int id, String firstName, String lastName, double mark) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mark = mark;
    }
    public void scanInfo(){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter ID:");
        this.id= input.nextInt();
        System.out.println("Enter First Name:");
        this.firstName=input.nextLine();
        System.out.println("Enter Last Name:");
        this.lastName=input.nextLine();
        System.out.println("Enter mark:");
        this.mark=input.nextDouble();
    }
    public void printInfo(){
        System.out.printf("%3d | %s | %s | %5f\n",getId(),getFirstName(),getLastName(),getMark());
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getMark() {
        return mark;
    }
}

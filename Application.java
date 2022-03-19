package vn.com;

import vn.com.entity.Student;
import vn.com.model.StudentList;

import java.util.ArrayList;
import java.util.Scanner;
class AppException extends java.lang.Exception{
    private static final long serialVersionUID=1L;
    public AppException (String str){
        super();
        System.out.println(str);
    }
}

public class Application {
    private static Scanner input=new Scanner(System.in);
    private static StudentList list;
    public static void menu(){
        System.out.println("1.Add a new student to the list");
        System.out.println("2.Delete student from the list");
        System.out.println("3.Search by name");
        System.out.println("4.Search by id");
        System.out.println("5.Print student info descending order of mark");
        System.out.println("6.Exit");
    }
    public static void main(String[] args) throws AppException {
        list=new StudentList();
        menu();
        while (true){
            int choice;
            System.out.println("Choice:");
            choice=input.nextInt();
            if (choice==1){
                addStudent();
                menu();
            }
            else if (choice==2){
                deleteStudent();                menu();

            }else if (choice==3){
                searchByName();                menu();

            }else if (choice==4){
                searchById();                menu();

            }else if (choice==5){
                printSorted();                menu();

            }else if (choice==6){
                System.exit(0);
            }
        }
    }
    public static void addStudent() throws AppException{
        int id;
        String fn;
        String ln;
        double mark;
        System.out.println("Enter Student ID");
        id=input.nextInt();
        System.out.println("Enter First Name:");
        fn=input.next();
        System.out.println("Enter Last Name:");
        ln=input.next();
        System.out.println("Enter Mark");
        mark=input.nextDouble();
        if (id>=0){
            if (fn.equals("")){
                if (ln.equals("")){
                    if (mark>=0){
                        Student s=new Student(id,fn,ln,mark);
                        list.add(s);
                    }else {
                        throw new AppException("Mark Illegal");
                    }
                }else {
                    throw new AppException("Last Name Illegal");
                }
            }else {
                throw new AppException("First Name Illegal");

            }
        }else {
            throw new AppException(" ID Illegal");
        }

    }
    public static void deleteStudent(){
        int id;
        System.out.println("Enter Student ID");
        id=input.nextInt();
        list.remove(id);
    }
    public static void searchByName(){
        String name;
        System.out.println("Enter a name:");
        name= input.next();
        ArrayList<Student>found=list.findByName(name);
        list.showList(found);
    }
    public static void searchById(){
        int id;
        System.out.println("Enter Student ID");
        id=input.nextInt();
        Student s=list.findById(id);
        if (s==null){
            System.out.println("Not Found");
        }else {
            s.printInfo();
        }
    }
    public static void printSorted(){
        list.sortByMarks();
        list.showList();
    }
}

package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
     StudentDAO dao = new StudentDAO();
     Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== STUDENT CRUD =====");
            System.out.println("1. Add student");
            System.out.println("2. Get and see all students");
            System.out.println("3. Upate student");
            System.out.println("4. Delete student");
            System.out.println("5. Find student by ID");
            System.out.println("0. Exit");
            System.out.print("Please choose: ");

            int choice = sc.nextInt();
            sc.nextLine();
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Age: ");
                        int age = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Email: ");
                        String email = sc.nextLine();

                        dao.addStudent(new Student(name, age, email));
                        break;

                    case 2:
                        dao.getAllStudent();
                        break;

                    case 3:
                        System.out.print("ID's student: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("New name: ");
                        String newName = sc.nextLine();

                        System.out.print("New age: ");
                        int newAge = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Email update: ");
                        String newEmail = sc.nextLine();

                        dao.updateStudent(updateId, newName, newAge, newEmail);
                        break;

                    case 4:
                        System.out.print("ID needed to be deleted: ");
                        int deleteId = sc.nextInt();

                        dao.deleteStudent(deleteId);
                        break;
                    case 5 :
                        System.out.println("Enter id");
                        int findid = sc.nextInt();
                        dao.findById(findid);
                        System.out.println("Student found!");
                        break;

                    case 0:
                        System.out.println("Exit.");
                        return;

                    default:
                        System.out.println("Invalid choice please try again");
                }
            }
        catch (Exception e) {
                    e.printStackTrace();
                }
                }

                }
            }







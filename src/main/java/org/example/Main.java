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
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Xem danh sách");
            System.out.println("3. Cập nhật sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = sc.nextInt();
            sc.nextLine();
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Tên: ");
                        String name = sc.nextLine();

                        System.out.print("Tuổi: ");
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
                        System.out.print("ID cần sửa: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Tên mới: ");
                        String newName = sc.nextLine();

                        System.out.print("Tuổi mới: ");
                        int newAge = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Email mới: ");
                        String newEmail = sc.nextLine();

                        dao.updateStudent(updateId, newName, newAge, newEmail);
                        break;

                    case 4:
                        System.out.print("ID cần xóa: ");
                        int deleteId = sc.nextInt();

                        dao.deleteStudent(deleteId);
                        break;

                    case 0:
                        System.out.println("Thoát chương trình.");
                        return;

                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            }
        catch (Exception e) {
                    e.printStackTrace();
                }
                }

                }
            }







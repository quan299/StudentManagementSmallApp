package org.example;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class StudentDAO {
    public void getAllStudent() throws Exception {
        String sql = "select * from students";

        try (Connection conn = DatabaseConnection.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs =  st.executeQuery(sql)
        ) {
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getInt("age") + " " +
                                rs.getString("email")
                );
            }

        }

    }
    public void addStudent(Student student) throws Exception {
        if (!student.getEmail().endsWith("@gmail.com")) {
            throw new IllegalArgumentException(
                    "Email phải có đuôi @gmail.com"
            );
        }
        String sql = "Insert into students(name,age,email) values(?,?,?)";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getEmail());
            ps.executeUpdate();
            System.out.println("Updated");
        }

    }
    public void updateStudent(int id, String name, int age, String email) throws Exception {
        String sql = "UPDATE students SET name = ?, age = ?, email = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, email);
            ps.setInt(4, id);
            ps.executeUpdate();

            System.out.println("Cập nhật sinh viên thành công!");
        }
    }

    public void deleteStudent(int id) throws Exception {
        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Xóa sinh viên thành công!");
        }
    }
    public void findById(int id) throws Exception {

        String sql = "SELECT * FROM students WHERE id = ?";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Tên: " + rs.getString("name"));
                System.out.println("Tuổi: " + rs.getInt("age"));
                System.out.println("Email: " + rs.getString("email"));

            } else {
                System.out.println("Không tìm thấy sinh viên!");
            }
        }
    }
}

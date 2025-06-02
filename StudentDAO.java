package dao;

import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";  // TODO: change your_database
    private static final String USER = "your_username";                            // TODO: change your_username
    private static final String PASSWORD = "your_password";                        // TODO: change your_password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static Student authenticateStudent(String admissionNo, String password) {
        Student student = null;
        String query = "SELECT * FROM students WHERE admission_no = ? AND password = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, admissionNo.trim());
            ps.setString(2, password.trim());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                student = extractStudentFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    private static Student extractStudentFromResultSet(ResultSet rs) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setAdmissionNo(rs.getString("admission_no"));
        student.setName(rs.getString("name"));
        student.setEmail(rs.getString("email"));
        student.setCourse(rs.getString("course"));
        student.setFeeStatus(rs.getString("fee_status"));
        student.setGrades(rs.getString("grades"));
        student.setResult(rs.getString("result"));
        return student;
    }

    // Add new student (optional, requires password parameter)
    public static boolean addStudent(Student student, String password) {
        String query = "INSERT INTO students (admission_no, password, name, email, course, fee_status, grades, result) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, student.getAdmissionNo());
            ps.setString(2, password);
            ps.setString(3, student.getName());
            ps.setString(4, student.getEmail());
            ps.setString(5, student.getCourse());
            ps.setString(6, student.getFeeStatus());
            ps.setString(7, student.getGrades());
            ps.setString(8, student.getResult());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Other DAO methods like update, delete, getAll, etc. can remain same or add as needed

}

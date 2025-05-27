package ui;

import dao.StudentDAO;
import model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class StudentManagementUI extends JFrame {
    private JTextField nameField, emailField, courseField;

    public StudentManagementUI() {
        setTitle("Student Management System");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);

        JLabel courseLabel = new JLabel("Course:");
        courseField = new JTextField(20);

        JButton submitButton = new JButton("Add Student");
        submitButton.addActionListener(this::handleSubmit);

        gbc.gridx = 0; gbc.gridy = 0;
        add(nameLabel, gbc);
        gbc.gridx = 1;
        add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        add(emailLabel, gbc);
        gbc.gridx = 1;
        add(emailField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        add(courseLabel, gbc);
        gbc.gridx = 1;
        add(courseField, gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        add(submitButton, gbc);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void handleSubmit(ActionEvent e) {
        String name = nameField.getText();
        String email = emailField.getText();
        String course = courseField.getText();

        if (name.isEmpty() || email.isEmpty() || course.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
            return;
        }

        Student student = new Student(name, email, course);
        StudentDAO dao = new StudentDAO();

        if (dao.addStudent(student)) {
            JOptionPane.showMessageDialog(this, "Student added successfully!");
            nameField.setText("");
            emailField.setText("");
            courseField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Error adding student.");
        }
    }
}

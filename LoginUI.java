package ui;

import dao.StudentDAO;
import model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginUI extends JFrame {

    private JTextField admissionNoField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginUI() {
        setTitle("Student Portal Login");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Background gradient panel
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(72, 61, 139); // Dark Slate Blue
                Color color2 = new Color(123, 104, 238); // Medium Slate Blue
                int w = getWidth();
                int h = getHeight();
                GradientPaint gp = new GradientPaint(0, 0, color1, w, h, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        backgroundPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel titleLabel = new JLabel("Student Portal Login");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        backgroundPanel.add(titleLabel, gbc);

        // Admission No
        JLabel admissionLabel = new JLabel("Admission No:");
        admissionLabel.setForeground(Color.WHITE);
        admissionLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        gbc.gridy = 1; gbc.gridwidth = 1; gbc.gridx = 0;
        backgroundPanel.add(admissionLabel, gbc);

        admissionNoField = new JTextField(20);
        gbc.gridx = 1;
        backgroundPanel.add(admissionNoField, gbc);

        // Password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        gbc.gridx = 0; gbc.gridy = 2;
        backgroundPanel.add(passwordLabel, gbc);

        passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        backgroundPanel.add(passwordField, gbc);

        // Login Button
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        loginButton.setBackground(new Color(70, 130, 180)); // Steel Blue
        loginButton.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        backgroundPanel.add(loginButton, gbc);

        loginButton.addActionListener(this::handleLogin);

        add(backgroundPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void handleLogin(ActionEvent e) {
        String admissionNoInput = admissionNoField.getText().trim();
        String passwordInput = new String(passwordField.getPassword()).trim();

        if (admissionNoInput.isEmpty() || passwordInput.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter admission number and password", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Student student = StudentDAO.authenticateStudent(admissionNoInput, passwordInput);
        if (student != null) {
            JOptionPane.showMessageDialog(this, "Login successful! Welcome " + student.getName());
            new StudentManagementUI(student);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid admission number or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginUI::new);
    }
}

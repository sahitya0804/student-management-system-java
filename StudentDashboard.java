package ui;

import model.Student;

import javax.swing.*;
import java.awt.*;

public class StudentDashboard extends JFrame {
    private Student student;

    public StudentDashboard(Student student) {
        this.student = student;

        setTitle("Student Dashboard");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(58, 123, 213),
                        0, getHeight(), new Color(0, 210, 255));
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(null);

        JLabel heading = new JLabel("Welcome, " + student.getName());
        heading.setFont(new Font("Arial", Font.BOLD, 28));
        heading.setForeground(Color.WHITE);
        heading.setBounds(50, 30, 500, 40);
        panel.add(heading);

        // 📋 Result Button
        JButton resultBtn = new JButton("View Result");
        resultBtn.setBounds(80, 100, 200, 40);
        resultBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Result: " + student.getResult());
        });

        // 💸 Fee Button
        JButton feeBtn = new JButton("Fee Status");
        feeBtn.setBounds(80, 160, 200, 40);
        feeBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Fee Status: " + student.getFeeStatus());
        });

        // 📈 Grades Button
        JButton gradeBtn = new JButton("View Grades");
        gradeBtn.setBounds(80, 220, 200, 40);
        gradeBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Grades: " + student.getGrades());
        });

        // 🤖 AI Chatbot (right side)
        JTextArea chatArea = new JTextArea("🤖 Hello! I'm your AI Assistant.\nAsk me anything!");
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setBounds(400, 100, 350, 350);
        panel.add(scrollPane);

        JTextField userInput = new JTextField();
        userInput.setBounds(400, 470, 260, 30);
        panel.add(userInput);

        JButton sendBtn = new JButton("Send");
        sendBtn.setBounds(670, 470, 80, 30);
        sendBtn.addActionListener(e -> {
            String userMsg = userInput.getText().trim();
            if (!userMsg.isEmpty()) {
                chatArea.append("\nYou: " + userMsg);
                String response = getAIResponse(userMsg.toLowerCase(), student);
                chatArea.append("\nBot: " + response);
                userInput.setText("");
            }
        });

        panel.add(resultBtn);
        panel.add(feeBtn);
        panel.add(gradeBtn);
        panel.add(sendBtn);

        add(panel);
        setVisible(true);
    }

    // Simple AI Chatbot responses
    private String getAIResponse(String msg, Student s) {
        if (msg.contains("fee")) return "Your fee status is: " + s.getFeeStatus();
        if (msg.contains("result")) return "Your result is: " + s.getResult();
        if (msg.contains("grade") || msg.contains("marks")) return "Your grade is: " + s.getGrades();
        if (msg.contains("hello") || msg.contains("hi")) return "Hi " + s.getName() + "! How can I help?";
        return "Sorry, I didn't understand. Try asking about result, fee or grades.";
    }
}

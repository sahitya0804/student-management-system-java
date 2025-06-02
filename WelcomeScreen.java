package ui;

import model.Student;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class WelcomeScreen extends JFrame {
    private JLabel welcomeLabel;
    private String fullMessage;
    private int charIndex = 0;

    public WelcomeScreen(Student student) {
        setTitle("Welcome");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        // Panel with custom background
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(0, 191, 255),
                        0, getHeight(), new Color(72, 61, 139));
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(new BorderLayout());

        welcomeLabel = new JLabel("", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
        welcomeLabel.setForeground(Color.WHITE);

        panel.add(welcomeLabel, BorderLayout.CENTER);
        add(panel);
        setVisible(true);

        // Full welcome message
        fullMessage = "Welcome, " + student.getName() + "!";
        animateText(student);
    }

    private void animateText(Student student) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (charIndex < fullMessage.length()) {
                    welcomeLabel.setText(fullMessage.substring(0, charIndex + 1));
                    charIndex++;
                } else {
                    timer.cancel();
                    // Wait 1 sec then open dashboard
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            dispose();
                            new StudentDashboard(student); // 👈 Show main dashboard
                        }
                    }, 1000);
                }
            }
        }, 0, 100); // Speed: 100ms per character
    }
}

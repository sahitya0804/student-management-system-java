import ui.LoginUI;

public class main {
    public static void main(String[] args) {
        // Launch the Login UI
        javax.swing.SwingUtilities.invokeLater(() -> {
            new LoginUI();
        });
    }
}

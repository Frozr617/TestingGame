import javax.swing.*;

public class GUI{
  public static JFrame mainWindow;

  public static void main(String[] args) {
    gui();
  }
  public static void gui() {
    mainWindow = new JFrame("Vovik");
    mainWindow.setSize(150, 100);
    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainWindow.setVisible(true);
    welcomeScreen();
  }
  public static void welcomeScreen() {
    JPanel welcomeWindow = new JPanel();
    JLabel welcomeLabel = new JLabel("Welcome");
    JButton welcomeButton = new JButton("Start");
    welcomeWindow.add(welcomeLabel);
    welcomeWindow.add(welcomeButton);
    mainWindow.add(welcomeWindow);
  }
}

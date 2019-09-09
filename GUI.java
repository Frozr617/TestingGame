import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class GUI{
  public static JFrame mainWindow;
  public static File saveForStory;
  public static File saveForInfinity;

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
    welcomeButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        mainWindow.setSize(200, 175);
        mainWindow.remove(welcomeWindow);
        choosingMode();
      }
    });
    welcomeWindow.add(welcomeLabel);
    welcomeWindow.add(welcomeButton);
    mainWindow.add(welcomeWindow);
  }
  public static void choosingMode() {

    saveForStory = new File("./save.txt");
    saveForInfinity = new File("./saveForInfinity.txt");

    JPanel modes = new JPanel();
    JLabel choose = new JLabel("Виберіть режим гри: ");
    JButton newGameInfinity = new JButton("New Infinity Game");
    newGameInfinity.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try{
          saveForInfinity.createNewFile();
        }
        catch(IOException ev) {
          System.out.println("Error");
        }
      }
    });
    JButton newGameStory = new JButton("New Story Game");
    newGameStory.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try{
        saveForStory.createNewFile();
        }
        catch(IOException ev) {
          System.out.println("Error");
        }
      }
    });


    if (saveForStory.exists()) {
      JButton continueGame = new JButton("Continue");
      continueGame.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          selectSave();
        }
      });
      modes.add(continueGame);
    }
    modes.add(newGameInfinity);
    modes.add(newGameStory);

    if (saveForStory.exists()) {
      JButton deleteSave = new JButton("Delete Save");
      deleteSave.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          saveForStory.delete();
        }
      });
      modes.add(deleteSave);
    }
    mainWindow.add(modes);
  }
  public static void selectSave(){
    JFrame whatSave = new JFrame("Select save");
    whatSave.setSize(200, 175);
    JPanel saveLoad = new JPanel();
    JLabel selectSave = new JLabel("Select save to load: ");
    JButton storySave = new JButton("Story Mode Save");
    if (saveForInfinity.exists()) {
      JButton infinitySave = new JButton("Infinity Mode Save");
      saveLoad.add(infinitySave);
    }
    saveLoad.add(selectSave);
    saveLoad.add(storySave);
    whatSave.add(saveLoad);
    whatSave.setVisible(true);
  }
}

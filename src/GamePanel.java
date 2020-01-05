//import javax.swing.*;
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import javax.swing.JPanel;
//import javax.swing.Timer;
//
//
//public class GamePanel extends JPanel {
//
//    private JMenuBar menuBar;
//    private JMenu file;
//    private JMenuItem save;
//    private JMenuItem load;
//    private JMenuItem newGame;
//    private JMenuItem exitGame;
//    private ButtonListener listener;
//    private Timer timer;
//    private Player player;
//    private final int DELAY = 10;
//
//    public GamePanel(){
//
//        // Setup JMenus
//        menuBar = new JMenuBar();
//        file = new JMenu("File");
//        save = new JMenuItem("Save Game");
//        load = new JMenuItem("Load Game");
//        exitGame = new JMenuItem("Exit Game");
//        newGame = new JMenuItem("New Game");
//
//        // Setting up menu bar
//        menuBar.add(file);
//        file.add(newGame);
//        file.add(save);
//        file.add(load);
//        file.add(exitGame);
//
//        // Setting up listeners
//        listener = new ButtonListener();
//        save.addActionListener(listener);
//        load.addActionListener(listener);
//        newGame.addActionListener(listener);
//        exitGame.addActionListener(listener);
//
//        player = new Player();
//
//        timer = new Timer(DELAY, this);
//        timer.start();
//
//    }
//
//    /*******************************************************************
//     * Getter Method called in GameFrame.java for placing bar accordingly
//     *
//     * @return menuBar returns JMenuBar
//     ******************************************************************/
//    public JMenuBar getJMenuBar() {
//        return menuBar;
//    }
//
//    /*******************************************************************
//     * Action Listener class that controls JMenu options i.e saveGame,
//     * loadGame, newGame
//     ******************************************************************/
//    private class ButtonListener implements ActionListener {
//        public void actionPerformed(ActionEvent event) {
//
//            if (event.getSource() == save) {
//                //saveGame();
//            }
//            if (event.getSource() == load) {
//                //loadGame();
//            }
//            if (event.getSource() == newGame) {
//                //newGame();
//            }
//
//            if (event.getSource() == exitGame) {
//                System.exit(0);
//            }
//        }
//
//    }
//}
//

package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GamePanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private JMenuBar menuBar;
    private JMenu file;
    private JMenuItem save;
    private JMenuItem load;
    private JMenuItem newGame;
    private JMenuItem exitGame;
    private ButtonListener listener;

    public GamePanel(){
//        this.setRequestFocusEnabled(true);
//        this.setSize(WIDTH, HEIGHT);
//        this.setLayout(null);
//        this.setBackground(Color.BLACK);

        // Setup JMenus
        menuBar = new JMenuBar();
        file = new JMenu("File");
        save = new JMenuItem("Save Game");
        load = new JMenuItem("Load Game");
        exitGame = new JMenuItem("Exit Game");
        newGame = new JMenuItem("New Game");

        // add(menuBar);
        menuBar.add(file);
        file.add(newGame);
        file.add(save);
        file.add(load);
        file.add(exitGame);


        // Listeners
        listener = new ButtonListener();
        save.addActionListener(listener);
        load.addActionListener(listener);
        newGame.addActionListener(listener);
        exitGame.addActionListener(listener);

    }

    /*******************************************************************
     * Getter Method called in GameFrame.java for placing bar accordingly
     *
     * @return menuBar returns JMenuBar
     ******************************************************************/
    public JMenuBar getJMenuBar() {
        return menuBar;
    }

    /*******************************************************************
     * Action Listener class that controls JMenu options i.e saveGame,
     * loadGame, newGame
     ******************************************************************/

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == save) {
                //saveGame();
            }
            if (event.getSource() == load) {
                //loadGame();
            }
            if (event.getSource() == newGame) {
                //newGame();
            }

            if (event.getSource() == exitGame) {
                System.exit(0);
            }


        }

    }
}


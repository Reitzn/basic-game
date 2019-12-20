
import gui.GamePanel;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static final int WIDTH=1280;
    public static final int HEIGHT=640;

    public static void main(String[] args){
        JFrame frame = new JFrame();

        //set the operation that will happen when closing the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set the title of the frame
        frame.setTitle("Basic Game");

        //initialize the game panel
        GamePanel gamePanel = new GamePanel();

        //set the size of the frame
        frame.setSize(WIDTH,HEIGHT);

        //set frame to appear at the center of the screen
        frame.setLocation((int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth()-WIDTH)/2),
                ((int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-HEIGHT)/2));

        //make the frame impossible to resize
        frame.setResizable(false);

        //adds the menu bar to the frame
        frame.setJMenuBar(gamePanel.getJMenuBar());

        //adds the game panel to the content pane
        frame.getContentPane().add(gamePanel);

        //makes the frame visible
        frame.setVisible(true);
    }
}

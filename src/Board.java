import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private final int PLAYER_X = 40;
    private final int PLAYER_Y = 60;
    private final int HEALTH_X = 0;
    private final int HEALTH_Y = -25;
    private final int DELAY = 10;
    private Timer timer;
    private Player player;
    private Health health;
    private Enemy enemy;
    private Block block;

    public Board() {
        addKeyListener(new TAdapter());
        setFocusable(true);

        player = new Player(PLAYER_X, PLAYER_Y);
        health = new Health(HEALTH_X, HEALTH_Y);
        enemy = new Enemy(240,70);

        block = new Block(0, 0);


        timer = new Timer(DELAY, this);
        timer.start();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(player.getImage(), player.getX(), player.getY(), this);
        g2d.drawImage(health.getImage(), health.getX(), health.getY(), this);
        g2d.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), this);

        int[][] map = {{0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {1,1,1,1,1,1,1,1,1}
        };

        int x = -3, y = 0;
        System.out.println(map.length);
        System.out.println(map[0].length);
        System.out.println(map[1].length);
        for (int i = 0; i < map.length; i++) {
            for (int b = 0; b < map[i].length; b++) {
                if(map[i][b] == 1)
                    g2d.drawImage(block.getImage(), x, y, this);
                x += 42;
            }
            x = -3;
            y += 50;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        updatePlayer();
        repaint();
    }

    private void updatePlayer() {

        player.move();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }
    }
}
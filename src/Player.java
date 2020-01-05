import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

public class Player extends Sprite {

    private int dx;
    private int dy;
    private int i, i2, i3, i4=0;
    private Timer runTimer, standTimer, jumpTimer, attackTimer;
    private Boolean isFacingRight = true;
    int health;


    public Player(int x, int y) {
        super(x, y);
        runTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerRun();
            }
        });

        standTimer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerIdle();
            }
        });

        jumpTimer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerJump();
            }
        });

        attackTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerAttack();
            }
        });

        health = 100;

        loadImage("src/resources/icons/Adventurer/Individual Sprites/adventurer-idle-00.png");
        getImageDimensions();
        standTimer.start();
    }

    private void checkCollision() {
    }

    public void move() {

        x += dx;
        y += dy;

        if (x < 1) {
            x = 1;
        }

        if (y < 1) {
            y = 1;
        }
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            standTimer.stop();
            runTimer.stop();
            attackTimer.start();
        }

        if (key == KeyEvent.VK_LEFT) {
            //setSprite("adventurer-idle-left-00.png");
            isFacingRight = false;
            dx = -1;
            standTimer.stop();
            runTimer.start();
        }

        if (key == KeyEvent.VK_RIGHT) {
            //setSprite("adventurer-idle-00.png");
            isFacingRight = true;
            dx = 1;
            standTimer.stop();
            runTimer.start();
        }

        if (key == KeyEvent.VK_UP) {
           // dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
           // dy = 1;
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
            runTimer.stop();
            standTimer.start();
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
            runTimer.stop();
            standTimer.start();
        }

        if (key == KeyEvent.VK_UP) {
           // dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
           // dy = 0;
        }
    }
    private void playerJump(){
        if (isFacingRight) {
            System.out.println("Right jump:  " + i3);
            setSprite("adventurer-jump-0" + i3 + ".png");
        } else {
            System.out.println("Left jump:  " + i3);
            setSprite("adventurer-jump-left-0" + i3 + ".png");
        }
        if (i3 < 3) {
            i3++;
        } else {
            i3=0;
            jumpTimer.stop();
        }
    }

    //i could make a modular function to do this for walking and idle?
    private void playerIdle(){

        if (isFacingRight) {
            System.out.println("Right stand:  " + i2);
            setSprite("adventurer-idle-0" + i2 + ".png");
        } else {
            System.out.println("Left stand:  " + i2);
            setSprite("adventurer-idle-left-0" + i2 + ".png");
        }
        if (i2 < 3) {
            i2++;
        } else {
            i2 = 0;
        }
    }

    //rework the run to work like idle, nice and clean.
    private void playerRun(){

        if (isFacingRight) {
            System.out.println("Right run:  " + i);
            setSprite("adventurer-run-0" + i + ".png");
        } else {
            System.out.println("Left run:  " + i);
            setSprite("adventurer-run-left-0" + i + ".png");
        }
        if (i < 5) {
            i++;
        } else {
            i = 0;
        }

    }

    private void playerAttack(){
        if (isFacingRight) {
            System.out.println("Right attack:  " + i4);
            setSprite("adventurer-attack1-0" + i4 + ".png");
        } else {
            System.out.println("Left attack:  " + i4);
            setSprite("adventurer-attack1-left-0" + i4 + ".png");
        }
        if (i4 < 5) {
            i4++;
        } else {
            attackTimer.stop();
            setSprite("adventurer-idle-00.png");
            i4 = 0;
        }
    }

    private void setSprite(String sprite){
        loadImage("src/resources/icons/Adventurer/Individual Sprites/" + sprite );
    }
}
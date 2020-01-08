import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

public class Player extends Sprite {

    private int dx;
    private int dy;
    private int i, i2, i3, i4=0;
    private Timer runTimer, standTimer, jumpTimer, attackTimer, attackTwoTimer, attackThreeTimer;
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

        attackTwoTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerAttackTwo();
            }
        });

        attackThreeTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerAttackThree();
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

        if (key == KeyEvent.VK_LEFT ||
                key == KeyEvent.VK_A) {
            //setSprite("adventurer-idle-left-00.png");
            isFacingRight = false;
            dx = -1;
            standTimer.stop();
            runTimer.start();
        }

        if (key == KeyEvent.VK_RIGHT ||
                key == KeyEvent.VK_D) {
            //setSprite("adventurer-idle-00.png");
            isFacingRight = true;
            dx = 1;
            standTimer.stop();
            runTimer.start();
        }

        if (key == KeyEvent.VK_J) {
            standTimer.stop();
            runTimer.stop();
            attackTimer.start();
        }

        if (key == KeyEvent.VK_K) {
            standTimer.stop();
            runTimer.stop();
            attackTwoTimer.start();
        }
        if (key == KeyEvent.VK_L) {
            standTimer.stop();
            runTimer.stop();
            attackThreeTimer.start();
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT ||
                key == KeyEvent.VK_A) {
            dx = 0;
            runTimer.stop();
            standTimer.start();
        }

        if (key == KeyEvent.VK_RIGHT ||
                key == KeyEvent.VK_D) {
            dx = 0;
            runTimer.stop();
            standTimer.start();
        }

        if (key == KeyEvent.VK_J) {

        }
        if (key == KeyEvent.VK_K) {

        }
        if (key == KeyEvent.VK_L) {

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
        if (i4 < 4) {
            i4++;
        } else {
            attackTimer.stop();
            setSprite("adventurer-idle-00.png");
            standTimer.start();
            i4 = 0;
        }
    }

    private void playerAttackTwo(){
        if (isFacingRight) {
            System.out.println("Right attack:  " + i4);
            setSprite("adventurer-attack2-0" + i4 + ".png");
        } else {
            System.out.println("Left attack:  " + i4);
            setSprite("adventurer-attack2-left-0" + i4 + ".png");
        }
        if (i4 < 5) {
            i4++;
        } else {
            attackTwoTimer.stop();
            setSprite("adventurer-idle-00.png");
            standTimer.start();
            i4 = 0;
        }
    }
    private void playerAttackThree(){
        if (isFacingRight) {
            System.out.println("Right attack:  " + i4);
            setSprite("adventurer-attack3-0" + i4 + ".png");
        } else {
            System.out.println("Left attack:  " + i4);
            setSprite("adventurer-attack3-left-0" + i4 + ".png");
        }
        if (i4 < 5) {
            i4++;
        } else {
            attackThreeTimer.stop();
            setSprite("adventurer-idle-00.png");
            standTimer.start();
            i4 = 0;
        }
    }


    private void setSprite(String sprite){
        loadImage("src/resources/icons/Adventurer/Individual Sprites/" + sprite );
    }
}
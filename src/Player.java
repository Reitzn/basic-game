import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

class UpdateSprite extends TimerTask
{
    public static int i = 0;

    public void run(){
        System.out.println("Timer ran " + ++i);
        loadImage("src/resources/icons/Adventurer/Individual Sprites/adventurer-idle-00.png");
    }
}

public class Player extends Sprite {

    private int dx;
    private int dy;
    private Timer timer;
    private TimerTask task;

    public Player(int x, int y) {
        super(x, y);
        timer = new Timer();
        task = new UpdateSprite();
        timer.schedule(task,2000, 5000);

        initCraft();
    }

    private void initCraft() {

        loadImage("src/resources/icons/Adventurer/Individual Sprites/adventurer-idle-00.png");
        getImageDimensions();
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
            //fire();
            //attack function?
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
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
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
           // dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
           // dy = 0;
        }
    }

    public void updateSprite(){

    }
}
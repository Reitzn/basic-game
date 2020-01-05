import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Enemy extends Sprite {

    private Timer idleTimer;
    private boolean isFacingRight = true;
    private int i = 0;

    public Enemy(int x, int y) {
        super(x, y);

        loadImage("src/resources/icons/slime/Individual Sprites/slime-idle-0.png");
        getImageDimensions();

        idleTimer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enemyIdle();
            }
        });
        idleTimer.start();
    }

    private void enemyIdle() {
        if (isFacingRight) {
            setSprite("slime-idle-" + i + ".png");
        } else {
            setSprite("slime-idle-left-" + i + ".png");
        }
        if (i < 3) {
            i++;
        } else {
            i = 0;
        }
    }

    private void setSprite(String sprite){
        loadImage("src/resources/icons/slime/Individual Sprites/" + sprite );
    }
}

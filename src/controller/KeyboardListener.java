package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;

public class KeyboardListener implements KeyListener {

    private static HashSet<Integer> activeKeys;

    public KeyboardListener(){
        activeKeys = new HashSet<Integer>();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        activeKeys.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        activeKeys.remove(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public static HashSet<Integer> getActiveKeys(){
        return activeKeys;
    }
}

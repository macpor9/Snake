package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ScreenDisplay extends JPanel implements KeyListener {

    private static final ScreenDisplay instance = new ScreenDisplay();
    private Screen currentScreen;

    private ScreenDisplay(){
        this.setLayout(new BorderLayout());
        this.setScreen(new MenuScreen());
    }

    public static ScreenDisplay getInstance(){
        return instance;
    }

    public void setScreen(Screen screen){
        this.removeAll();
        this.add(screen, BorderLayout.CENTER);
        this.revalidate();
        this.currentScreen = screen;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(currentScreen != null)
            currentScreen.keyTyped(e);
    }

    public Screen getCurrentScreen(){
        return currentScreen;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(currentScreen != null)
            currentScreen.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(currentScreen != null)
            currentScreen.keyReleased(e);
    }
}

import Screens.ScreenDisplay;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class App extends JFrame implements KeyListener {
    public App(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,800);
        setLocationRelativeTo(null);
        addKeyListener(this);
        getContentPane().add(ScreenDisplay.getInstance());
        setVisible(true);
        requestFocus();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        ScreenDisplay.getInstance().keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        ScreenDisplay.getInstance().keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        ScreenDisplay.getInstance().keyReleased(e);
    }
}

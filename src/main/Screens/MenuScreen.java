package Screens;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuScreen extends Screen {

    private final String [] buttons = {"START","HIGH SCORE","EXIT"};
    private int selectedButton = 0;


    public MenuScreen(){
        this.setBackground(Color.black);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        paint((Graphics2D) g);
    }



    protected void paint(Graphics2D g){
        g.setColor(Utills.getInstance().getUnselectedTextColor());
        g.setFont(Utills.getInstance().getFont());
        FontMetrics fontMetrics = g.getFontMetrics(Utills.getInstance().getFont());
        for(int i=0; i<buttons.length; i++){
            if(i == selectedButton)
                g.setColor(Utills.getInstance().getSelectedTextColor());
            Utills.getInstance().drawCenteredString(g,buttons[i],fontMetrics,getHeight()/6*(2+i),this.getWidth());
            g.setColor(Utills.getInstance().getUnselectedTextColor());
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
                selectedButton-=1;
                break;
            case KeyEvent.VK_S:
                selectedButton+=1;
                break;
            case KeyEvent.VK_ENTER:
                enterFun();
                break;
            default:
                break;
        }
        if(selectedButton<0)
            selectedButton=2;
        if(selectedButton>2)
            selectedButton=0;
    }


    public void enterFun(){
        switch (selectedButton){
            case 0:
                startFun();
                break;
            case 1:
                highScoreFun();
                break;
            case 2:
                exitFun();
                break;
            default:
                break;
        }
    }

    public void startFun(){
        ScreenDisplay.getInstance().setScreen(new GameScreen());
    }

    public void highScoreFun(){
        ScreenDisplay.getInstance().setScreen(new HighScoreScreen());
    }

    public void exitFun(){
        System.exit(0);
    }

}

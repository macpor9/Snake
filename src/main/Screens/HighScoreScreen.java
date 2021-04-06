package Screens;

import GameObjects.Score;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;


public class HighScoreScreen extends Screen {


    private ArrayList<Score> highScores;
    public HighScoreScreen(){
        highScores = new ArrayList<Score>();
        if(new File(Utills.getInstance().getScoreFileName()).exists()) {
            try {
                DataInputStream dis = new DataInputStream(new FileInputStream(Utills.getInstance().getScoreFileName()));
                while (true) {
                    try {
                        int readScore = dis.readInt();
                        String readName = dis.readUTF();
                        highScores.add(new Score(readName,readScore));
                    } catch (EOFException eof) {
                        break;
                    }
                }
                dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.setBackground(Color.BLACK);
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
        FontMetrics fontMetrics2 = g.getFontMetrics(Utills.getInstance().getFont2());
        Utills.getInstance().drawCenteredString(g,"High Scores",fontMetrics,getHeight()/14,this.getWidth());
        g.setFont(Utills.getInstance().getFont2());
        for(int i=0; i< highScores.size(); i++){
            g.drawString(1+i+".",50,(getHeight()/14)*(2+i));
            Utills.getInstance().drawCenteredString(g,""+highScores.get(i).getNickname(),fontMetrics2,(getHeight()/14)*(2+i), this.getWidth());
            g.drawString(highScores.get(i).getScore()+"",700,(getHeight()/14)*(2+i));
        }
        g.setFont(Utills.getInstance().getFont());
        g.setColor(Utills.getInstance().getSelectedTextColor());
        Utills.getInstance().drawCenteredString(g,"BACK",fontMetrics,getHeight()/15*14,this.getWidth());


    }



    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
            ScreenDisplay.getInstance().setScreen(new MenuScreen());
    }


}

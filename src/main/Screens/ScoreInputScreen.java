package Screens;

import GameObjects.Score;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;

public class ScoreInputScreen extends Screen {

    private final int score;
    private String nickname;

    private ArrayList<Score> highScores;
    public ScoreInputScreen(int score){
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
        this.nickname = "";
        this.score = score;
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

        Utills.getInstance().drawCenteredString(g,"ENTER NICKNAME:",fontMetrics,getHeight()/6*2,this.getWidth());
        g.setColor(new Color(130,130,30));
        Utills.getInstance().drawCenteredString(g,nickname,fontMetrics,getHeight()/6*3,this.getWidth());
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            System.out.println();
            saveToFile();}
        if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
            nickname = nickname.substring(0, nickname.length() - 1);
        else
            nickname+=e.getKeyChar();
    }


    private void saveToFile(){

        highScores.add(new Score(nickname,score));
        highScores.sort(new Score.MyComparator());
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(Utills.getInstance().getScoreFileName()));
            for (int i=0; i<10&&i<highScores.size(); i++){
                dos.writeInt(highScores.get(i).getScore());
                dos.writeUTF(highScores.get(i).getNickname());
            }
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ScreenDisplay.getInstance().setScreen(new HighScoreScreen());

    }
}

package Screens;

import GameObjects.Food;
import GameObjects.FoodGood;
import GameObjects.Snake;
import GameObjects.SnakeElement;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameScreen extends Screen {
    private Snake snake;
    private int score;
    private ArrayList<GameObjects.Food> foodList;

    public GameScreen(){
        snake = new Snake(3);
        score = snake.getBody().size()-1;
        foodList = new ArrayList<Food>();
        foodList.add(new GameObjects.FoodGood());
        for(int i=0; i<10; i++)
            foodList.add(new GameObjects.FoodBad());
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        paint((Graphics2D) g);
    }

    public void update(){
        snake.move();
        for(Food f: foodList){
            if(f.checkCollision(snake.getBody().get(0)))
                score+=f.eat();
        }
        for(int i=1; i<snake.getBody().size()-1; i++){
            if(snake.getBody().get(0).getPosition().equals(snake.getBody().get(i).getPosition()))
                endGame();
        }
        if(score<0){
            score = 0;
            endGame();
        }
        if(snake.getBody().size()-1>score){
            snake.removeLast();
        }
        if(snake.getBody().size()-1<score){
            snake.addBody();
        }
    }

    protected void paint(Graphics2D g){
        g.drawImage(Utills.getInstance().getBackground(),0,0,getWidth(),getHeight(),null);
        for (Food f: foodList){
            g.drawImage(f.getTexture(),f.getPosition().getX(),f.getPosition().getY(),null);
        }
        g.setFont(Utills.getInstance().getFont());
        g.setColor(new Color(255,0,255));
        g.drawString(""+score,50,720);
        paintSnake(g);
        update();
    }

    private void paintSnake(Graphics2D g){
        for(SnakeElement se: snake.getBody()){
            g.drawImage(se.getTexture(),se.getPosition().getX(),se.getPosition().getY(),null);
        }
        SnakeElement head = snake.getBody().get(0);
        g.drawImage(head.getTexture(),head.getPosition().getX(),head.getPosition().getY(),null);
    }

    public void endGame(){
        ScreenDisplay.getInstance().setScreen(new ScoreInputScreen(score));
    }



    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                snake.getDirectory().set(0,-16);
                snake.getBody().get(0).setTexture(Utills.getInstance().getSnakeHeadUp());
                break;
            case KeyEvent.VK_S:
                snake.getDirectory().set(0,16);
                snake.getBody().get(0).setTexture(Utills.getInstance().getSnakeHeadDown());
                break;
            case KeyEvent.VK_A:
                snake.getDirectory().set(-16,0);
                snake.getBody().get(0).setTexture(Utills.getInstance().getSnakeHeadLeft());
                break;
            case KeyEvent.VK_D:
                snake.getDirectory().set(16,0);
                snake.getBody().get(0).setTexture(Utills.getInstance().getSnakeHeadRight());
                break;
            case KeyEvent.VK_F:
                score+=new FoodGood().eat();
                break;
            default:break;
        }
    }


}

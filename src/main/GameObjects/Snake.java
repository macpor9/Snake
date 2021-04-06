package GameObjects;

import Screens.Utills;


import java.util.ArrayList;

public class Snake {
    private ArrayList<SnakeElement> body= new ArrayList<SnakeElement>();
    private Position directory;

    public Snake(){
        directory = new Position(0,-16);
        body.add(new SnakeElement(new Position(400,400), Utills.getInstance().getSnakeHeadUp()));
    }
    public Snake(int size){
        directory = new Position(0,-16);
        body.add(new SnakeElement(new Position(400,400), Utills.getInstance().getSnakeHeadUp()));
        for(int i=0; i<size; i++){
            addBody();
        }
    }

    public ArrayList<SnakeElement> getBody(){
        return body;
    }

    public Position getDirectory(){
        return directory;
    }

    public void eat(Food food){
        food.eat();
    }

    public void removeLast(){
        body.remove(body.size()-1);
    }

    public void addBody(){
//        int x = body.get(body.size()-1).getPosition().getX();
//        int y = body.get(body.size()-1).getPosition().getY();
        Position pos = body.get(body.size()-1).getPosition();
        body.add(new SnakeElement(pos,Utills.getInstance().getSnakeBody()));
    }


    public void move(){
        for (int i=body.size()-1; i>0; i--){
            Position previousPosition = new Position(body.get(i-1).getPosition());
            body.get(i).setPosition(previousPosition);
        }
        SnakeElement sn = body.get(0);
        sn.getPosition().move(directory);
        if(sn.getPosition().getX()<0)
            sn.getPosition().setX(768);
        if(sn.getPosition().getX()>768)
            sn.getPosition().setX(0);
        if(sn.getPosition().getY()<0)
            sn.getPosition().setY(744);
        if(sn.getPosition().getY()>744)
            sn.getPosition().setY(0);
    }
}

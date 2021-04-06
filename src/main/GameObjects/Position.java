package GameObjects;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y){
        set(x,y);
    }
    public Position(){
        this(0,0);
    }
    public Position(Position position){
        this(position.x,position.y);
    }

    public void move(int x, int y){
        this.x+=x;
        this.y+=y;
    }

    public void move(Position pos){
        move(pos.x,pos.y);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setRandom(){
        int newX;
        int newY;
        do {
        newX = (int)(Math.random()*48)*16;
        newY = (int)(Math.random()*46.5)*16;
        }while (this.x == newX || this.y == newY);

        this.x = (int)(Math.random()*48)*16;
        this.y = (int)(Math.random()*46.5)*16;
    }

    public void set(Position n) {
        set(n.x, n.y);
    }
    public void set(int x, int y){
        this.x=x;
        this.y=y;
    }
    public boolean equals(Position pos){
        return pos.x==x && pos.y==y;
    }
}



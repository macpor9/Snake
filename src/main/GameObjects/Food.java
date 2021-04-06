package GameObjects;

import java.awt.image.BufferedImage;

public abstract class Food {
    private BufferedImage texture;
    private Position position;

    protected Food(BufferedImage texture){
        this.texture = texture;
        this.position = new Position((int)(Math.random()*48)*16, (int)(Math.random()*46.5)*16);
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setRandomPosition(){
        this.position.setRandom();
    }

    public boolean checkCollision(SnakeElement s){
        return s.getPosition().equals(position);
    }

    public abstract int eat();
}

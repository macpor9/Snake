package GameObjects;

import java.awt.image.BufferedImage;

public class SnakeElement {
    private BufferedImage texture;
    private Position position;


    public SnakeElement(Position position, BufferedImage texture){
        this.position = position;
        this.texture = texture;
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



}

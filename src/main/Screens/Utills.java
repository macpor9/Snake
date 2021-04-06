package Screens;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Utills {
    private Font font;
    private Font font2;
    private static final Utills instance = new Utills();
    private BufferedImage foodGoodTexture,foodBadTexture;
    private BufferedImage background;
    private BufferedImage snakeHeadUp;
    private BufferedImage snakeHeadDown;
    private BufferedImage snakeHeadLeft;
    private BufferedImage snakeHeadRight;
    private BufferedImage snakeBody;
    public String SCORE_FILE_NAME;
    private final Color selectedTextColor = new Color(255,0,255);
    private final Color unselectedTextColor = new Color(120,30,30);

    public BufferedImage getFoodGoodTexture() {
        return foodGoodTexture;
    }

    public BufferedImage getFoodBadTexture() {
        return foodBadTexture;
    }

    public BufferedImage getSnakeHeadUp() {
        return snakeHeadUp;
    }

    public BufferedImage getSnakeHeadDown() {
        return snakeHeadDown;
    }

    public BufferedImage getSnakeHeadLeft() {
        return snakeHeadLeft;
    }

    public BufferedImage getSnakeHeadRight() {
        return snakeHeadRight;
    }

    public BufferedImage getSnakeBody() {
        return snakeBody;
    }

    public BufferedImage getBackground() {
        return background;
    }

    public String getScoreFileName() {
        return SCORE_FILE_NAME;
    }

    public Color getSelectedTextColor() {
        return selectedTextColor;
    }

    public Color getUnselectedTextColor() {
        return unselectedTextColor;
    }

    public static Utills getInstance(){
        return instance;
    }

    private Utills(){
        SCORE_FILE_NAME = "high_scores.txt";
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("res\\p2p.ttf")).deriveFont(30f);
            font2 = Font.createFont(Font.TRUETYPE_FONT, new File("res\\p2p.ttf")).deriveFont(20f);
            background = ImageIO.read(new File("res\\background.png"));
            foodBadTexture = ImageIO.read(new File("res\\bad.png"));
            foodGoodTexture = ImageIO.read(new File("res\\good.png"));
            snakeHeadUp = ImageIO.read(new File("res\\headUp.png"));
            snakeHeadDown = ImageIO.read(new File("res\\headDown.png"));
            snakeHeadLeft = ImageIO.read(new File("res\\headLeft.png"));
            snakeHeadRight = ImageIO.read(new File("res\\headRight.png"));
            snakeBody = ImageIO.read(new File("res\\body.png"));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    public void drawCenteredString(Graphics g, String text, FontMetrics fontMetrics,int y, int width){
        g.drawString(text,(width-fontMetrics.stringWidth(text))/2,y);
    }

    public Font getFont(){
        return font;
    }
    public Font getFont2(){
        return font2;
    }
}

import GameObjects.*;
import Screens.HighScoreScreen;
import Screens.ScreenDisplay;
import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    Position position;
    @BeforeEach
    void init(){
        position = new Position();
    }

    //move zmienia pozycje o wartości podane jako paramety funkcji move
    @Test
    void testMove(){
        position.move(10,20);

        int expectedX = 10;
        int expectedY = 20;

        assertEquals(expectedX,position.getX(),"X is not as it should have been");
        assertEquals(expectedY,position.getY(),"Y is not as it should have been");
    }



    //po użyciu setRandom, x lub y musi się zmienić
//    @Test
//    void testRandomPosition(){
//        int[] notExpectedPositions = new int[]{position.getY(),position.getY()};
//        int x = position.getX();
//        int y = position.getY();
//        position.setRandom();
//        assertFalse(Arrays.equals(notExpectedPositions, new int[]{position.getX(),position.getY()}));
//    }

    //funkcja equals sprawdza, czy pozycja ma takie same x i y
    @Test
    void testEqualsPositions(){
        Position equalPosition = new Position(0,0);
        Position notEqualPosition = new Position(10,0);

        assertTrue(position.equals(equalPosition),"Positions are equal should be true");
        assertFalse(position.equals(notEqualPosition),"Positions are not equal should be false");
    }

    Snake snake;
    @BeforeEach
    void init2(){
        snake = new Snake(4);
    }


    //po dodaniu jednego ciała, rozmiar tablicy z ciałami ma być większy o 1 niż przed dodaniem
    @Test
    void testSnakeLengthAfterAddingBody(){
        int expected = snake.getBody().size()+1;
        snake.addBody();
        int actual = snake.getBody().size();

        assertEquals(expected,actual);
    }


    //po usunięciu jednego ciała, rozmiar tablicy z ciałami ma być mniejszy o 1 niż przed usunięciem
    @Test
    void testSnakeLengthAfterRemovingBody(){
        int expected = snake.getBody().size()-1;
        snake.removeLast();
        int actual = snake.getBody().size();

        assertEquals(expected,actual);
    }

    Food foodBad;
    @BeforeEach
    void init3(){
        foodBad = new FoodBad();
    }

    //funckja pobiera pozycje z głowy węża, i sprawdza czy występuje kolizja z jedzonkiem
    //jako że pozycja została ustawiona na takie same to powinna występować kolizja aby zaliczyc test
    @Test
    void testFoodCollision(){
        foodBad.setPosition(snake.getBody().get(0).getPosition());
        assertTrue(foodBad.checkCollision(snake.getBody().get(0)));
    }

    //funkcja setScreen ma zmieniać ekran, sprawdzam czy po zmianie na HighScoreScreen typ danych będzie taki sam jak klasy highScoreScreen
    //jeśli tak, to znaczy że ekran skutecznie się zmienił i funkcja działa
    @Test
    void testSetScreen(){
        Object expected = HighScoreScreen.class;

        ScreenDisplay.getInstance().setScreen(new HighScoreScreen());
        Object actual = ScreenDisplay.getInstance().getCurrentScreen().getClass();

        assertEquals(expected,actual);
    }

    Score score;
    Score.MyComparator scoreComparator;
    @BeforeEach
    void init4(){
        score = new Score("player",10);
        scoreComparator = new Score.MyComparator();
    }

    //funkcja compare zwraca wartosc>0 jesli pierwszy score jest mniejszy od drugiego scora
    //jej zadaniem jest sortowanie malejąco
    @Test
    void testScoreComparator(){
        Score testScore1 = new Score("player1",15);
        Score testScore2 = new Score("player2",10);
        Score testScore3 = new Score("player3",5);
        boolean expected = true;

        assertTrue(scoreComparator.compare(score,testScore1)>0);
        assertEquals(scoreComparator.compare(score, testScore2), 0);
        assertTrue(scoreComparator.compare(score,testScore3)<0);

    }


}

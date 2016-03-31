package objects;

import main.SnakeGame;

/**
 * Created by ilya on 28.03.16.
 */
public class Apple {

    SnakeGame main;

    public int appleX, appleY;

    public Apple(int appleX, int appleY) {
        this.appleX = appleX;
        this.appleY = appleY;
    }

    public void setRandomPosition () {
        appleX = (int) (Math.random()*main.W);
        appleY = (int) (Math.random()*main.H);
    }

}

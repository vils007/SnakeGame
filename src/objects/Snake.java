package objects;

import main.SnakeGame;

/**
 * Created by ilya on 28.03.16.
 */
public class Snake {

    SnakeGame snakeGame;

    public int derectoin = 0;
    public int length = 2;

    public int snakeX[] = new int[snakeGame.H*snakeGame.W];
    public int snakeY[] = new int[snakeGame.H*snakeGame.W];


    public Snake(int x0, int y0, int x1, int y1){
    snakeX[0]=x0;
    snakeY[0]=y0;
    snakeX[1]=x1;
    snakeY[1]=y1;
    }
    public void move(){
        for (int i = length; i>0; i--){
            snakeX[i] = snakeX[i-1];
            snakeY[i] = snakeY[i-1];
            if (i!=1){
            if ((snakeY[0]==snakeY[i-1])&(snakeX[0] == snakeX[i-1])) {length = i-2;}
            }
        }

        if (length<2) length =2;
        if (derectoin == 0) snakeX[0]++;
        if (derectoin == 1) snakeY[0]++;
        if (derectoin == 2) snakeX[0]--;
        if (derectoin == 3) snakeY[0]--;

        if (snakeX[0] > snakeGame.W-1) snakeX[0] = 0;
        if (snakeX[0] < 0) snakeX[0] = snakeGame.W-1;

        if (snakeY[0] > snakeGame.H-1) snakeY[0] = 0;
        if (snakeY[0] < 0) snakeY[0] = snakeGame.H-1;

    }


}

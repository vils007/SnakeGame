package main;

import objects.Apple;
import objects.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by ilya on 28.03.16.
 */
public class SnakeGame extends JPanel implements ActionListener {

    Apple apple = new Apple((int) (Math.random()*W), (int) (Math.random()*H));
    Snake snake = new Snake(10, 10, 9, 10);
    Timer timer = new Timer(1000/SPEED, this);


    public SnakeGame() {
        timer.start();
        addKeyListener(new Keybord());
        setFocusable(true);
    }

    public static final int SCALE = 32;
    public static final int H = 20;
    public static final int W = 20;
    public static final int SPEED = 4;



    public void paint(Graphics g){

        g.setColor(color(5,50,70));
        g.fillRect(0,0,SCALE*H,SCALE*W);

        g.setColor(color(255,216,0));

        for (int x = 0; x<=SCALE*W ; x+=SCALE){
            g.drawLine(x,0,x,SCALE*H);
        }
        for (int y = 0; y<=SCALE*H ; y+=SCALE){
            g.drawLine(0,y,SCALE*W,y);
        }
        for (int i = 0; i < snake.length; i ++){
            g.setColor(color(200,100,0));
            g.fillRect(snake.snakeX[i]* SCALE + 1, snake.snakeY[i] * SCALE + 1, SCALE -1, SCALE -1 );
        }


        g.setColor(color(255,0,0));
        g.fillOval(apple.appleX*SCALE+1,apple.appleY*SCALE+1,SCALE-1,SCALE-1);

    }

    private Color color(int red, int green,int blue){
        return new Color(red, green, blue);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setSize(SCALE*H+1,SCALE*W+1);

        f.setLocationRelativeTo(null);
        f.add(new SnakeGame());

        f.setVisible(true);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();
        if ((snake.snakeX[0] == apple.appleX)&(snake.snakeY[0] == apple.appleY)){
            snake.length++;
            apple.setRandomPosition();
        }

        for (int i = 1; i<snake.length; i++){
            if ((snake.snakeX[i] == apple.appleX)&(snake.snakeY[i] == apple.appleY)) {
                apple.setRandomPosition();
            }
        }
    repaint();
    }

    private class Keybord extends KeyAdapter {
        public void keyPressed(KeyEvent keyEvent){
            int key = keyEvent.getKeyCode();
            if ((key == keyEvent.VK_RIGHT)&snake.derectoin!=2)  snake.derectoin = 0;
            if ((key == keyEvent.VK_DOWN)&snake.derectoin!=3) snake.derectoin = 1;
            if ((key == keyEvent.VK_LEFT)&snake.derectoin!=0) snake.derectoin = 2;
            if ((key == keyEvent.VK_UP)&snake.derectoin!=1) snake.derectoin = 3;

        }

    }
}

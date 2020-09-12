package com.manni.snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeListener extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
        int key_id = e.getKeyCode();

        if (key_id == KeyEvent.VK_LEFT && !(Snake.direction == 1)){
            Snake.direction = 0;

        }
        if (key_id == KeyEvent.VK_RIGHT && !(Snake.direction == 0)){
            Snake.direction = 1;

        }
        if (key_id == KeyEvent.VK_UP && !(Snake.direction == 3)){
            Snake.direction = 2;

        }
        if (key_id == KeyEvent.VK_DOWN && !(Snake.direction == 2)){
            Snake.direction = 3;

        }
    }

}

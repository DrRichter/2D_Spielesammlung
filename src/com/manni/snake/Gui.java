package com.manni.snake;

import javax.swing.*;

public class Gui extends JFrame {

    public Gui(){
        add(new Snake());

        setResizable(false);
        pack();
        setTitle("Snake");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}

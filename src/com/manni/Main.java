package com.manni;

import com.manni.gamemanager.Gamemanager;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Gamemanager gm = new Gamemanager();
                gm.setVisible(true);
            }
        });
    }
}

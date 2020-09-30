package com.manni.akwsim;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {
    public static void main(String[] args) {
        Gui akwSimGui = new Gui();
    }

    public Gui() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame test = new JFrame();
                test.setSize(1600,500);
                test.setResizable(false);
                test.setLocationRelativeTo(null);
                test.add(new AkwSimPanel());
                test.pack();
                test.setVisible(true);
            }
        });
    }
}

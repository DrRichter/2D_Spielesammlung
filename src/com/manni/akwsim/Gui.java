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
                test.setVisible(true);
                test.add(new AkwSimPanel());
            }
        });
    }
}

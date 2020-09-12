package com.manni.snake;


import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Snake extends JPanel implements ActionListener {
    private int width = 600;
    private int height = 600;

    private Image apple;
    private Image head;
    private Image tail;

    private int tail_amount = 3;
    private int snake_witdh = 10;
    private int snake_x[] = new int[width*height/(snake_witdh*snake_witdh)];
    private int snake_y[] = new int[width*height/(snake_witdh*snake_witdh)];

    private int apple_x;
    private int apple_y;
    boolean running = true;

    public static int direction;

    private Timer t;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Snake sk = new Snake();
                sk.setVisible(true);
            }
        });
    }

    public Snake() {
        addKeyListener(new SnakeListener());
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        setBackground(Color.DARK_GRAY);
        System.out.println("DEBUG");

        ImageIcon icon_apple = new ImageIcon("apple.jpg");
        ImageIcon icon_head = new ImageIcon("head.png");
        ImageIcon icon_tail =  new ImageIcon("tail.png");

        apple = icon_apple.getImage();
        head = icon_head.getImage();
        tail = icon_tail.getImage();

        running = true;
        t = new Timer(200, this);
        t.start();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(running){
            g.drawImage(apple, apple_x,apple_y,this);

            for (int i = 1; i < tail_amount; i++) {
                g.drawImage(tail, snake_x[i], snake_y[i], this);
            }

            g.drawImage(head, snake_x[0], snake_y[0], this);

            Toolkit.getDefaultToolkit().sync();
        }
        else {
            Font f = new Font("Calibri", Font.BOLD, 16);
            FontMetrics metrics = getFontMetrics(f);

            g.setColor(Color.LIGHT_GRAY);
            g.setFont(f);
            g.drawString("Game Over - You died", (width - metrics.stringWidth("Game Over - You died")), height/2);
        }
    }
}


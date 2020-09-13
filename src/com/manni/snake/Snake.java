package com.manni.snake;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Snake extends JPanel implements ActionListener {
    public static int direction = 1;
    boolean running = true;
    private final int width = 300;
    private final int height = 300;
    private final Image apple;
    private final Image head;
    private final Image tail;
    private int tail_amount = 3;
    private final int snake_witdh = 10;
    private final int[] snake_x = new int[width * height / (snake_witdh * snake_witdh)];
    private final int[] snake_y = new int[width * height / (snake_witdh * snake_witdh)];
    private int apple_x;
    private int apple_y;
    private final Timer t;


    public Snake() {
        addKeyListener(new SnakeListener());
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        setBackground(Color.DARK_GRAY);

        ImageIcon icon_apple = new ImageIcon("src/com/manni/snake/resources/apple.png");
        ImageIcon icon_head = new ImageIcon("src/com/manni/snake/resources/head.png");
        ImageIcon icon_tail = new ImageIcon("src/com/manni/snake/resources/tail.png");

        apple = icon_apple.getImage();
        head = icon_head.getImage();
        tail = icon_tail.getImage();

        for (int i = 0; i < tail_amount; i++) {
            snake_x[i] = 100 - i * 10;
            snake_y[i] = 50;
        }
        running = true;
        t = new Timer(300, this);
        t.start();
        spawnApple();
    }

    private void spawnApple() {
        int random = (int) (Math.random() * 29);
        apple_x = random * snake_witdh;
        random = (int) (Math.random() * 29);
        apple_y = random * snake_witdh;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            checkApple();
            checkDeath();
            moveSnake();
        }
        repaint();
    }

    private void moveSnake() {
        for (int i = tail_amount; i > 0; i--) {
            snake_x[i] = snake_x[i - 1];
            snake_y[i] = snake_y[i - 1];
        }

        switch (direction) {
            case 0: //left
                snake_x[0] -= snake_witdh;
                break;
            case 1: //right
                snake_x[0] += snake_witdh;
                break;
            case 2: //up
                snake_y[0] -= snake_witdh;
                break;
            case 3: //down
                snake_y[0] += snake_witdh;
        }
    }

    private void checkDeath() {
        for (int i = tail_amount; i > 3; i--) {
            if (snake_x[0] == snake_x[i] && snake_y[0] == snake_y[i]) {
                running = false;
            }
        }

        if (snake_y[0] >= height || snake_x[0] >= width || snake_y[0] < 0 || snake_x[0] < 0) {
            running = false;
        }
        if (!running) {
            t.stop();
        }
    }

    private void checkApple() {
        if (snake_x[0] == apple_x && snake_y[0] == apple_y) {
            tail_amount++;
            spawnApple();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Font f = new Font("Calibri", Font.BOLD, 16);
        FontMetrics metrics = getFontMetrics(f);

        g.setColor(Color.lightGray);
        g.setFont(f);

        super.paintComponent(g);
        if (running) {
            g.drawImage(apple, apple_x, apple_y, this);

            for (int i = 1; i < tail_amount; i++) {
                g.drawImage(tail, snake_x[i], snake_y[i], this);
            }

            g.drawImage(head, snake_x[0], snake_y[0], this);

            g.drawString("Länge = " + tail_amount, 0, height - 5);

            Toolkit.getDefaultToolkit().sync();
        } else {
            g.drawString("Game Over - Du bist gestorben!", (width - metrics.stringWidth("Game Over - Du bist gestorben!           ")), height / 2);
        }
    }
}


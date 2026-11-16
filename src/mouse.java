import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

public class mouse extends JFrame {
    public BufferedImage back, pers;
    public int x = 35;
    //bad
    // СОБИРАЕМЫЕ ЛИСТЫ

    public ArrayList<source> sour= new ArrayList<source>();


    public KeyListener kl = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println(x);

            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (x==1547) {
                    System.out.println("WALL");

                }
                else {
                    //x++;
                    x+=2;
                    repaint();
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                //x--;
                x-=2;
                repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
//                double y = 0;             // Текущая высота
//                double velocityY = 0;     // Вертикальная скорость
//                double gravity = -9.8;    // Ускорение свободного падения
//                double jumpForce = 15.0;  // Сила прыжка
//                boolean isGrounded = true;
//
//// Вызывается при нажатии клавиши прыжка
//                public void jump() {
//                    if (isGrounded) {
//                        velocityY = jumpForce;
//                        isGrounded = false;
//                    }
//                }
//
//// Вызывается в каждом кадре (deltaTime — время с прошлого кадра)
//                public void update(double deltaTime) {
//                    if (!isGrounded) {
//                        velocityY += gravity * deltaTime;
//                        y += velocityY * deltaTime;
//
//                        // Проверка приземления на уровень земли (y = 0)
//                        if (y <= 0) {
//                            y = 0;
//                            velocityY = 0;
//                            isGrounded = true;
//                        }
//                    }
//                }
//                if (sour.size()>0)
//                {
//                    sour.remove(new Random().nextInt(sour.size()));
//                    repaint();
//                    ..                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    };

    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i=0; i<sour.size();i++ )
                sour.get(i).move();
            repaint();
        }
    };
    //зачем-то таймер с которым разберемся потом

    Timer time = new Timer(100,al);
    //сама игра
    mouse() {

        try {
            back = ImageIO.read(new File("src/img/fon_wood1.png"));
            pers = ImageIO.read(new File("src/img/mouse_mini.png"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        setSize(1795, 896);
        setVisible(true);
        addKeyListener(kl);
//        for (int i=0; i<5; i++) {
//            sour.add(new source());
//        }
//        ////books
//        time.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(back, 0, 0, this);
//                g.drawImage(but_start, 460, 260, this);
        g.drawImage(pers, x, 667, this);
//                g.drawImage(but_back, 660, 600, this);
        for (int i=0; i<sour.size(); i++) {
            g.drawImage(sour.get(i).image, sour.get(i).x, sour.get(i).y, this);
        }


    }


    public static void main(String[] args) {
        new mouse();
    }
}


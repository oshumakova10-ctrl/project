import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

public class mouse extends JFrame {
    public BufferedImage back, pers;
    public BufferedImage book;
    public int x = 35;
    public int y = 277;
    public boolean up = false;

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
                    x+=5;
                    repaint();
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                //x--;
                x-=5;
                repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {



                if (!time.isRunning() && y == 277) {
                    up=true;
                    time.start();
                    repaint();
                }



///наработки по норм прыжку
//                double y = 0;             // h
//                double vY = 0;     // y up
//                double g = -9.8;    // g
//                double jumpForce = 15.0;  //
//                boolean Gr = true;  //земля
//                public void jump() {
//                    if (Gr) {
//                        vY = jumpForce;
//                        Gr = false;
//                    }
//                }
/// время по кадрам
//                public void update(double dT) {
//                    if (Gr) {
//                        vY += g * dT;
//                        y += vY * dT;
//
//                        // Проверка (y = 0)
//                        if (y <= 0) {
//                            y = 0;
//                            vY = 0;
//                            Gr = true;
//                        }
//                    }
//                }
//
            }


        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    };

    ActionListener al = new ActionListener() {
        @Override
        //сама рисовалка прыжочки
        public void actionPerformed(ActionEvent e) {
            if (up) {
                if (y > 177) {
                    y -= 5;
                } else up = false;
            }
            else {
                if (y < 277) {
                    y += 5;
                } else {
                    time.stop();

                }
            }

            for (int i=0; i<sour.size(); i++)
                sour.get(i).move();

            repaint();
//            for (int i=0; i<sour.size();i++ )
//                sour.get(i).move();
//            repaint();

        }
    };
    Timer time = new Timer(20, al);
    //зачем-то таймер с которым разберемся потом

    //сама игра
//    MouseListener ml = new MouseListener() {
//        @Override
//        public void mouseClicked(MouseEvent e) {
//            int a=e.getX();
//            int b=e.getY();
//            System.out.println(a + " " + b);
//
//        }
//
//        @Override
//        public void mousePressed(MouseEvent e) {    }
//
//        @Override
//        public void mouseReleased(MouseEvent e) {      }
//
//        @Override
//        public void mouseEntered(MouseEvent e) {        }
//
//        @Override
//        public void mouseExited(MouseEvent e) {     }
//
//    };
    /// /
    mouse() {

        try {
            back = ImageIO.read(new File("src/img/fon_wood1.png"));
            pers = ImageIO.read(new File("src/img/mouse_mini.png"));
            book = ImageIO.read(new File("src/img/book6at2.png"));
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
        g.drawImage(pers, x, y, this); //y=277
        g.drawImage(book, 360, y, this);

//                g.drawImage(but_back, 660, 600, this);
        for (int i=0; i<sour.size(); i++) {
            g.drawImage(sour.get(i).image, sour.get(i).x, sour.get(i).y, this);
        }


    }


    public static void main(String[] args) {
        new mouse();
    }
}


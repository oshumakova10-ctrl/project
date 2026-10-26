import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

public class mouse extends JFrame {
    public BufferedImage back, mouse;
    public int x = 50;
    //bad
    // СОБИРАЕМЫЕ ЛИСТЫ

    public ArrayList<source> sour= new ArrayList<source>();


    public KeyListener kl = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                x++;
                repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                x--;
                repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                if (sour.size()>0)
                {
                    sour.remove(new Random().nextInt(sour.size()));
                    repaint();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    };

    Timer time = new Timer(100,al);
    //сама игра
    mouse() {

        try {
            back = ImageIO.read(new File("src/img/wooden_shelf1.jpg"));
            mouse = ImageIO.read(new File("src/img/mouse.png"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        setSize(1024, 718);
        setVisible(true);
        addKeyListener(kl);
        for (int i=0; i<5; i++) {
            sour.add(new source());
        }
        ////books
        time.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(back, 0, 0, this);
//                g.drawImage(but_start, 460, 260, this);
        g.drawImage(mouse, 160, 600, this);
//                g.drawImage(but_back, 660, 600, this);
        for (int i=0; i<sour.size(); i++) {
            g.drawImage(sour.get(i).image, sour.get(i).x, sour.get(i).y, this);
        }


    }


    public static void main(String[] args) {
        new mouse();
    }
}


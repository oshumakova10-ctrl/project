import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class menu extends JFrame {
    public BufferedImage fon, but_start, but_back, but_about;

    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getPoint().x >350&& e.getPoint().x <450 && e.getPoint().y >300 && e.getPoint().y >400) {
                new Main();
                System.out.println("start");
            }
            if (e.getPoint().x >500 && e.getPoint().x <600 && e.getPoint().y >300 && e.getPoint().y >400) {
                System.exit(0);
                System.out.println("exit");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {    }

        @Override
        public void mouseReleased(MouseEvent e) {      }

        @Override
        public void mouseEntered(MouseEvent e) {        }

        @Override
        public void mouseExited(MouseEvent e) {     }

    };


    menu ()
    {
        try {
            fon = ImageIO.read(new File("H:/Проект 2026/картинки/фон начало.JPG"));
            but_start = ImageIO.read(new File("H:/Проект 2026/картинки/стрелка вверх.png"));
            but_about = ImageIO.read(new File("H:/Проект 2026/картинки/стрелка вправо.png"));
            but_back = ImageIO.read(new File("H:/Проект 2026/картинки/стрелка влево.png"));
        } catch (Exception e) {      }
        setSize(800, 600);
        setVisible(true);
        addMouseListener(ml);


    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(fon, 0, 0, this);
        g.drawImage(but_start, 300, 400, this);
        g.drawImage(but_about, 400, 400, this);
        g.drawImage(but_back, 500, 400, this);


    }
    public static void main(String[] args) {
        new menu();
    }



}

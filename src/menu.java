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
            if (e.getPoint().x >460&& e.getPoint().x <660 && e.getPoint().y >260 && e.getPoint().y >560) {
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
            fon = ImageIO.read(new File("src/img/фон начало.JPG"));
            but_start = ImageIO.read(new File("src/img/стрелка вверх.png"));
            but_about = ImageIO.read(new File("src/img/стрелка вправо.png"));
            but_back = ImageIO.read(new File("src/img/стрелка влево.png"));
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        setSize(1024, 718);
        setVisible(true);
        addMouseListener(ml);


    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(fon, 0, 0, this);
        g.drawImage(but_start, 460, 260, this);
        g.drawImage(but_about, 160, 600, this);
        g.drawImage(but_back, 660, 600, this);


    }
    public static void main(String[] args) {
        new menu();
    }



}

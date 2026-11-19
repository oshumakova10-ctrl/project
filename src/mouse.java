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
    /// books
    public int bookX = 360;
    public int bookY;// = 247 + pers.getHeight(); //317
    public int floor = 277; //277
    //низ мыши до таймера
    //bad
    // СОБИРАЕМЫЕ ЛИСТЫ

    public ArrayList<source> sour= new ArrayList<source>();
    /// ///////////оределяем положение мыши относительно книги
    public boolean overBookX() {
        int center = x + pers.getWidth()/2;//над книгой
        return center > bookX && center < bookX + book.getWidth();
    }

    public int ground () {
        if (overBookX())//на поверхности
        {
            return bookY - pers.getHeight();
        }
        return 297; //277
    }


/// ////////////нажатия
    public KeyListener kl = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println(x);

            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                x+=5;
                if (x>1547) x=1547;
                if (x==1547) {
                    System.out.println("WALL");

                }

                repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                //x--;
                if (x<0) x=0;
                if (x==0) {
                    System.out.println("WALL");

                }
                x-=5;
                repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {



                if (y == ground()) {
                    up=true;
                    time.start();
                    repaint();
                }

            }


        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    };
    /// //////////прыжки
    ActionListener al = new ActionListener() {
        @Override
        //сама рисовалка прыжочки
        public void actionPerformed(ActionEvent e) {
            int gr = ground();
            if (up) {
                if (y > 127) { //самая верхняя точка 177
                    y -= 5;
                } else up = false;
            }
            else {
                if (y < gr) {
                    y += 5;
                    if (y > gr) y = gr;
                    //fall on floor
                }
            }
            if (!up && overBookX() && y+pers.getHeight()>=bookY) {
                y=bookY - pers.getHeight();
            }
            boolean inbookX = x+pers.getWidth()>bookX && x<bookX+book.getWidth();
            boolean inbookY = y+pers.getHeight()>bookY && y<bookY+book.getHeight(); ///y+pers.getHeight()>bookY && y<bookY+book.getHeight();
            if (inbookX && inbookY && y==floor && !up) {
                if (x+pers.getWidth()/2 >= bookX + book.getWidth()/2) {
                x=bookX+book.getWidth();
                } else {
                    x = bookX - pers.getWidth();      // упёрлась слева
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
    Timer time = new Timer(10, al);
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
    /// //////////////программа
    mouse() {

        try {
            back = ImageIO.read(new File("src/img/fon_wood1.png"));
            pers = ImageIO.read(new File("src/img/mouse_mini1.png"));
            book = ImageIO.read(new File("src/img/book6at2.png"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        bookY = 147 + pers.getHeight(); //137
        setSize(1795, 896);
        setVisible(true);
        addKeyListener(kl);
//        for (int i=0; i<5; i++) {
//            sour.add(new source());
//        }
//        ////books
        time.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(back, 0, 0, this);
//                g.drawImage(but_start, 460, 260, this);
//        g.drawImage(pers, x, 667, this);
        g.drawImage(pers, x, y, this); //y=277

        g.drawImage(book, bookX, bookY, this); ///277

//                g.drawImage(but_back, 660, 600, this);
        for (int i=0; i<sour.size(); i++) {
            g.drawImage(sour.get(i).image, sour.get(i).x, sour.get(i).y, this);
        }


    }


    public static void main(String[] args) {
        new mouse();
    }
}


import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main extends JFrame {
    public BufferedImage fon_wood, mouse;

    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int a=e.getX();
            int b=e.getY();
            System.out.println(a + " " + b);

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
    //    private BufferedImage back;

//    private BufferedImage arrow_left;
//    private BufferedImage arrow_right;
//    private BufferedImage arrow_up;

    public Main() {
        try {


            mouse = ImageIO.read(new File("src/img/mouse_mini.png"));
            fon_wood = ImageIO.read(new File("src/img/fon_wood1.png"));
//            arrow_left = ImageIO.read(new File("C:/Users/User/OneDrive/Desktop/проект 2026/стрелка влево.png"));
//            arrow_right = ImageIO.read(new File("C:/Users/User/OneDrive/Desktop/проект 2026/стрелка вправо.png"));
//            arrow_up = ImageIO.read(new File("C:/Users/User/OneDrive/Desktop/проект 2026/стрелка вверх.png"));
// arrow_left = ImageIO.read(new File("C:/Users/User/OneDrive/Desktop/проект 2026/стрелка влево.png"));
//            back = ImageIO.read(new File("H:/Проект 2026/картинки/фон начало.JPG"));

            setSize(1795, 916);
            setVisible(true);
            addMouseListener(ml);
//            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            JPanel panel = new JPanel() {

                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);

//                    g.drawImage(back, 0, 0, null);
//
//                    new wood_book();
                    g.drawImage(fon_wood, 0, 0, null);
                    g.drawImage(mouse, 35, 667, null);
//                    g.drawImage(arrow_left, 1000, 0, null);
//                    g.drawImage(arrow_right, 1000, 300, null);
//                    g.drawImage(arrow_up, 0, 0, null);
                }

            };

// Добавление панели в JFrame
            add(panel);
            setVisible(true);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении изображения: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new menu();
    }
}
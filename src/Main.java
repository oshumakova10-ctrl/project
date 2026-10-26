import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main extends JFrame {

    //    private BufferedImage back;
    private BufferedImage mouse;
//    private BufferedImage arrow_left;
//    private BufferedImage arrow_right;
//    private BufferedImage arrow_up;

    public Main() {
        try {


            mouse = ImageIO.read(new File("src/img/mouse.png"));
//            arrow_left = ImageIO.read(new File("C:/Users/User/OneDrive/Desktop/проект 2026/стрелка влево.png"));
//            arrow_right = ImageIO.read(new File("C:/Users/User/OneDrive/Desktop/проект 2026/стрелка вправо.png"));
//            arrow_up = ImageIO.read(new File("C:/Users/User/OneDrive/Desktop/проект 2026/стрелка вверх.png"));
// arrow_left = ImageIO.read(new File("C:/Users/User/OneDrive/Desktop/проект 2026/стрелка влево.png"));
//            back = ImageIO.read(new File("H:/Проект 2026/картинки/фон начало.JPG"));

            setSize(1024, 718);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            JPanel panel = new JPanel() {

                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);

//                    g.drawImage(back, 0, 0, null);
//
                    g.drawImage(mouse, 0, 0, null);
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
        new Main();
    }
}
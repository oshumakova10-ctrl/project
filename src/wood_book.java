//import java.awt.*;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import javax.imageio.ImageIO;
//import javax.swing.*;
//
//public class wood_book extends JFrame {
//    public BufferedImage fon, but_start, but_back, but_about;
//
//    MouseListener ml = new MouseListener() {
//        @Override
//        public void mouseClicked(MouseEvent e) {
//            int a=e.getX();
//            int b=e.getY();
//            System.out.println(a + " " + b);
////            if (e.getPoint().x >363 && e.getPoint().x <603 && e.getPoint().y >257 && e.getPoint().y >495) {
//            if (a >363 && a <603 && b >257 && b <495) {
//                new Main();//364 612 247 503
//                System.out.println("start");
//            }
//            if (a >29 && a <310 && b >505 && b <694) {
//                System.exit(0);
//                System.out.println("exit");
//            }
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
//
//
//    menu ()
//    {
//        try {
//            fon = ImageIO.read(new File("src/img/start_fon.png"));
//            but_start = ImageIO.read(new File("src/img/startii.png"));
////            but_about = ImageIO.read(new File("src/img/starti.png"));
//            but_back = ImageIO.read(new File("src/img/exitii.png"));
//        } catch (Exception e){
//            throw new RuntimeException(e);
//        }
//        setSize(1024, 718);
//        setVisible(true);
//        addMouseListener(ml);
//
//
//    }
//
//    public void paint(Graphics g) {
//        super.paint(g);
//        g.drawImage(fon, 0, 0, this);
//        g.drawImage(but_start, 0, 0, this);//364 247
////        g.drawImage(but_about, 0, 0, this);
////        g.drawImage(but_back, 150, 625, this);
//        g.drawImage(but_back, 0, 0, this);
//
//
//    }
//    public static void main(String[] args) {
//        new menu();
//    }
//
//
//
//}

//                double y = 0;             // h
//                double vY = 0;     // y up
//                double g = -9.8;    // g
//                double jumpForce = 15.0;  //
//                boolean isGrounded = true;
//                public void jump() {
//                    if (isGrounded) {
//                        veY = jumpForce;
//                        isGrounded = false;
//                    }
//                }
//
//// Вызывается в каждом кадре (deltaTime — время с прошлого кадра)
//                public void update(double deltaTime) {
//                    if (!isGrounded) {
//                        vY += g * deltaTime;
//                        y += vY * deltaTime;
//
//                        // Проверка приземления на уровень земли (y = 0)
//                        if (y <= 0) {
//                            y = 0;
//                            vY = 0;
//                            isGrounded = true;
//                        }
//                    }
//                }
//                if (sour.size()>0)
//                {
//                    sour.remove(new Random().nextInt(sour.size()));
//                    repaint();
//                                    }
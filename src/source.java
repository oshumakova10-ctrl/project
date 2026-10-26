import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;
public class source {
    public BufferedImage image;
    public int x, y;

    source ()
    {
        try {
            image=ImageIO.read(new File("src/img/cheese.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        x = new Random().nextInt(800);
        y = new Random().nextInt(300);
    }

    void move ()
    {
        y+=5;
        if (y>450)
        {
            y=-100;
            x= new Random().nextInt(800); //ширина экрана
        }
    }
     //сталкивание
    public boolean inter(character c)
    {
        boolean answer=false;

        return answer;
    }
////
}

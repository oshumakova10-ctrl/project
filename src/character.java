import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

public class character {
    public BufferedImage image;

    character() {
        try {
            image = ImageIO.read(new File("src/img/mouse.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

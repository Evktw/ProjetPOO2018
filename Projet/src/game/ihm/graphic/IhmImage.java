package game.ihm.graphic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class IhmImage extends JPanel{

    private static final long serialVersionUID = 1L;
    private Image avatar;

    IhmImage(){
        try{

            avatar = ImageIO.read(new File("/img/avatar.jpg"));

        }
        catch(IOException err) {
            err.printStackTrace();
        }
        setPreferredSize( new Dimension (180, 180));
        setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(avatar, 0,0, getWidth(), getHeight(), this);
    }
}

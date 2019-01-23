package game.ihm.graphic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class IhmImage extends JLabel{




    private static final long serialVersionUID = 1L;
    private Image avatar;

    IhmImage(){
        //avatar = ImageIO.read(new File("avatar.jpg"));
        ImageIcon avatar = new ImageIcon("avatar.jpg");

        setPreferredSize( new Dimension (180, 180));
        setBackground(Color.WHITE);

        this.setIcon(avatar);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(avatar, 0,0, getWidth(), getHeight(), this);
    }
}

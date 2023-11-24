package Viewer;


import Model.Model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;



public class Frame extends JFrame
{
    final boolean RESIZABLE_STATUS = true;
    Model m;

    public Frame(Model m)
    {
        this.m = m;
        //JFRAME PARAMETER
        setTitle(m.PROGRAM_TITLE);
        try
        {
            // the path must be relative to your *class* files
            String imagePath = m.ICON_ROOT;
            InputStream imgStream = getResourceAsStream(imagePath );
            BufferedImage myImg = ImageIO.read(imgStream);
            ImageIcon icon = new ImageIcon(myImg);

            // use icon here
            setIconImage(myImg);
        }
        catch(Exception e){}
        setResizable(RESIZABLE_STATUS);
        //WINDOWED MODE OR NOT
        if(m.windowedMode)
        {
            this.setExtendedState(Frame.MAXIMIZED_BOTH);
            this.pack();
            Insets insets = this.getInsets();
            m.programHeight -= (insets.top + insets.bottom);
        }
        else
        {
            GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            this.setUndecorated(true);
            this.setSize(m.programWidth, m.programHeight);
            //ONLY FOR MAC USERS
            if(System.getProperty("os.name").equals("Mac OS X"))
            {
                //com.apple.eawt.FullScreenUtilities.setWindowCanFullScreen(this,true);
                //com.apple.eawt.Application.getApplication().requestToggleFullScreen(this);
            }
            this.requestFocusInWindow();
        
           
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setFocusable(true);
    }

    private InputStream getResourceAsStream(String imagePath) {
        return null;
    }
}

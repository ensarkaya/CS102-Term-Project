import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Image extends JPanel{
   BufferedImage imageB;
   ImageIcon image;
   Image image2;
   OpticStuff stuff;
   JLabel label;
   int x;
   int y;
   
   public Image( OpticStuff stuff) throws IOException
   {
      label = new JLabel(); 
      this.stuff = stuff;
 
      // imageB = ImageIO.read(new File(stuff.getImageName()));
      try{ 
         imageB = ImageIO.read(new File(stuff.getImageName()));
      }
      catch (IOException e1) {
         System.out.println("c");
         e1.printStackTrace();
      }
      image = new ImageIcon(stuff.getImageName());
      label.setIcon(image);
      add(label);
      this.x = stuff.getRow()*60;
      this.y = stuff.getColumn()*60;
   }
   public ImageIcon getImage()
   {
      return image; 
   }
   
   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      
      g.drawImage(imageB, x,y,this);
      
      
   }
   
   public void setX_Y (int newLocX, int newLocY) {
      x = newLocX;
      y = newLocY;
   }
   
   public int getX() {
      return x;
   }
   
   public int getY() {
      return y;
   }
   
   public OpticStuff getStuff()
   {
      return stuff;
   }
    
}

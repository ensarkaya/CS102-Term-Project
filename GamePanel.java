import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class GamePanel extends JPanel
{
   final int gameAreaX_Start = 120;
   final int gameAreaY_Start = 0; 
   final int gameAreaX_End   = 1380;
   final int gameAreaY_End   = 720;
   final int SquareSide      = 60;
   
   Graphics2D g;
   ArrayList<JLabel> siderbarList;
   ArrayList<JPanel> objectsList;
   ArrayList<Light> lightArrayList;
   JLabel tmpLabel;
   Game game;
   
   public GamePanel(Game game)
   {
      setBounds(0,0,1381,721);
      this.game = game;
      objectsList = new ArrayList<JPanel>();
      siderbarList = new ArrayList<JLabel>();
      lightArrayList = new ArrayList<Light>();
      repaint();
   }
   
   public void paintComponent( Graphics g)
   {
      super.paintComponent(g);
      g.drawLine(60,0,60,720);
      g.drawLine(0,0,0,720);
      
      for( int i = 0; i < 13; i++)
      {
         g.drawLine(0,60*i,60,60*i);
      }
      
      
      for( int i = 0; i < 13; i++)
      {
         g.drawLine(gameAreaX_Start, gameAreaY_Start + (i*SquareSide),gameAreaX_End,gameAreaY_Start + i*SquareSide);
      }
      for( int i = 0; i < 22; i++)
      {
         g.drawLine(gameAreaX_Start + (i*SquareSide),gameAreaY_Start,gameAreaX_Start + (i*SquareSide),gameAreaY_End);
      }
      
      
      for(int i = 0; i < game.array.length; i++)
      {
         for( int j = 0; j < game.array[i].length; j++)
         {
            if ( game.array[i][j] != null ) 
            {
               BufferedImage image = null;
               AffineTransform transform = new AffineTransform();
               if ( game.array[i][j].getStuff() instanceof Rotatable)
               {
                  try
                  {
                     image = ImageIO.read(new File (game.array[i][j].getStuff().getImageName()));
                  } catch (IOException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                  }
                  
                  transform.rotate(Math.toRadians(360-((Rotatable)game.array[i][j].getStuff()).getAngle()), image.getWidth()/2 ,image.getHeight()/2);
                  
                  AffineTransformOp op = new AffineTransformOp(transform,AffineTransformOp.TYPE_BILINEAR);
                  
                  image = op.filter(image, null);
                  g.drawImage(image, game.array[i][j].getStuff().getX(),game.array[i][j].getStuff().getY(), this);
               }
               else if(game.array[i][j].getStuff() instanceof LightSource)
               {
                  try
                  {
                     image = ImageIO.read(new File (game.array[i][j].getStuff().getImageName()));
                  } catch (IOException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                  }
                  transform.rotate(Math.toRadians(360-((LightSource)game.array[i][j].getStuff()).getAngle()), image.getWidth()/2 ,image.getHeight()/2);
                  
                  AffineTransformOp op = new AffineTransformOp(transform,AffineTransformOp.TYPE_BILINEAR);
                  
                  image = op.filter(image, null);
                  g.drawImage(image, game.array[i][j].getStuff().getX(),game.array[i][j].getStuff().getY(), this);
               }
               
               
               else{
                  try
                  {
                     image = ImageIO.read(new File (game.array[i][j].getStuff().getImageName()));
                  } catch (IOException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                  }
                  g.drawImage(image, game.array[i][j].getStuff().getX(),game.array[i][j].getStuff().getY(), this);
               }
            }
         }
         
      }
      //g.drawLine( ((int)((ConvexLens)game.array[17][6].getStuff()).getXCenter1()), ((int)((ConvexLens)game.array[17][6].getStuff()).getYCenter1()), ((int)((ConvexLens)game.array[17][6].getStuff()).getXCenter1()), ((int)((ConvexLens)game.array[17][6].getStuff()).getYCenter1()));
      //g.drawLine( ((int)((ConvexLens)game.array[17][6].getStuff()).getXCenter2()), ((int)((ConvexLens)game.array[17][6].getStuff()).getYCenter2()), ((int)((ConvexLens)game.array[17][6].getStuff()).getXCenter2()), ((int)((ConvexLens)game.array[17][6].getStuff()).getYCenter2()));
      
      
      for(int i = 0; i < lightArrayList.size(); i++)
      {
         g.setColor(lightArrayList.get(i).getColor());
         g.drawLine((int)lightArrayList.get(i).getStartX(), (int)lightArrayList.get(i).getStartY(), (int)lightArrayList.get(i).getEndX(), (int)lightArrayList.get(i).getEndY());
         
      }
      
      
      // Finding the intersections 
      
      for(int i = 0; i < lightArrayList.size()-1; i++)
      {
         for(int j = i+1; j < lightArrayList.size(); j++)
         {
            Line2D firstLight = new Line2D.Float( (int)lightArrayList.get(i).startX,  (int)lightArrayList.get(i).startY,  (int)lightArrayList.get(i).endX,   (int)lightArrayList.get(i).endY);
            Line2D secondLight = new Line2D.Float( (int)lightArrayList.get(j).startX,  (int)lightArrayList.get(j).startY,  (int)lightArrayList.get(j).endX,   (int)lightArrayList.get(j).endY);
            
            if ( firstLight.intersectsLine(secondLight) && !(lightArrayList.get(i).getColor().equals(lightArrayList.get(j).getColor() ) ) )
            {
               
               int red = Math.max(lightArrayList.get(i).getColor().getRed(), lightArrayList.get(j).getColor().getRed());
               int green = Math.max(lightArrayList.get(i).getColor().getGreen(), lightArrayList.get(j).getColor().getGreen());
               int blue = Math.max(lightArrayList.get(i).getColor().getBlue(), lightArrayList.get(j).getColor().getBlue());
               
               
               double m1 = Math.tan(Math.toRadians(lightArrayList.get(i).getAngle()));
               double m2 = Math.tan(Math.toRadians(lightArrayList.get(j).getAngle()));
               //System.out.println(m1 + ", " + m2 + "  " + lightArrayList.get(i).getColor() + "  " +  lightArrayList.get(j).getColor());
               double n1 = -lightArrayList.get(i).startY - m1 * lightArrayList.get(i).startX;
               double n2 = -lightArrayList.get(j).startY - m2 * lightArrayList.get(j).startX;
               
               if( ((int)lightArrayList.get(i).getAngle()) == (int)lightArrayList.get(j).getAngle() || ((int)Math.abs(lightArrayList.get(i).getAngle() - lightArrayList.get(j).getAngle()) ) == 180)
               {
                  g.setColor( new Color(red,green,blue));
                  g.drawLine((int)lightArrayList.get(i).getStartX(), (int)lightArrayList.get(i).getStartY(), (int)lightArrayList.get(i).getEndX(), (int)lightArrayList.get(i).getEndY());
               }
               
               else
               {
                  double xCoordinate = (n2-n1)/(m1-m2);
                  
                  double yCoordinate = -(m1 * xCoordinate + n1);
                  
                  //System.out.println(xCoordinate + ", " + yCoordinate);
                  g.setColor(new Color(red,green,blue));
                  g.drawLine((int)xCoordinate, (int)yCoordinate, (int)xCoordinate, (int)yCoordinate);
               }
               
            }
         }
         
      }
   }
   
   public void formatLightArrayList()
   {
      lightArrayList = new ArrayList<Light>();
   }
   
   public void addLight(Light light) 
   {
      lightArrayList.add(light);
   }
   
   public boolean allTargetsAreHit()
   {
      for ( OpticStuff stuff : game.list)
      {
         if (stuff instanceof Target )
         {
            if ( !((Target)stuff).isHit(lightArrayList))
            {
               return false;
            }
         }
      }
      return true;
   }
   
   
   
}
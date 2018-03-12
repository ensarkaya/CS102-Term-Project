import java.awt.Point;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.IOException;

import javax.swing.*;

/**
 * This method is the constructor method of Game class
 * @param
 * @param
 * @param
 */
public class Game {
   
   Level level;
   GamePanel gamePanel;
   ArrayList<OpticStuff> list;
   
   Image[][] array;
   
   
   boolean movable = false;
   boolean rotating = false;
   int firstRow;
   int firstColumn;
   double thetaStart = 0;
   double thetaEnd = 0;
   double firstAngle = 0;
   int x ;
   int y ;
   
   int selection = -2;
   
   public Game( )
   {
      this.level = new Level(false,false);
      gamePanel = new GamePanel(this);
      array = new Image[23][12];
      list = new ArrayList<OpticStuff>();
      
      gamePanel.addMouseListener(new MyMouseListener());
      
      gamePanel.addMouseMotionListener(new MouseMotionAdapter()
                                          {
         @Override
         public void mouseDragged( MouseEvent e)
         {
            if (SwingUtilities.isLeftMouseButton(e))
            {
               if( movable)
               {
                  ((Movable)array[firstRow][firstColumn].getStuff()).setX(e.getX() - 30);
                  ((Movable)array[firstRow][firstColumn].getStuff()).setY(e.getY() - 30);
                  x = e.getX();
                  y = e.getY();
                  
               }
            }
            
            else if (SwingUtilities.isRightMouseButton(e))
            {
               if(rotating)
               {
                  double dx = e.getX() - (firstRow*60+30);
                  double dy = e.getY() - (firstColumn*60+30);
                  double theta = Math.atan2(dy, dx);
                  ((Rotatable)array[firstRow][firstColumn].getStuff()).rotate(Math.toDegrees(firstAngle + thetaStart - theta));
                  
                  
               }
               
               lightDeterminer();
               
               gamePanel.repaint();
            }
            
            
            
            
            gamePanel.repaint();
            
         }
      });
      
   }
//   public void add(OpticStuff stuff) throws IOException
//   {
//      list.add(stuff);
//      array[stuff.getRow()][stuff.getColumn()] = new Image( stuff);
//      gamePanel.repaint();
//   }
   public boolean add(OpticStuff stuff) throws IOException
   {
      boolean result;
      if (array[stuff.getRow()][stuff.getColumn()] != null)
         result = false;
      else
      {
         array[stuff.getRow()][stuff.getColumn()] = new Image(stuff);
         list.add(stuff);
         gamePanel.repaint();
         
         result = true;
      }
      
      lightDeterminer();
      
      return result;
   }
   
   public void setGamePanelVisible(boolean visibility)
   {
      gamePanel.setVisible(visibility);
   }
   
   public boolean level_isCompleted()
   {
      if (gamePanel.allTargetsAreHit())
      {
         level.setCompleted(true);
         return true;
      }
      return false;
   }
   
   
   public void lightDeterminer()
   {
      gamePanel.formatLightArrayList();
      boolean isReflected;
      for (OpticStuff stuff : list)
      {
         if (stuff instanceof LightSource)
         {
            Light light = ( (LightSource)stuff).getLight();
            
            do
            {
               isReflected = false;
               //System.out.println((int) (light.endX/gamePanel.SquareSide) + "  " + (int) (light.endY/gamePanel.SquareSide));
               if( light.getEndX() >= gamePanel.getWidth()-1 || light.getEndX() <= 121 ||
                  light.getEndY() >= gamePanel.getHeight()-1 || light.getEndY() <= 1)
               {
                  isReflected = false;
               }
               
               else if ( !(array[(int) (light.endX/gamePanel.SquareSide)][(int) (light.endY/gamePanel.SquareSide)].getStuff() instanceof Reflactable) )
               {
                  isReflected = false;
               }
               
               else
               {
                  OpticStuff opticStuff = array[(int) (light.endX/gamePanel.SquareSide)][(int) (light.endY/gamePanel.SquareSide)].getStuff();
                  if( opticStuff.touches(light) == 0 )
                  {
                     isReflected = false;
                  }
                  else if( opticStuff.touches(light) == 1 )
                  {
                     isReflected = true;
                  }
               }
               
               gamePanel.addLight( light );
               
               if (isReflected)
               {
                  OpticStuff opticStuff = array[(int) (light.endX/gamePanel.SquareSide)][(int) (light.endY/gamePanel.SquareSide)].getStuff();
                  
                  Light f_light = ( (Reflactable)opticStuff).reflect(light);
                  //System.out.println( f_light.vector + "  " + light.vector );
                  
                  while (Math.sqrt( ( f_light.endY-f_light.startY) * ( f_light.endY-f_light.startY)+ ( f_light.endX-f_light.startX) * ( f_light.endX-f_light.startX ) ) < 1.75)
                  {
                     //System.out.println( Math.sqrt( ( f_light.endY-f_light.startY) * ( f_light.endY-f_light.startY)+ ( f_light.endX-f_light.startX) * ( f_light.endX-f_light.startX ) ) );
                     
                     f_light = new Light( f_light.startX + f_light.vector.unitVector().x, f_light.startY - f_light.vector.unitVector().y , f_light.getAngle(), f_light.getColor(), f_light.game);
                     //System.out.println( Math.sqrt( ( f_light.endY-f_light.startY) * ( f_light.endY-f_light.startY)+ ( f_light.endX-f_light.startX) * ( f_light.endX-f_light.startX ) ) );
                  } 
                  
                  light = f_light;
                  
               }
            }while(isReflected);
            
         }
         
      }
      
      
   }
   
   
   
   class MyMouseListener extends MouseAdapter
   {
      
      @Override
      public void mousePressed( MouseEvent e)
      {
         firstRow = e.getX()/60;
         firstColumn = e.getY()/60;
         
         if (SwingUtilities.isLeftMouseButton(e))
         {
            if( array[e.getX()/60][e.getY()/60] != null && array[e.getX()/60][e.getY()/60].getStuff() instanceof Movable)
            {
               movable = true;
            }
            else 
               movable = false;
         }
         
         else if (SwingUtilities.isRightMouseButton(e))
         {
            Point p = e.getPoint();
            
            if (  array[e.getX()/60][e.getY()/60] != null && array[e.getX()/60][e.getY()/60].getStuff() instanceof Rotatable)
            {
               firstAngle = Math.toRadians(((Rotatable)array[e.getX()/60][e.getY()/60].getStuff()).getAngle());
               double dx = p.x - (firstRow*60 + 30);
               double dy = p.y - (firstColumn*60 + 30);
               thetaStart = Math.atan2(dy, dx);
               rotating = true;
            }
            else
               rotating = false;
         }
      }
      @Override
      public void mouseDragged( MouseEvent e)
      {
         if (SwingUtilities.isLeftMouseButton(e))
         {
            if( movable)
            {
               ((Movable)array[firstRow][firstColumn].getStuff()).setX(e.getX());
               ((Movable)array[firstRow][firstColumn].getStuff()).setY(e.getY());
               x = e.getX();
               y = e.getY();
               
            }
         }
         
         else if (SwingUtilities.isRightMouseButton(e))
         {
            if(rotating)
            {
               double dx = e.getX() - (firstRow*60+30);
               double dy = e.getY() - (firstColumn*60+30);
               double theta = Math.atan2(dy, dx);
               ((Rotatable)array[firstRow][firstColumn].getStuff()).rotate(Math.toDegrees(firstAngle + thetaStart - theta));
               
            }
         }
         
         gamePanel.repaint();
         
      }
      @Override
      public void mouseReleased( MouseEvent e)
      {
         
         if (SwingUtilities.isLeftMouseButton(e))
         {
            
            if (movable)
            {
               if(
                  e.getX()/60 == 1                        ||
                  e.getX() > gamePanel.getWidth()     ||
                  e.getX() < 0             ||
                  e.getY() > gamePanel.getHeight()        ||
                  e.getY() < 0       ||
                  array[e.getX()/60][e.getY()/60] != null 
                     
                 )
               {
                  (  (Movable) array[firstRow][firstColumn].getStuff()).setX( firstRow*60 );
                  (  (Movable)array[firstRow][firstColumn].getStuff()).setY( firstColumn*60 );
                  
               }
               
               else if(array[e.getX()/60][e.getY()/60] == null && e.getX()/60 != 1)
               {
                  (  (Movable) array[firstRow][firstColumn].getStuff()).setX( e.getX()/60*60);
                  (  (Movable)array[firstRow][firstColumn].getStuff()).setY( e.getY()/60*60);
                  
                  array[e.getX()/60][e.getY()/60] = array[firstRow][firstColumn];
                  array[firstRow][firstColumn] = null; 
               }
               
               else if(array[e.getX()/60][e.getY()/60] == array[firstRow][firstColumn])
               {
                  (  (Movable) array[firstRow][firstColumn].getStuff()).setX( e.getX()/60*60);
                  (  (Movable)array[firstRow][firstColumn].getStuff()).setY( e.getY()/60*60);
                  
               }
               
               
            }
         }
         
         else if (SwingUtilities.isRightMouseButton(e))
         {
            if (rotating)
            {
               double dx = e.getX() - (firstRow*60+30);
               double dy = e.getY() - (firstColumn*60+30);
               double theta = Math.atan2(dy, dx);
               ((Rotatable)array[firstRow][firstColumn].getStuff()).rotate(Math.toDegrees(firstAngle + thetaStart - theta));
            }
         }
         lightDeterminer();
         
         if (gamePanel.allTargetsAreHit())
         {
            JFrame frame = new JFrame();
            
            Object[] options = {"Back to Level Menu", "Next Level"};
            int n = JOptionPane.showOptionDialog(frame,
                                                 "The level has been successfully completed!?",
                                                 "Congrats!",
                                                 JOptionPane.YES_NO_OPTION,
                                                 JOptionPane.QUESTION_MESSAGE,
                                                 null,
                                                 options,
                                                 options[1]);
            
            selection = n;
            
         }
         
         
         gamePanel.repaint();
         
      }
   }
}

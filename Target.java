import java.awt.*;
import java.util.*;

public class Target implements OpticStuff{
   Color color;
   int x;
   int y;
   boolean hit;
   ArrayList<Light> list;
   
   public Target(int row, int column, Color newColor )
   {
      hit = false;
      x = row * 60;
      y = column * 60;
      color = newColor;
      list = new ArrayList<Light>();
      
   }
   
   public boolean isHit (ArrayList<Light> list)
   {
      this.list = list;
      for (Light light : list)
      {
         if ( touches(light) == 0 && light.getColor().equals(color))
         {
            hit = true;
            return true;
         }
      }
      hit = false;
      return false;
   }
   
   @Override
   public int getRow() {
      // TODO Auto-generated method stub
      return x/60;
   }
   
   @Override
   public int getColumn() {
      // TODO Auto-generated method stub
      return y/60;
   }
   
   @Override
   public int getX() {
      // TODO Auto-generated method stub
      return x;
   }
   
   @Override
   public int getY() {
      // TODO Auto-generated method stub
      return y;
   }
   
   @Override
   public int touches(Light light) {
      
      int centerX = x + 30;
      int centerY = y + 30;
      
      
      if ( (light.endx - centerX)*(light.endx - centerX) + (light.endy - centerY)*(light.endy - centerY) <= 400)
      {
         return 0;
      }
      
      return -1;
      
   }
   
   @Override
   public String getImageName()
   {
      if(hit)
      {
         if( color == Color.RED ) return "red hit target.png";
         else if( color == Color.GREEN ) return "green hit target.png";
         else if( color == Color.BLUE ) return "blue hit target.png";
         else if( color == Color.MAGENTA ) return "magenta hit target.png";
         else if( color == Color.YELLOW ) return "yellow hit target.png";
      }
      else 
      {
         if( color == Color.RED ) return "red target.png";
         else if( color == Color.GREEN ) return "green target.png";
         else if( color == Color.BLUE ) return "blue target.png";
         else if( color == Color.MAGENTA ) return "magenta target.png";
         else if( color == Color.YELLOW ) return "yellow target.png";
      }
      return "";
   }
   
   /*  public String getImageName()
    {
    if(hit)
    {
    if( color == Color.RED ) return "red hit target.png";
    else if( color == Color.GREEN ) return "green hit target.png";
    else if( color == Color.BLUE ) return "blue hit target.png";
    }
    else 
    {
    if( color == Color.RED ) return "red target.png";
    else if( color == Color.GREEN ) return "green target.png";
    else if( color == Color.BLUE ) return "blue target.png";
    }
    return "";
    }
    */
   
}

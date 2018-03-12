import java.awt.Color;
public class Filter extends Mirrors 
{
   Color color;
   Color newColor;
   
   /**
    * This method is the constructor method of Filter class
    * @param
    * @param
    * @param
    */
   public Filter(int row, int column, int angle, Color color)
   {
      super(row*60,60*column,angle);
      
      this.color = color;
      
   }
   
   @Override
   public String getImageName() {
    {
     if( color == Color.RED ) return "red filter.png";
     else if( color == Color.GREEN ) return "green filter.png";
     else if( color == Color.BLUE ) return "blue filter.png";
     else if( color == Color.MAGENTA ) return "magenta filter.png";
     else if( color == Color.CYAN ) return "cyan filter.png";
     else if( color == Color.YELLOW ) return "yellow filter.png";
     return "";
    }
   }
   
   @Override
   public Light reflect(Light light)
   {
         return new Light(light.endx, light.endy, light.getAngle(), newColor, light.game);
   }
   
   @Override
   public int touches(Light light) {

    int colorR=0, colorG=0,colorB=0;
    
    if(color.getRed() == light.getColor().getRed() && color.getRed() == 255)
       {
          colorR = 255;
       }
       if(color.getGreen() == light.getColor().getGreen() && color.getGreen() == 255)
       {
          colorG = 255;
       }
       if(color.getBlue() == light.getColor().getBlue() && color.getBlue() == 255)
       {
          colorB = 255;
       }
       
       newColor = new Color (colorR, colorG, colorB);
       
       
       
      double length = Math.sqrt((light.endy-getCenterY())*(light.endy-getCenterY())+(light.endx - getCenterX())*(light.endx - getCenterX() ));

      //System.out.println( "Radians: " +  (int)(Math.toRadians(90-angle)*10000)/10000.0);
      //System.out.println( "Tangant: " + Math.tan( (int)(Math.toRadians(90-angle)*10000)/10000.0));
      //System.out.println( "Length: " + length);
      //System.out.println( "Distance to Line: "+ Math.abs(getCenterY() + Math.tan( (Math.toRadians(90-angle)))*( light.endx - getCenterX())- light.endy));
      //System.out.println( );
      if ( Math.abs(getCenterY() + Math.tan( (Math.toRadians(90-angle)))*( light.endx - getCenterX())- light.endy) < TOLERANCE && length <= HEIGHT/2)
      {
         if ( newColor.getBlue() != 0 || newColor.getGreen() != 0 || newColor.getRed() != 0)
         {
          return 1;
         }
         else return 0;
      }
      return -1;
   }
   
   @Override
   public void rotate (double newAngle)
   {
      angle = newAngle;
      if (angle < 0)
         angle = angle % 360 + 360;
      else 
         angle = angle % 360;
   }
   
   
}

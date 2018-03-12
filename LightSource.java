import java.awt.Color;

public class LightSource implements OpticStuff{
   
   Light light;
   int row;
   int column;
   int x;
   int y;
   double angle;
   Game game; 
   Color color;
   private final int WIDTH = 50;
   private final double TOLERANCE = WIDTH/2;
   private final int HEIGHT = 30;
   
   public LightSource(int row, int column, double angle, Color color, Game game)
   {
      this.row= row;
      this.column = column;
      this.color = color;
      this.game =game;
      this.angle = angle;
      light = new Light ( row*60+30+HEIGHT/2.0*Math.cos(Math.toRadians(angle)), column*60+30-HEIGHT/2.0*Math.sin(Math.toRadians(angle)), angle, color ,game);
      x = row*60;
      y = column*60;
   }
   @Override
   public int touches(Light light)
   {
    double length = Math.sqrt((light.endy-getCenterY())*(light.endy-getCenterY())+(light.endx - getCenterX())*(light.endx - getCenterX() ));
       
    if ( Math.abs(getCenterY() + Math.tan( (int)(Math.toRadians(90-angle)*1000)/1000.0)*( light.endx - getCenterX())- light.endy) < TOLERANCE && length <= HEIGHT/2)
    {
     return 0;
    }
    else 
     return -1;
   }      
   
   @Override
   public String getImageName()
   {
      if( color == Color.RED )
         return  "red light source.png";
      else if( color == Color.BLUE )
         return "blue light source.png";
      else 
         return "green light source.png";
   }
     
   @Override
   public int getRow() {
      // TODO Auto-generated method stub
      return row;
   }
   
   public double getAngle() {
       // TODO Auto-generated method stub
       return angle;
    }
   
   @Override
   public int getColumn() {
      // TODO Auto-generated method stub
      return column;
   }
 
   
   public int getX() {
      return x;
   }
   
   public int getY() {
      return y;
   }
   
   public int getCenterX() {
    return x + 30;
    }
    
   public int getCenterY() {
    return y + 30;
   }
   public Light getLight()
   {
      return new Light ( row*60+30+HEIGHT/2*Math.cos(Math.toRadians(angle)), column*60+30-HEIGHT/2*Math.sin(Math.toRadians(angle)), angle, color ,game);
   }
}
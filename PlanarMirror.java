public class PlanarMirror extends Mirrors {
   

   
   public PlanarMirror(int row, int column, double angle) {
      super(row*60, column*60, angle);
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
   @Override
   public Light reflect(Light light)
   {
      double newAngle;
      
      newAngle = 2 * angle - light.angle + 180;
      
      return new Light( light.getEndX(), light.getEndY(), newAngle, light.color, light.game);
      
   }
   
   @Override
   public int touches(Light light) {
      
    boolean reflectable = false;
    if( angle <= 90 && angle >= 0)
    {
     if(light.angle > angle + 90 && light.angle < angle + 270)
      reflectable = true;
     else
      reflectable = false;
    }
    
    else if ( angle <= 270 && angle > 90)
    {
     if(light.angle >= 0 && light.angle < angle - 90 || light.angle >= angle + 90 && light.angle < 360 )
      reflectable = true;
     else
      reflectable = false;
    }
    
    else
    {
     if(light.angle > angle - 270 && light.angle < angle - 90)
      reflectable = true;
     else
      reflectable = false;
    }
    
      double length = Math.sqrt((light.endy-getCenterY())*(light.endy-getCenterY())+(light.endx - getCenterX())*(light.endx - getCenterX() ));

      //System.out.println( "Radians: " +  (int)(Math.toRadians(90-angle)*10000)/10000.0);
      //System.out.println( "Tangant: " + Math.tan( (int)(Math.toRadians(90-angle)*10000)/10000.0));
      //System.out.println( "Length: " + length);
      //System.out.println( "Distance to Line: "+ Math.abs(getCenterY() + Math.tan( (Math.toRadians(90-angle)))*( light.endx - getCenterX())- light.endy));
      //System.out.println( angle );
      
      
      if(angle < 3.5 || angle > 356.5 || angle > 176.5 && angle < 183.5)
      {
       if (Math.abs(getCenterX() - light.endx) < TOLERANCE && length < HEIGHT/2 )
       {
        if ( reflectable)
           {
            return 1;
           }
           else 
            return 0;
       }
       else
        return -1;
      }
      else
      {
       if ( Math.abs(getCenterY() + Math.tan( (Math.toRadians(90-angle)))*( light.endx - getCenterX())- light.endy) < TOLERANCE && length <= HEIGHT/2)
       {
          if ( reflectable)
          {
           return 1;
          }
          else return 0;
       }
       return -1;
      }
   }
   
   
   @Override
   public String getImageName() {
       // TODO Auto-generated method stub
       return "planar mirror.png";
    }
   
   
}

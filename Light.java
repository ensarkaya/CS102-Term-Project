import java.awt.*;

public class Light extends Rectangle{
   double startX;
   double startY;
   double endX;
   double endY;
   double endx;
   double endy;
   double angle;
   Game game;
   Vector vector;
   Color color;
   
   public Light(double startX, double startY, double angle, Color color, Game game)
   {
    this.color = color;
      this.game = game;
      if (angle%360 < 0)
         this.angle = angle % 360 + 360;
      else
         this.angle = angle % 360;
      
      vector = new Vector (Math.cos(Math.toRadians(angle)), Math.sin(Math.toRadians(angle)));
      this.startX = startX + vector.unitVector().x/10;
      this.startY = startY - vector.unitVector().y/10;
      Point p = findEndPoint();
      endX = p.getX();
      endY = p.getY();
      
      
   }
   
   public Light(Point a, Point b)
   {
      startX = a.x;
      startY = a.y;
      endX = b.x;
      endY = b.y;
   }
   
   public Light reflect(double angle)
   {
      endx = endX;
      endy = endY;
      while (endx < game.gamePanel.getWidth() && endx > 0 && endy < game.gamePanel.getHeight() && endy > 120)
      {
         endx += vector.unitVector().x;
         endy -= vector.unitVector().y;
         for (OpticStuff a : game.list)
         {
            if (a.touches(this) > 0)
            {
               return new Light(endX, endY, angle, color, game);
            }
            else if(a.touches(this) == 0)
            {
               return null;
            }
         }
      }
      return new Light(endX, endY, angle, color, game);
   }
   
   public Point findEndPoint()
   {
      endx = startX + vector.unitVector().x;
      endy = startY - vector.unitVector().y;
      
      while (endx < game.gamePanel.getWidth() && endx > 120 && endy < game.gamePanel.getHeight() && endy > 0)
      {
         endx += vector.unitVector().x/20;
         endy -= vector.unitVector().y/20;
         for (OpticStuff a : game.list)
         {
            if (a.touches(this) >= 0)
            {
               return new Point((int)endx,(int)endy);
            }
         }
      }
      return new Point((int)endx,(int)endy);
   }
   
   public double getStartX() {
      return startX;
   }
   
   public double getStartY() {
      return startY;
   }
   
   public double getEndX() {
      return endX;
   }
   
   public double getEndY() {
      return endY;
   }
   
   public void setColor(Color newColor)
   {
      color = newColor;
   }
   
   public Color getColor()
   {
      return color;
   }
   
   public double getAngle() {
      return vector.angle();
   }
   
   
}

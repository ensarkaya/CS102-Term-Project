
import java.awt.Color;

public class Obstacle implements OpticStuff
{
   int row;
   int column;
   int number;
   int side;
   Game game; 
   Color color;
   GamePanel gamePanel;
   
   public Obstacle(int row, int column, int number, Game game)
   {
      this.row = row;
      this.column = column;
      this.game = game;
      this.number = number;
      side = 0;
   }
    public Obstacle(int row, int column, int number, int side,Game game)
   {
      this.row = row;
      this.column = column;
      this.game = game;
      this.side = side;
      this.number = number;
   }
   public int getRow() 
   {
      return row;
   }
   public int getColumn()
   {
      return column;
   }
   public int getX()
   {
      return row*60;
   }
   public int getY()
   {
      return column*60;
   }
   public int getXCenter()
   {
      return row*60 +30;
   }
     public int getYCenter()
   {
      return column*60 +30;
   }
   public int touches( Light light)
   {
      if( number == 1 && side == 2)
      {
         if( row*60 <= light.endx && (row+1)*60 >= light.endx && column*60 <= light.endy && (column+1)*60 >= light.endy && light.endy >= light.endx + 60*(-row+column))
         {      
             
            return 0;  
         } 
         else return -1;
      }
        if( number == 1 && side == 1)
      {
         if( row*60 <= light.endx && (row+1)*60 >= light.endx && column*60 <= light.endy && (column+1)*60 >= light.endy && light.endx >= light.endy + 60*(row-column))
         {      
             
            return 0;  
         } 
         else return -1;
      }
         if( number == 3)
      {
         if( Math.sqrt( (light.endy-getYCenter())*(light.endy-getYCenter()) +  (light.endx-getXCenter())*(light.endx-getXCenter()))< 30 )
         {      
             
            return 0;  
         } 
         else return -1;
      }
         else 
      {
            if( row*60 <= light.endx && (row+1)*60 >= light.endx && column*60 <= light.endy && (column+1)*60 >= light.endy)
         {      
             
            return 0;  
         } 
         else return -1;
      }
      
   }
   
   public String getImageName()
   {
      if( number == 1) return "obstacle1-"+side+".png";
      else
      return "obstacle"+number+".png";
   }

}







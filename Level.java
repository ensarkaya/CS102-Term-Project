import java.util.ArrayList;

public class Level {
   
   private boolean locked;
   private boolean completed;
   ArrayList<OpticStuff> stuffList;
   OpticStuff[][] stuffArray;
   GamePanel panel;
   
   public Level( boolean locked, boolean completed ) {
      this.completed = completed;
      this.locked = locked;
      stuffList = new ArrayList<OpticStuff>();
      stuffArray = new OpticStuff[24][14];
   }
   
   public boolean isLocked() {
      return locked;
   }
   
   public void setLocked(boolean locked) {
      this.locked = locked;
   }
   
   public boolean isCompleted() {
      return completed;
   }
   
   public void setCompleted(boolean completed) {
      this.completed = completed;
   }
   
   public OpticStuff getOpticStuff(int x, int y)
   {
      return stuffArray[x][y];
   }
   
   public void setOpticStuff(OpticStuff stuff, int x, int y)
   {
      stuffArray[x][y] = stuff;
   }
   
   public boolean addOpticStuff (OpticStuff stuff, int x, int y)
   {
      if (stuffArray[x][y] == null)
      {
         stuffArray[x][y] = stuff;
         stuffList.add(stuff);
         return true;
      }
      else
         return false;
   }
   
   public OpticStuff removeOpticStuff (int x, int y)
   {
      if (stuffArray[x][y] != null)
      {
         OpticStuff removed = stuffArray[x][y];
         stuffArray[x][y] = null;
         for (int i = 0; i < stuffList.size(); i++)
         {
            if ( stuffList.get(i) == removed)
               stuffList.remove(i);
         }
         
         
         return removed;
      }
      else
         return null;
   }
}

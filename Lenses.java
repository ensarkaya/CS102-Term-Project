
public abstract class Lenses extends Mirrors implements Reflactable, OpticStuff, Rotatable{
   
   public Lenses(int locX, int locY, double angle) {
      super(locX, locY, angle);
      
   }
   final int FOCUS = 25;
   final int CENTER = 2*FOCUS;
   final int ARC_ANGLE = 60;
   final double GLASS_INDEX = 3/2.0;
   final double LIMITING_ANGLE = 41.8103148827743;
   final double AIR_INDEX = 1;
}

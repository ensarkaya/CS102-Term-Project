public abstract class SphericalMirrors extends Mirrors {
 
 final int FOCUS = 25;
 final int CENTER = 2*FOCUS;
 final int ARC_ANGLE = 60;
 
 public SphericalMirrors(int locX, int locY, double angle) {
  super(locX, locY, angle);
  
 }

 @Override
 public Light reflect(Light light) {
  
  return null;
 }
 
 public abstract int touches(Light light);
}

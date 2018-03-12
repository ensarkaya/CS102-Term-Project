public abstract class Mirrors implements Reflactable, OpticStuff, Movable, Rotatable{
   
   double angle;
   int x;
   int y;
   Vector normal;
   final int HEIGHT = 60;
   
   
   public Mirrors(int x,int y, double angle)
   {
      this.angle = angle;
      this.x = x;
      this.y = y;
      normal = new Vector(1, -1/Math.tan(Math.toRadians(angle) ) );
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
   public void setX(int newLocX) {
      // TODO Auto-generated method stub
      x = newLocX;
   }
   
   @Override
   public double getAngle()
   {
    return angle;
   }
   
   @Override
   public void setY( int newLocY) {
      // TODO Auto-generated method stub
      y = newLocY;
   }
   
   public int getX() {
      return x;
   }
   
   public int getY() {
      return y;
   }
   
   public Vector getNormal() {
      return normal;
   }
   
   public double getCenterX()
   {
      return getX() + 30;
   }
   public double getCenterY()
   {
      return getY() + 30;
   }
   
   public void rotate(double angle)
   {
      this.angle = angle;
      normal = normal.rotate(angle);
   }
   
   public abstract Light reflect( Light light);
   @Override
   public abstract int touches( Light light);
}

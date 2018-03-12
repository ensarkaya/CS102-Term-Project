public class ConvexLens extends Lenses {
 double length1 = 0;
 double length2 = 0;
 /**
  * This method is the constructor method of ConcaveLens class
  * @param
  * @param
  * @param
  */
 public ConvexLens(int row, int column, double angle) {
  super(row*60, column*60, angle);
 }
 
  // Lensin Merkezinin X koordinatý
    public double getXCenter1()
    {
       return getCenterX() + (CENTER-10) * Math.cos( Math.toRadians(angle) );
    }
    
    
    // Lensin Merkezinin Y koordinatý
    public double getYCenter1()
    {
       return getCenterY() - (CENTER-10) * Math.sin( Math.toRadians(angle) );
    }
    
 // Lensin Merkezinin X koordinatý
    public double getXCenter2()
    {
       return getCenterX() - (CENTER-10) * Math.cos( Math.toRadians(angle) );
    }
    
    
    // Lensin Merkezinin Y koordinatý
    public double getYCenter2()
    {
       return getCenterY() + (CENTER-10) * Math.sin( Math.toRadians(angle) );
    }
 
 @Override
 public String getImageName() {
  // TODO Auto-generated method stub
  return "convex lens.png";
 }

 @Override
 public Light reflect(Light light) {

     // System.out.println("Center 1: " + getXCenter1() + ", " + getYCenter1()  );
     //   System.out.println("Center 2: " + getXCenter2() + ", " + getYCenter2()  );
     // System.out.println("getCenter: " + getCenterX() + ", " + getCenterY()  );
     // finding the vector from center to the intersection
     
     Vector lightVect = new Vector(light.vector.x, light.vector.y);
     
     
     // Merkez1, giren
     if (length1 <= CENTER + TOLERANCE && length1 >= CENTER)
     {
        Vector centerVect1 = new Vector(light.endX-getXCenter1(), -light.endY+getYCenter1()).negate();
        
      double angleDifference1 = centerVect1.angle() - light.vector.angle();
      if(angleDifference1 < 0)
      {
       angleDifference1+=360;
      }

      else if (angleDifference1 > 180)
      {
       angleDifference1-=360;
      }
         // finding the angle between the coming light and the vector from center to the intersection
         double dotProduct = lightVect.x * centerVect1.x + lightVect.y * centerVect1.y;
         double magnitudeProduct = lightVect.m() * centerVect1.m();
         double alpha = Math.toDegrees(Math.acos(dotProduct / magnitudeProduct));
         
         
         if (alpha > 90)
         {
          alpha = 180 - alpha;
         }
         
         
         double beta = Math.abs(Math.toDegrees(Math.asin(  Math.sin( Math.toRadians(alpha)) / GLASS_INDEX  )));
         
         
         
         if (angleDifference1 > 180) // Light büyük
         {
               double angle = - alpha + beta + light.angle;
               return new Light( light.getEndX(), light.getEndY(), angle, light.color, light.game);   
            
         }
         
         else if (angleDifference1 < -180) // Merkez büyük
         {
            double angle = alpha - beta + light.angle;
               return new Light( light.getEndX(), light.getEndY(), angle, light.color, light.game);
               
         }
         else
         {
            if (angleDifference1 <= 0) // Light büyük
            {
               double angle =  - alpha + beta + light.angle;
               return new Light( light.getEndX(), light.getEndY(), angle, light.color, light.game);
            }
            else // Merkez büyük
            {
             double angle = alpha - beta + light.angle;
               return new Light( light.getEndX(), light.getEndY(), angle, light.color, light.game);
            }
         }
      
      
      
     }
     
     // Merkez1, çýkan
     else if ( length1 >= CENTER - TOLERANCE && length1 < CENTER)
     {
      
      Vector centerVect1 = new Vector(light.endX-getXCenter1(), -light.endY+getYCenter1());
      double angleDifference1 = centerVect1.angle() - light.vector.angle();
      if(angleDifference1 < 0)
      {
       angleDifference1+=360;
      }

      else if (angleDifference1 > 180)
      {
       angleDifference1-=360;
      }
      
         // finding the angle between the coming light and the vector from center to the intersection
         double dotProduct = lightVect.x * centerVect1.x + lightVect.y * centerVect1.y;
         double magnitudeProduct = lightVect.m() * centerVect1.m();
         double alpha = Math.toDegrees(Math.acos(dotProduct / magnitudeProduct));
         
         
         if (alpha > 90)
         {
          alpha = 180 - alpha;
         }
         
         if ( alpha > LIMITING_ANGLE)
         {
          if (angleDifference1 > 180)
             {
              //System.out.println("1");
                
                   double angle = -2 * alpha - 180 + light.angle;
                   return new Light( light.getEndX(), light.getEndY(), angle, light.color, light.game);   
                
             }
             
             else if (angleDifference1 < -180)
             {
              
                   double angle =  180 + 2 * alpha + light.angle;
                   return new Light( light.getEndX(), light.getEndY(), angle, light.color, light.game);
                   
             }
             else
             {
              //System.out.println("3");
                if (angleDifference1 <= 0)
                {
                   double angle =  -2 * alpha - 180 + light.angle ;
                   return new Light( light.getEndX(), light.getEndY(), angle, light.color, light.game);
                }
                else
                {
                   double angle = 180 + 2 * alpha + light.angle;
                   return new Light( light.getEndX(), light.getEndY(), angle, light.color, light.game);
                }
             }
         }
         
         double beta = Math.abs(Math.toDegrees(Math.asin(  Math.sin( Math.toRadians(alpha)) * GLASS_INDEX  )));
         
         
         if (angleDifference1 > 180) // Light büyük
         {
               double angle = - alpha + beta + light.angle;
               return new Light( light.getEndX(), light.getEndY(), angle, light.color, light.game);   
            
         }
         
         else if (angleDifference1 < -180) // Merkez büyük
         {
          
               double angle = alpha - beta + light.angle;
               return new Light( light.getEndX(), light.getEndY(), angle, light.color, light.game);
               
         }
         else
         {
            if (angleDifference1 <= 0) // Light büyük
            {
               double angle =  - alpha + beta + light.angle;
               return new Light( light.getEndX(), light.getEndY(), angle, light.color, light.game);
            }
            else // Merkez büyük
            {
               double angle = alpha - beta + light.angle;
               return new Light( light.getEndX(), light.getEndY(), angle, light.color, light.game);
            }
         }
      
      
      
      
     }
     
  // Merkez2, giren
     else if (length2 <= CENTER + TOLERANCE && length2 >= CENTER)
     {
      Vector centerVect2 = new Vector(light.endX-getXCenter2(), -light.endY+getYCenter2()).negate();
      double angleDifference2 = centerVect2.angle() - light.vector.angle();
      if(angleDifference2 < 0)
      {
       angleDifference2+=360;
      }

      else if (angleDifference2 > 180)
      {
       angleDifference2-=360;
      }
      

         centerVect2 = new Vector(light.endX-getXCenter2(), -light.endY+getYCenter2()).negate();
         // finding the angle between the coming light and the vector from center to the intersection
         double dotProduct = lightVect.x * centerVect2.x + lightVect.y * centerVect2.y;
         double magnitudeProduct = lightVect.m() * centerVect2.m();
         double alpha = Math.toDegrees(Math.acos(dotProduct / magnitudeProduct));
         
         
         if (alpha > 90)
         {
          alpha = 180 - alpha;
         }
         
         double beta = Math.abs(Math.toDegrees(Math.asin(  Math.sin( Math.toRadians(alpha)) / GLASS_INDEX  )));
         
         
         
         if (angleDifference2 > 180) // Light büyük
         {
               double angle = - alpha + beta + light.angle;
               return new Light( light.getEndX(), light.getEndY(), angle, light.color, light.game);   
            
         }
         
         else if (angleDifference2 < -180) // Merkez büyük
         {
          
               double angle = alpha - beta + light.angle;
               return new Light( light.getEndX(), light.getEndY(), angle, light.color, light.game);
               
         }
         else
         {
            if (angleDifference2 <= 0) // Light büyük
            {
               double angle =  - alpha + beta + light.angle;
               return new Light( light.getEndX(), light.getEndY(), angle, light.color, light.game);
            }
            else // Merkez büyük
            {
               double angle = alpha - beta + light.angle;
               return new Light( light.getEndX(), light.getEndY(), angle, light.color, light.game);
            }
         }
      
     }
     
     // Merkez2, çýkan
     else if ( length2 >= CENTER - TOLERANCE && length2 <= CENTER)
     {
      

      Vector centerVect2 = new Vector(light.endX-getXCenter2(), -light.endY+getYCenter2());
      double angleDifference2 = centerVect2.angle() - light.vector.angle();
      if(angleDifference2 < 0)
      {
       angleDifference2+=360;
      }

      else if (angleDifference2 > 180)
      {
       angleDifference2-=360;
      }
      
         // finding the angle between the coming light and the vector from center to the intersection
         double dotProduct = lightVect.x * centerVect2.x + lightVect.y * centerVect2.y;
         double magnitudeProduct = lightVect.m() * centerVect2.m();
         double alpha = Math.toDegrees(Math.acos(dotProduct / magnitudeProduct));
         
         
         if (alpha > 90)
         {
          alpha = 180 - alpha;
         }
         
         if ( alpha > LIMITING_ANGLE)
         {
          if (angleDifference2 > 180)
             {
              //System.out.println("1");
                
                   double angle = -2 * alpha - 180 + light.angle;
                   return new Light( light.getEndX(), light.getEndY(), angle, light.color, light.game);   
                
             }
             
             else if (angleDifference2 < -180)
             {
              
                   double angle =  180 + 2 * alpha + light.angle;
                   return new Light( light.getEndX(), light.getEndY(), angle, light.color, light.game);
                   
             }
             else
             {
              //System.out.println("3");
                if (angleDifference2 <= 0)
                {
                   double angle =  -2 * alpha - 180 + light.angle ;
                   return new Light( light.getEndX(), light.getEndY(), angle, light.color, light.game);
                }
                else
                {
                   double angle = 180 + 2 * alpha + light.angle;
                   return new Light( light.getEndX(), light.getEndY(), angle, light.color, light.game);
                }
             }
         }
         
         double beta = Math.abs(Math.toDegrees(Math.asin(  Math.sin( Math.toRadians(alpha)) * GLASS_INDEX  )));
         /*
              System.out.println( Math.toRadians(alpha) );
              System.out.println( Math.sin( Math.toRadians(alpha)));
              System.out.println( Math.sin( Math.toRadians(alpha)) * GLASS_INDEX);
              System.out.println( Math.asin(  Math.sin( Math.toRadians(alpha)) * GLASS_INDEX ) );
              System.out.println( Math.toDegrees(Math.asin(  Math.sin( Math.toRadians(alpha)) * GLASS_INDEX  )) );
              */
              
         if (angleDifference2 > 180) // Light büyük
         {
            double angle = - alpha + beta + light.angle;
               return new Light( light.getEndX(), light.getEndY(), angle, light.color, light.game);   
            
         }
         
         else if (angleDifference2 < -180) // Merkez büyük
         {
          double angle = alpha - beta + light.angle;
          return new Light( light.getEndX(), light.getEndY(), angle, light.color, light.game);
               
         }
         else
         {
            if (angleDifference2 <= 0) // Light büyük
            {
            double angle =  - alpha + beta + light.angle;
               return new Light( light.getEndX(), light.getEndY(), angle, light.color, light.game);
            }
            else // Merkez büyük
            {
               double angle = alpha - beta + light.angle;
               return new Light( light.getEndX(), light.getEndY(), angle, light.color, light.game);
            }
         }
     }
     
     return null;
 }

  @Override
    public int touches(Light light) {
     
     length1 = Math.sqrt( Math.abs((light.endy-getYCenter1())*(light.endy-getYCenter1())+(light.endx - getXCenter1())*(light.endx - getXCenter1() )));
     length2 = Math.sqrt( Math.abs((light.endy-getYCenter2())*(light.endy-getYCenter2())+(light.endx - getXCenter2())*(light.endx - getXCenter2() )));

   
   if ( (length1 <= CENTER + TOLERANCE && length1 >= CENTER - TOLERANCE) && length2 < CENTER)
   {
    return 1;
   }
       
   else if ( (length2 <= CENTER + TOLERANCE && length2 >= CENTER - TOLERANCE) && length1 < CENTER)
   {
    return 1;
       }
       
       
       return -1;
    }

}

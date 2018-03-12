public interface OpticStuff {
   
   int getRow();
   int getColumn();
   int getX();
   int getY();
   //void setRow(int row);
   //void setColumn(int column);
   int touches( Light light);
   String getImageName();
}

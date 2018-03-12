import sun.audio.*;   
public class Ses
   {
      public void Cal(String path)
      {
         try
         {
            InputStream muzikal = new FileInputStream(path);
            AudioStream muzikstreamet = new AudioStream(muzikal);
            AudioPlayer.player.start(muzikstreamet);
         }
         catch (Exception e)
         {
            System.out.println("Oluþan Hata: "+ e.getMessage());
         }
      }
   }
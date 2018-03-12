import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.EventQueue;             
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import sun.audio.*;

public class OpticsGame
{
   static Panel0 panel0;
   static Panel1 panel1;
   static Panel2 panel2;
   // static PanelHowTo panelHowTo;
   
   static PanelLevel1 panelLevel1;
   static PanelLevel2 panelLevel2;
   static PanelLevel3 panelLevel3;
   static PanelLevel4 panelLevel4;
   static PanelLevel5 panelLevel5;
   static PanelLevel6 panelLevel6;
   static PanelLevel7 panelLevel7;
   static PanelLevel8 panelLevel8; 
   
   
   // static Panel3 panel3;
   JFrame f;
   Game game1, game2, game3, game4;
   Game game5, game6, game7, game8;
   
   JLabel level = new JLabel(" LEVEL NO ");
   JButton q = new JButton("Try a Question");
   
   
   public OpticsGame()
   {
      
      panel0 = new Panel0();
      panel1 = new Panel1();
      panel2 = new Panel2();
      
      
      panelLevel1 = new PanelLevel1();
      panelLevel2 = new PanelLevel2();
      panelLevel3 = new PanelLevel3();
      panelLevel4 = new PanelLevel4();
      panelLevel5 = new PanelLevel5();
      panelLevel6 = new PanelLevel6();
      panelLevel7 = new PanelLevel7();
      panelLevel8 = new PanelLevel8(); 
      
      level.setBounds(30,0,300,30);
      level.setForeground(Color.BLUE);
      
      q.setBounds(225,757,200,40);
      q.setBackground( Color.BLUE );
      
      f = new MyJFrame();
      
   }
 
   public static void Cal(String path)
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
   
   public static void main (String[] args)
   {
      OpticsGame a = new OpticsGame();
      Cal("C://1.wav");
      Cal("C://1.wav");
      Cal("C://1.wav");
      Cal("C://1.wav");
      Cal("C://1.wav");
      Cal("C://1.wav");
      Cal("C://1.wav");
      Cal("C://1.wav");
   }

   class MyJFrame extends JFrame {
      public MyJFrame() {
         
         
         Container c = getContentPane();
         c.setLayout(null);
         c.add(panel0);
         panel1.setVisible(false);
         c.add(panel1);
         panel2.setVisible(false);
         c.add(panel2);
         
         
         
         panelLevel1.setVisible(false);
         c.add(panelLevel1);
         panelLevel2.setVisible(false);
         c.add(panelLevel2);
         panelLevel3.setVisible(false);
         c.add(panelLevel3);
         panelLevel4.setVisible(false);
         c.add(panelLevel4);
         panelLevel5.setVisible(false);
         c.add(panelLevel5);
         panelLevel6.setVisible(false);
         c.add(panelLevel6);
         panelLevel7.setVisible(false);
         c.add(panelLevel7);
         panelLevel8.setVisible(false);
         c.add(panelLevel8); 
         
         
         
         
         setTitle( "Optics Game");
         setBounds( 0, 0, 1440, 900);
         setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
         setVisible(true);
         
      }
   }
   public class Panel0 extends JPanel{
      
      public Panel0(){
         setBounds(0, 0, 1440, 900);
         setLayout(null);
         
         
         
         
         JLabel txt = new JLabel(" OPTICS GAME ");
         txt.setBounds(150,196,300,90);
         txt.setForeground(Color.GREEN);
         add(txt);
         
         Font newLabelFont =  new Font ( "OPTICS GAME ", Font.BOLD, 32);
         
         txt.setFont( newLabelFont );
         
         JButton btnNewButton_2 = new JButton("Play");
         btnNewButton_2.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e) {
               panel0.setVisible(false);
               panel1.setVisible(true);
            }
         });
         add(btnNewButton_2);
         btnNewButton_2.setBounds(1000,370,300,75);
         
         
         
         JButton btnNewButton_1 = new JButton("How To");
         btnNewButton_1.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e) {
               
            }
         });
         add(btnNewButton_1);
         btnNewButton_1.setBounds(1000,490,300,75);
         
         
         
         JButton btnNewButton = new JButton("Quit");
         btnNewButton.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e) {
               
               f.dispose();
            }
         });
         add(btnNewButton);
         btnNewButton.setBounds(1000,610,300,75);
         JButton a = new JButton("Settings");
         add(a);
         a.setBounds(1180,120,120,60);
         a.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e) {
               //   game1.setGamePanelVisible(false);
               
               // HOW TO PANEL
               
               
               
               
            }
         }); 
         
         JLabel pic = new JLabel( new ImageIcon("panel0.png"));
         //setBackGround( java.awt.Color.RED);
         pic.setBounds(0,0,1440,900);
         pic.setVisible(true);
         add(pic);
         
         
      }
      
   }
   public class Panel1 extends JPanel 
   {
      public Panel1()
      {
         
         setBounds(0, 0, 1440, 900);
         setLayout(null);
         
         
         JButton a = new JButton("Back");
         add(a);
         a.setBounds(25,757,70,40);
         a.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e) {
               
               setVisible(false);
               panel0.setVisible(true);
               
               
            }
         });
         JLabel txt = new JLabel(" OPTICS GAME ");
         txt.setBounds(150,196,300,90);
         txt.setForeground(Color.GREEN);
         add(txt);
         
         Font newLabelFont =  new Font ( "OPTICS GAME ", Font.BOLD, 32);
         
         txt.setFont( newLabelFont );
         
         JButton btnNewButton_2 = new JButton("New Game");
         btnNewButton_2.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e) {
               panel1.setVisible(false);
               panel2.setVisible(true);
            }
         });
         add(btnNewButton_2);
         btnNewButton_2.setBounds(1000,370,300,75);
         
         
         
         JButton btnNewButton_1 = new JButton("Load Game");
         btnNewButton_1.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e) {
               
            }
         });
         add(btnNewButton_1);
         btnNewButton_1.setBounds(1000,490,300,75);
         
         
         
         JButton btnNewButton = new JButton("Free Mode");
         btnNewButton.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e) {
               
               
            }
         });
         add(btnNewButton);
         btnNewButton.setBounds(1000,610,300,75);
         
         
         JLabel pic = new JLabel( new ImageIcon("panel0.png"));
         //setBackGround( java.awt.Color.RED);
         pic.setBounds(0,0,1440,900);
         pic.setVisible(true);
         add(pic);
         
         
      }
   }
   
   
   public class Panel2 extends JPanel 
   {
      
      public Panel2
         () {
         
         setLayout(null);
         
         
         
         setBounds(0, 0, 1440, 900);
         
         
         
         JButton a = new JButton("Turn Menu");
         add(a);
         a.setBounds(25,717,120,60);
         a.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e) {
               
               
               setVisible(false);
               panelLevel2.setVisible(false);
               panel2.setVisible(false);
               panel0.setVisible(true);
               
               
            }
         });
         
         
         JButton b = new JButton("1");
         
         b.setOpaque(true);
         //b.setBackground(Color.BLUE);
         //b.setIcon(new ImageIcon("imageLevel1.png"));
         
         b.setBounds(225,180,180,180);
         add(b);
         b.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e)  {
               
               
               panel2.setVisible(false);
               
               PanelLevel1 panelLevel1 = new PanelLevel1();
               f.add(panelLevel1); 
               
               panelLevel1.setVisible(true);
               
               
               
            }});
         
         JButton c = new JButton("2");
         add(c);
         c.setBounds(495,180,180,180);
         c.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e)  {
               
               
               panel2.setVisible(false);
               PanelLevel2 panelLevel2 = new PanelLevel2();
               f.add(panelLevel2);
               panelLevel2.setVisible(true);
               
               
               
            }});
         
         JButton d = new JButton("3");
         add(d);
         d.setBounds(765,180,180,180);
         d.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e)  {
               
               
               panel2.setVisible(false);
               PanelLevel3 panelLevel3 = new PanelLevel3();
               f.add(panelLevel3); 
               
               panelLevel3.setVisible(true);
               
               
               
            }});
         
         JButton e = new JButton("4");
         add(e);
         e.setBounds(1035,180,180,180);
         e.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e)  {
               
               
               panel2.setVisible(false);
               PanelLevel4 panelLevel4 = new PanelLevel4();
               f.add(panelLevel4); 
               
               panelLevel4.setVisible(true);
               
               
            }});
         
         JButton f = new JButton("5");
         add(f);
         f.setBounds(225,450,180,180);
         //  f.setIcon(new ImageIcon("5.png"));
         f.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e)  {
               
               
               panel2.setVisible(false);
               
               PanelLevel5 panelLevel5 = new PanelLevel5();
               f.add(panelLevel5); 
               
               panelLevel5.setVisible(true);
               //panelLevel1.setVisible(true);
               
               
               
            }});
         
         
         
         JButton g = new JButton("6");
         add(g);
         g.setBounds(495,450,180,180);
         g.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e)  {
               
               
               panel2.setVisible(false);
               PanelLevel6 panelLevel6 = new PanelLevel6();
               f.add(panelLevel6); 
               
               panelLevel6.setVisible(true);
               
               
               
            }});
         
         
         JButton h = new JButton("7");
         add(h);
         h.setBounds(765,450,180,180);
         h.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e)  {
               
               
               panel2.setVisible(false);
               PanelLevel7 panelLevel7 = new PanelLevel7();
               f.add(panelLevel7); 
               
               panelLevel7.setVisible(true);
               
               
               
            }});
         
         
         JButton i = new JButton("8");
         add(i);
         i.setBounds(1035,450,180,180);
         i.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e)  {
               
               
               panel2.setVisible(false);
               PanelLevel8 panelLevel8 = new PanelLevel8();
               f.add(panelLevel8); 
               
               panelLevel8.setVisible(true);
               
               
               
            }});
         
         
         JLabel pic = new JLabel( new ImageIcon("panel2.png"));
         //setBackGround( java.awt.Color.RED);
         pic.setBounds(0,0,1440,900);
         pic.setVisible(true);
         add(pic);
      }
   }
   
   
   public class PanelLevel1 extends JPanel
   {
      public PanelLevel1()
      {
         setLayout(null);
         setBounds(0, 0, 1440, 900);
         
         game1 = new Game();
         
         game1.setGamePanelVisible(true);
         add(game1.gamePanel);
         
         level.setText(" LEVEL 1 ");
         add(level); 
         
         add(q);
         q.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e) 
            {
               // Question...... 
               
            }});
         
         
         JButton a = new JButton("Back");
         add(a);
         a.setBounds(25,757,70,40);
         a.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e) {
               //   game1.setGamePanelVisible(false);
               setVisible(false);
               panel2.setVisible(true); 
            }
         });
         
         JButton r = new JButton("Restart");
         add(r);
         r.setBounds(150,757,70,40);
         r.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e){
               
               setVisible(false);
               PanelLevel1 panelLevel1 = new PanelLevel1();
               f.add(panelLevel1); 
               panelLevel1.setVisible(true);
               
            } 
         });
         
         
         try
         {  
            
            
            game1.add( new LightSource(13,6,90, Color.RED, game1)) ;
            game1.add( new LightSource(18,0,270,Color.RED, game1)); 
            game1.add( new LightSource(8,6,90,Color.GREEN, game1));  
            
            game1.add( new Obstacle( 3,8,1,1,game1));
            game1.add( new Obstacle( 13,2,1,2,game1));
            game1.add( new Obstacle( 7,5,2,game1));
            game1.add( new Obstacle( 17,5,3,game1));
            
            game1.add( new PlanarMirror(15,5,90));
            game1.add( new PlanarMirror(10,5,90));
            game1.add( new PlanarMirror(5,6,90));
            
            game1.add( new ConcaveMirror(5,5,90));
            game1.add( new ConvexMirror(3,5,90));
            game1.add( new ConvexLens(12,10,90));
            game1.add( new Target(15,10,Color.GREEN));
            game1.add( new Target(3,10,Color.RED));
            game1.add( new Filter (11,6,0,Color.GREEN));
            
            //        game1.add( new Target(10,10,Color.RED,game1));
            //        game1.add( new Target(9,5,Color.GREEN,game1));
            //        game1.add( new Target(1,1,Color.BLUE,game1));
            
         }
         
         catch (IOException e1) {
            
            e1.printStackTrace();
         }
         
      }
   }
   public class PanelLevel2 extends JPanel
   {
      public PanelLevel2()
      {
         setLayout(null);
         setBounds(0, 0, 1440, 900);
         
         game1 = new Game();
         
         game1.setGamePanelVisible(true);
         add(game1.gamePanel);
         
         level.setText(" LEVEL 2 ");
         add(level); 
         
         add(q);
         q.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e) 
            {
               // Question...... 
               
            }});
         
         
         JButton a = new JButton("Back");
         add(a);
         a.setBounds(25,757,70,40);
         a.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e) {
               //   game1.setGamePanelVisible(false);
               setVisible(false);
               panel2.setVisible(true);
               
               //panelLevel2.setVisible(false);
               
            }
         });
         JButton r = new JButton("Restart");
         add(r);
         r.setBounds(150,757,70,40);
         r.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e){
               
               setVisible(false);
               PanelLevel2 panelLevel2 = new PanelLevel2();
               f.add(panelLevel2); 
               panelLevel2.setVisible(true);
               
            } 
         });
         
         
         try
         {
            
            
            game1.add(new LightSource( 2,0,0,Color.GREEN, game1)) ;
            
            game1.add( new LightSource( 5,9,44,Color.MAGENTA, game1));
         }
         
         catch (IOException e1) { 
            e1.printStackTrace();
         }
         
      }
   }
   public class PanelLevel3 extends JPanel
   {
      public PanelLevel3()
      {
         setLayout(null);
         setBounds(0, 0, 1440, 900);
         
         game1 = new Game();
         
         game1.setGamePanelVisible(true);
         add(game1.gamePanel);
         level.setText(" LEVEL 3 ");
         add(level); 
         
         add(q);
         q.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e) 
            {
               // Question...... 
               
            }});
         
         JButton a = new JButton("Back");
         add(a);
         a.setBounds(25,757,70,40);
         a.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e) {
               //   game1.setGamePanelVisible(false);
               setVisible(false);
               panel2
                  .setVisible(true); 
            }
         });
         JButton r = new JButton("Restart");
         add(r);
         r.setBounds(150,757,70,40);
         r.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e){
               
               setVisible(false);
               PanelLevel3 panelLevel3 = new PanelLevel3();
               f.add(panelLevel3); 
               panelLevel3.setVisible(true);
               
            } 
         });
         
         try
         {
            game1.add( new PlanarMirror(10,0,0))  ;
            game1.add( new PlanarMirror(10,10,23))  ;
            game1.add( new PlanarMirror(15,10,60))  ;
            game1.add( new PlanarMirror(22,11,0)) ;
            game1.add( new PlanarMirror(12,11,0)) ;
            game1.add( new PlanarMirror(2,11,0)) ;
            
         }
         
         catch (IOException e1) {
            System.out.println("c");
            e1.printStackTrace();
         }
         
      }
   }
   public class PanelLevel4 extends JPanel
   {
      public PanelLevel4()
      {
         setLayout(null);
         setBounds(0, 0, 1440, 900);
         
         game1 = new Game();
         
         game1.setGamePanelVisible(true);
         add(game1.gamePanel);
         level.setText(" LEVEL 4 ");
         add(level); 
         
         add(q);
         q.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e) 
            {
               // Question...... 
               
            }});
         
         
         JButton a = new JButton("Back");
         add(a);
         a.setBounds(25,757,70,40);
         a.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e) {
               //   game1.setGamePanelVisible(false);
               setVisible(false);
               panel2
                  .setVisible(true); 
               
            }
         });
         JButton r = new JButton("Restart");
         add(r);
         r.setBounds(150,757,70,40);
         r.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e){
               
               setVisible(false);
               PanelLevel4 panelLevel4 = new PanelLevel4();
               f.add(panelLevel4); 
               panelLevel4.setVisible(true);
               
            } 
         });
         
         
         try
         {
            game1.add( new PlanarMirror(0,0,0))  ;
            game1.add( new PlanarMirror(10,10,23))  ;
            
            game1.add( new PlanarMirror(2,9,0)) ;
            
         }
         
         catch (IOException e1) {
            
            e1.printStackTrace();
         }
         
         
      }
   }
   public class PanelLevel5 extends JPanel
   {
      
      public PanelLevel5()
      {
         setLayout(null);
         setBounds(0, 0, 1440, 900);
         
         game1 = new Game();
         
         game1.setGamePanelVisible(true);
         add(game1.gamePanel);
         
         level.setText(" LEVEL 5 ");
         add(level); 
         
         add(q);
         q.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e) 
            {
               // Question...... 
               
            }});
         
         
         JButton a = new JButton("Back");
         add(a);
         a.setBounds(25,757,70,40);
         a.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e) {
               //   game1.setGamePanelVisible(false);
               setVisible(false);
               panel2.setVisible(true); 
            }
         });
         JButton r = new JButton("Restart");
         add(r);
         r.setBounds(150,757,70,40);
         r.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e){
               
               setVisible(false);
               PanelLevel5 panelLevel5 = new PanelLevel5();
               f.add(panelLevel5); 
               panelLevel5.setVisible(true);
               
            } 
         });
         
         try
         {  
            game1.add( new PlanarMirror(0,0,60))  ;
            game1.add( new PlanarMirror(0,10,60))  ;
            game1.add( new LightSource(13,6,90, Color.RED, game1)) ;
            game1.add( new LightSource(18,0,270,Color.RED, game1)); 
            game1.add( new LightSource(8,6,90,Color.GREEN, game1));  
            
            
         }
         
         catch (IOException e1) {
            
            e1.printStackTrace();
         }
         
      }
   }
   public class PanelLevel6 extends JPanel
   {
      public PanelLevel6()
      {
         setLayout(null);
         setBounds(0, 0, 1440, 900);
         
         game1 = new Game();
         
         game1.setGamePanelVisible(true);
         add(game1.gamePanel);
         
         level.setText(" LEVEL 6 ");
         add(level); 
         
         add(q);
         q.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e) 
            {
               // Question...... 
               
            }});
         
         
         JButton a = new JButton("Back");
         add(a);
         a.setBounds(25,757,70,40);
         a.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e) {
               //   game1.setGamePanelVisible(false);
               setVisible(false);
               panel2
                  .setVisible(true);
               
               //panelLevel2.setVisible(false);     
            }
         });
         JButton r = new JButton("Restart");
         add(r);
         r.setBounds(150,757,70,40);
         r.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e){
               
               setVisible(false);
               PanelLevel6 panelLevel6 = new PanelLevel6();
               f.add(panelLevel6); 
               panelLevel6.setVisible(true);
               
            } 
         });
         
         
         try
         {
            game1.add( new PlanarMirror(0,0,0))  ;
            
            game1.add( new PlanarMirror(22,11,0)) ;
            
         }
         
         catch (IOException e1) {
            
            e1.printStackTrace();
         }
         
      }
   }
   public class PanelLevel7 extends JPanel
   {
      public PanelLevel7()
      {
         setLayout(null);
         setBounds(0, 0, 1440, 900);
         
         game1 = new Game();
         
         game1.setGamePanelVisible(true);
         add(game1.gamePanel);
         level.setText(" LEVEL 7 ");
         add(level); 
         
         add(q);
         q.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e) 
            {
               // Question...... 
               
            }});
         
         
         JButton a = new JButton("Back");
         add(a);
         a.setBounds(25,757,70,40);
         a.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e) {
               //   game1.setGamePanelVisible(false);
               setVisible(false);
               panel2.setVisible(true); 
            }
         });
         JButton r = new JButton("Restart");
         add(r);
         r.setBounds(150,757,70,40);
         r.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e){
               
               setVisible(false);
               PanelLevel7 panelLevel7 = new PanelLevel7();
               f.add(panelLevel7); 
               panelLevel7.setVisible(true);
               
            } 
         }); 
         
         try
         { 
            game1.add( new PlanarMirror(15,10,60))  ;
            game1.add( new PlanarMirror(22,11,0)) ;
            
         }
         
         catch (IOException e1) {
            System.out.println("c");
            e1.printStackTrace();
         }
         
      }
   }
   public class PanelLevel8 extends JPanel
   {
      public PanelLevel8()
      {
         setLayout(null);
         setBounds(0, 0, 1440, 900);
         
         game1 = new Game();
         
         game1.setGamePanelVisible(true);
         add(game1.gamePanel);
         
         level.setText(" LEVEL 8 ");
         add(level); 
         
         add(q);
         q.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e) 
            {
               // Question...... 
               
            }});
         
         JButton a = new JButton("Back");
         add(a);
         a.setBounds(25,757,70,40);
         a.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e) {
               
               setVisible(false);
               panel2.setVisible(true); 
            }
         });
         JButton r = new JButton("Restart");
         add(r);
         r.setBounds(150,757,70,40);
         r.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e){
               
               setVisible(false);
               PanelLevel8 panelLevel8 = new PanelLevel8();
               f.add(panelLevel8); 
               panelLevel8.setVisible(true);
               
            } 
         });
         
         try
         {
            game1.add( new PlanarMirror(0,0,23))  ;        
         }
         
         catch (IOException e1) {
            System.out.println("c");
            e1.printStackTrace();
         }
      }
   }
   
}
/*import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;*/
import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Draw extends JComponent{

    public BufferedImage image;
    public BufferedImage backgroundImage;
    public URL resource = getClass().getResource("run0.png");

      public int x = 300;
      public int y = 300;
      public int state = 0;
    
      public Draw(){
        try{
            image = ImageIO.read(resource);
            backgroundImage = ImageIO.read(getClass().getResource("background.jpg"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void reloadImage(){
        state++;
        if(state == 0) {
            resource = getClass().getResource("run0.png");
        }
        else if(state == 1) {
            resource = getClass().getResource("run1.png");
        }
        else if(state == 2) {
            resource = getClass().getResource("run2.png");
        }
        else if(state == 3) {
            resource = getClass().getResource("run3.png");
        }
        else if(state == 4) {
            resource = getClass().getResource("run4.png");
        }
        else if(state == 5) {
            resource = getClass().getResource("run5.png");
            state = 0;
        }
            try{
            image = ImageIO.read(resource);
        }
            catch(IOException e){
            e.printStackTrace();
        }
        }
        public void attackAnimation(){
        Thread thread = new Thread(new Runnable(){
            public void run(){
                for(int ctr = 0; ctr < 7; ctr++){
                    try {
                        if(ctr==6){
                            resource = getClass().getResource("run0.png");
                        }
                        else{
                            resource = getClass().getResource("attack"+ctr+".png");
                        }
                        
                        try{
                            image = ImageIO.read(resource);
                        }
                        catch(IOException e){
                            e.printStackTrace();
                        }
                        repaint();
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
  
 }
 public void counterattackAnimation(){
        Thread thread1 = new Thread(new Runnable(){
            public void run(){
                for(int ctr = 0; ctr < 7; ctr++){
                    try {
                        if(ctr==6){
                            resource = getClass().getResource("run0.png");
                        }
                        else{
                            resource = getClass().getResource("atake"+ctr+".png");
                        }
                        
                        try{
                            image = ImageIO.read(resource);
                        }
                        catch(IOException e){
                            e.printStackTrace();
                        }
                        repaint();
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
    }

    public void airattackAnimation(){
        Thread thread2 = new Thread(new Runnable(){
            public void run(){
                for(int ctr = 0; ctr < 4; ctr++){
                    try {
                        if(ctr==3){
                            resource = getClass().getResource("strike0.png");
                        }
                        else{
                            resource = getClass().getResource("strike"+ctr+".png");
                        }
                        try{
                            image = ImageIO.read(resource);
                        }
                        catch(IOException e){
                            e.printStackTrace();
                        }
                        repaint();
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread2.start();
    }

    public void attack(){
        attackAnimation();
    }
    public void attack1(){
      counterattackAnimation();
    }
     public void attack2(){
      airattackAnimation();
    }

      public void moveUp(){
      y = y - 20;
      reloadImage();
      repaint();
      }
      public void moveDown(){
      y = y + 20;
      reloadImage();
      repaint();
      }
      public void moveLeft(){
      x = x - 20;
      reloadImage();
      repaint();
      }
      public void moveRight(){
      x = x + 20;
      reloadImage();
      repaint();
      }
      public void paintComponent(Graphics g){
      super.paintComponent(g);
      g.setColor(Color.YELLOW);
      g.drawImage(backgroundImage, 0, 0, this);
      g.drawImage(image, x, y, this);
      }
}

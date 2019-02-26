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

      public int x = 500;
    public int y = 300;
    public int height = 60;
    public int width = 490;
    // animation states
    public int state = 0;

    //ENEMY COMPONENTS
    // randomizer
    public Random randomizer;

    public void startGame()
{
        Thread gameThread = new Thread(new Runnable(){
            public void run(){
                while(true){
                    try{
                        for(int c = 0; c < monsters.length; c++){
                            if(monsters[c]!=null){
                                monsters[c].moveTo(x,y);
                                repaint();
                            }
                        }
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                            e.printStackTrace();
                    }
                }
            }
        });
        gameThread.start();
    }
          //ENEMENY COMPONENTS ^^^^^
    public int enemyCount;
    Monster[] monsters = new Monster[10];
    public Draw()
    {
        randomizer = new Random();
        spawnEnemy();

        try{

            image = ImageIO.read(resource);
            backgroundImage = ImageIO.read(getClass().getResource("BG City.jpg"));
        }
        catch(IOException e){
            e.printStackTrace();   
        }
        height = image.getHeight();
        width =  image.getWidth();
        startGame();
    }
    public void spawnEnemy()
    {
        if(enemyCount < 10)
        {
            monsters[enemyCount] = new Monster(randomizer.nextInt(500), randomizer.nextInt(500), this);
            enemyCount++;
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
                        
                        try
                        {
                            image = ImageIO.read(resource);
                        }
                        catch(IOException e)
                        {
                            e.printStackTrace();
                        }
                        repaint();
                        Thread.sleep(100);
                    }
                     catch (InterruptedException e) 
                    {
                        e.printStackTrace();
                    }
                }
                for(int x=0; x<monsters.length; x++)
                {
                    if(monsters[x]!=null)
                    {
                        if(monsters[x].contact)
                        {
                            monsters[x].life = monsters[x].life - 10;
                        }
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
                for(int ctr = 0; ctr < 5; ctr++){
                    try {
                        if(ctr==4){
                            resource = getClass().getResource("run0.png");
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
       checkCollision();
      }
      public void moveDown(){
      y = y + 20;
      reloadImage();
      repaint();
       checkCollision();
      }
      public void moveLeft(){
      x = x - 20;
      reloadImage();
      repaint();
       checkCollision();
      }
      public void moveRight(){
      x = x + 20;
      reloadImage();
      repaint();
       checkCollision();
      }

      //ENEMY SHITS
public void checkCollision()
{
        int xChecker = x + width;
        int yChecker = y;
        for(int x=0; x<monsters.length; x++)
        {
            boolean collideX = false;
            boolean collideY = false;
            if(monsters[x]!=null)
            {
                monsters[x].contact = false;
                if(yChecker > monsters[x].yPos)
                {
                    if(yChecker-monsters[x].yPos < monsters[x].height){
                        collideY = true;
                        System.out.println("collideY");
                    }
                }
                else{
                    if(monsters[x].yPos - yChecker < monsters[x].height){
                        collideY = true;
                        System.out.println("collideY");
                    }
                }
                if(xChecker > monsters[x].xPos){
                    if(xChecker-monsters[x].xPos < monsters[x].width){
                        collideX = true;
                        System.out.println("collideX");
                    }
                }
                else{
                    if(monsters[x].xPos - xChecker < 5){
                        collideX = true;
                        System.out.println("collideX");
                    }
                }
            }
            if(collideX && collideY){
                System.out.println("collision!");
                monsters[x].contact = true;
            }
        }
    }

    //ENEMY SHITS LAST
        public void paintComponent(Graphics g)
        {
        super.paintComponent(g);
        g.setColor(Color.YELLOW);
        g.drawImage(backgroundImage, 0, 0, this);
        g.drawImage(image, x, y, this);
        //ENEMY
        for(int c = 0; c < monsters.length; c++)
        {
            if(monsters[c]!=null){
                // character grid for monsters
                // g.setColor(Color.BLUE);
                // g.fillRect(monsters[c].xPos, monsters[c].yPos+5, monsters[c].width, monsters[c].height);
                g.drawImage(monsters[c].image, monsters[c].xPos, monsters[c].yPos, this);
                g.setColor(Color.GREEN);
                g.fillRect(monsters[c].xPos+7, monsters[c].yPos, monsters[c].life, 2);
            }   
        }
    }
    public void checkDeath(){
        for(int c = 0; c < monsters.length; c++){
            if(monsters[c]!=null){
                if(!monsters[c].alive){
                    monsters[c] = null;
                }
            }           
        }
    
}

      public void paintComponent(Graphics g){
      super.paintComponent(g);
      g.setColor(Color.YELLOW);
      g.drawImage(backgroundImage, 0, 0, this);
      g.drawImage(image, x, y, this);

      g.drawImage(monster1.image, monster1.xPos, monster1.yPos, this);

    }
  }
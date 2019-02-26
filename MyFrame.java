/*import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class MyFrame extends JFrame implements KeyListener {

  Draw drawing;

  public MyFrame(){
      this.drawing = new Draw();
  }

   public void keyPressed(KeyEvent e){
       if(e.getKeyCode() == KeyEvent.VK_UP){
           drawing.moveUp();
            System.out.println(drawing.x + " , " + drawing.y);
       }
      else if (e.getKeyCode() == KeyEvent.VK_DOWN){
          drawing.moveDown();
          System.out.println(drawing.x + " , " + drawing.y);
      }
      else if (e.getKeyCode() == KeyEvent.VK_LEFT){
          drawing.moveLeft();
          System.out.println(drawing.x + " , " + drawing.y);
      }
      else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
          drawing.moveRight();
          System.out.println(drawing.x + " , " + drawing.y);
      }
      else if(e.getKeyCode() == KeyEvent.VK_Q){
          drawing.attack();
          System.out.println("attack");
     }
     else if(e.getKeyCode() == KeyEvent.VK_W){
          drawing.attack1();
          System.out.println("counterattack");
     }
     else if(e.getKeyCode() == KeyEvent.VK_D){
          drawing.attack2();
          System.out.println("strike");
     }
    }

  public void keyReleased(KeyEvent e){

  }

  public void keyTyped(KeyEvent e){

  }

  public static void main(String args[]){

      MyFrame gameFrame = new MyFrame();
      Draw drawing = new Draw();

      gameFrame.setSize(600,600);
      gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      gameFrame.setVisible(true);
      gameFrame.getContentPane().add(gameFrame.drawing);
      gameFrame.addKeyListener(gameFrame);

  }
}*/
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame implements KeyListener{

    Draw drawing;

    public MyFrame(){
        this.drawing = new Draw();
    }

    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_UP){
            drawing.moveUp();
            System.out.println("Float: " + drawing.x + ", " + drawing.y);
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            drawing.moveRight();
            System.out.println("Move Forward: " + drawing.x + ", " + drawing.y);
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            drawing.moveDown();
            System.out.println("Slide: " + drawing.x + ", " + drawing.y);
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            drawing.moveLeft();
            System.out.println("Move Back: " + drawing.x + ", " + drawing.y);
        }
        else if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            drawing.attack();
            System.out.println("Attack");
        }
        else if(e.getKeyCode() == KeyEvent.VK_S)
        {
            drawing.spawnEnemy();
        }
    }

    public void keyReleased(KeyEvent e){

    }

    public void keyTyped(KeyEvent e){
        
    }

    public static void main(String args[]){
        MyFrame gameFrame = new MyFrame();
        gameFrame.setSize(700,500);

        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
        gameFrame.getContentPane().add(gameFrame.drawing);
        gameFrame.addKeyListener(gameFrame);
        System.out.println("practical programming");
    }
}


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;
public class Apple {

    Random rand = new Random();
    int x;
    int y;

    public Apple(){
        x = rand.nextInt(20) * 50;
        y = rand.nextInt(20) * 50;
    }

    public void paint(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(x, y, 50, 50);
    }

    public void move(){
        x = rand.nextInt(20) * 50;
        y = rand.nextInt(20) * 50;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}

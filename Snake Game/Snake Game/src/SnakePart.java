import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class SnakePart {

    int x;
    int y;
    int width = 50;
    int length = 50;

    public SnakePart(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(x, y, width, length);
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}

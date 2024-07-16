import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;

public class Snake {

    ArrayList<SnakePart> snake;
    int tempX = 0;
    int tempY = 0;

    public Snake(){
        snake = new ArrayList<SnakePart>();
    }

    public void elongate(int x , int y){
        snake.add(new SnakePart(x, y));
    }

    public int getSize(){
        return snake.size();
    }

    public void MoveRight(){
        System.out.println(snake.size());
        for(int i = snake.size() - 1; i > 0; i--){
            snake.get(i).setX(snake.get(i - 1).getX());
            snake.get(i).setY(snake.get(i - 1).getY());
        }
        snake.get(0).setX(snake.get(0).getX() + 50);
    }

    public void MoveLeft(){
        for(int i = snake.size() - 1; i > 0; i--){
            snake.get(i).setX(snake.get(i - 1).getX());
            snake.get(i).setY(snake.get(i - 1).getY());
        }
        snake.get(0).setX(snake.get(0).getX() - 50);

        //for(int i = 0; i < snake.size(); i++){
            //snake.get(i).setX(snake.get(i).getX() - 50);
        //}
    }

    public void MoveUp(){
        for(int i = snake.size() - 1; i > 0; i--){
            snake.get(i).setX(snake.get(i - 1).getX());
            snake.get(i).setY(snake.get(i - 1).getY());
        }
        snake.get(0).setY(snake.get(0).getY() - 50);
    }

    public void MoveDown(){
        for(int i = snake.size() - 1; i > 0; i--){
            snake.get(i).setX(snake.get(i - 1).getX());
            snake.get(i).setY(snake.get(i - 1).getY());
        }
        snake.get(0).setY(snake.get(0).getY() + 50);
    }

    public SnakePart getHeadCoords(){
        return snake.get(0);
    }

    public SnakePart getPartCoords(int part){
        return snake.get(part);
    }

    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        for(int i = 0; i < snake.size(); i++){
            g.fillRect(snake.get(i).getX(), snake.get(i).getY(), 50, 50);
        }
    }

}

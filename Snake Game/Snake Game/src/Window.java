import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.lang.Object;
import java.net.URL;

public class Window extends JPanel implements MouseListener, MouseMotionListener, ActionListener, KeyListener{

    boolean isMovingR = false;
    boolean isMovingL = false;
    boolean isMovingU = false;
    boolean isMovingD = false;
    boolean isTouchingWall = false;
    boolean isfirst = false;
    SnakePart snake = new SnakePart(0,0);
    Snake fullSnake = new Snake();
    Apple apple = new Apple();
    Timer wait = new Timer(75, this);
    Timer wait2 = new Timer(75, this);
    Timer wait3 = new Timer(75, this);
    Timer wait4 = new Timer(75, this);
    int tempX = 0;
    int tempY = 0;
    int count = 1;

    public Window(){
        setBackground(Color.GREEN.darker());
        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);
        setFocusable(true);
        fullSnake.elongate(0,0);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        fullSnake.paint(g);
        apple.paint(g);
        for(int i = 0; i < 20; i++){
            if(i == 9){
                g.setColor(new Color(255, 0, 0,255));
            }
            else {
                g.setColor(new Color(0, 0, 0,255));
            }
            g.fillRect(50 + (i * 50), 0, 1, 1001);

            //g.setColor(new Color(255, 255, 255,255));
        }
        for(int i = 0; i < 20; i++){
            if(i == 9){
                g.setColor(new Color(255, 0, 0,255));
            }
            else {
                g.setColor(new Color(0, 0, 0,255));
            }
            g.fillRect(0, 50 + (i * 50), 1001, 1);
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_RIGHT && isMovingL == false && count > 0){
            count = 0;
            isMovingL = false;
            isMovingU = false;
            isMovingD = false;
            isMovingR = true;
            wait2.stop();
            wait3.stop();
            wait4.stop();
            wait.start();
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT && isMovingR == false && count > 0){
            count = 0;
            isMovingR = false;
            isMovingU = false;
            isMovingD = false;
            isMovingL = true;
            wait.stop();
            wait3.stop();
            wait4.stop();
            wait2.start();
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP && isMovingD == false && count > 0){
            count = 0;
            isMovingR = false;
            isMovingL = false;
            isMovingD = false;
            isMovingU = true;
            wait.stop();
            wait2.stop();
            wait4.stop();
            wait3.start();
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN && isMovingU == false && count > 0){
            count = 0;
            isMovingR = false;
            isMovingL = false;
            isMovingU = false;
            isMovingD = true;
            wait.stop();
            wait2.stop();
            wait3.stop();
            wait4.start();
        }
    }

    public void keyReleased(KeyEvent e){

    }

    public void keyTyped(KeyEvent e){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(fullSnake.getSize() > 4){
            for(int i = 4; i < fullSnake.getSize(); i++){
                if(Math.abs(fullSnake.getPartCoords(i).getX() - fullSnake.getHeadCoords().getX()) < 50 && Math.abs(fullSnake.getPartCoords(i).getY() - fullSnake.getHeadCoords().getY()) < 50){
                    isTouchingWall = true;
                }
            }
        }
        if(!isTouchingWall){
            if(e.getSource() == wait){
                System.out.println(count);
                if(fullSnake.getHeadCoords().getX() > 900){
                    wait.stop();
                    wait2.stop();
                    wait3.stop();
                    wait4.stop();
                    isTouchingWall = true;
                }
                else {
                    if(fullSnake.getHeadCoords().getX() == apple.getX() && fullSnake.getHeadCoords().getY() == apple.getY()){
                        tempX = fullSnake.getHeadCoords().getX();
                        tempY = fullSnake.getHeadCoords().getY();
                        fullSnake.MoveRight();
                        fullSnake.elongate(tempX, tempY);
                        apple.move();
                        repaint();

                    }
                    else {
                        fullSnake.MoveRight();
                        count++;
                        repaint();
                    }
                    wait.restart();
                }
            }
            else if(e.getSource() == wait2){
                if(fullSnake.getHeadCoords().getX() < 50){
                    wait.stop();
                    wait2.stop();
                    wait3.stop();
                    wait4.stop();
                    isTouchingWall = true;
                }
                else {
                    if(fullSnake.getHeadCoords().getX() == apple.getX() && fullSnake.getHeadCoords().getY() == apple.getY()){
                        tempX = fullSnake.getHeadCoords().getX();
                        tempY = fullSnake.getHeadCoords().getY();
                        fullSnake.MoveLeft();
                        fullSnake.elongate(tempX, tempY);
                        apple.move();
                        repaint();

                    }
                    else {
                        fullSnake.MoveLeft();
                        count++;
                        repaint();
                    }
                    wait2.restart();
                }
            }
            else if(e.getSource() == wait3){
                if(fullSnake.getHeadCoords().getY() < 50){
                    wait.stop();
                    wait2.stop();
                    wait3.stop();
                    wait4.stop();
                    isTouchingWall = true;
                }
                else {
                    if(fullSnake.getHeadCoords().getX() == apple.getX() && fullSnake.getHeadCoords().getY() == apple.getY()){
                        tempX = fullSnake.getHeadCoords().getX();
                        tempY = fullSnake.getHeadCoords().getY();
                        fullSnake.MoveUp();
                        fullSnake.elongate(tempX, tempY);
                        apple.move();
                        repaint();
                    }
                    else {
                        fullSnake.MoveUp();
                        count++;
                        repaint();
                    }
                    wait3.restart();
                }
            }
            else if(e.getSource() == wait4){
                if(fullSnake.getHeadCoords().getY() > 900){
                    wait.stop();
                    wait2.stop();
                    wait3.stop();
                    wait4.stop();
                    isTouchingWall = true;
                }
                else {
                    if(fullSnake.getHeadCoords().getX() == apple.getX() && fullSnake.getHeadCoords().getY() == apple.getY()){
                        tempX = fullSnake.getHeadCoords().getX();
                        tempY = fullSnake.getHeadCoords().getY();
                        fullSnake.MoveDown();
                        fullSnake.elongate(tempX, tempY);
                        apple.move();
                        repaint();

                    }
                    else {
                        fullSnake.MoveDown();
                        count++;
                        repaint();
                    }
                    wait4.restart();
                }
            }
        }

    }


}

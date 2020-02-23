/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SayRattana;

/**
 *
 * @author HP01
 */
public class MovableCircle implements Movable{
    int radius;
    MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed,int radius) {
        this.radius = radius;
        center = new MovablePoint(x, y, xSpeed, ySpeed);
        
       
        
    }

    @Override
    public String toString() {
        return "MovableCircle{" + 
                "center=" + center + 
                ", radius=" + radius + '}';
    }

  
    
    
  
    
    
    

    
    
    @Override
    public void moveUp() {
       
    }

    @Override
    public void moveDown() {
        
    }

    @Override
    public void moveLeft() {
        
    }

    @Override
    public void moveRight() {
    }
    
    
}

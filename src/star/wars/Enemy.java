/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package star.wars;

import java.awt.Color;

/**
 *
 * @author jword
 */
public class Enemy extends Character {
    public Enemy (){
        super();
    }
    public Enemy (int x, int y, Color color, int size, String name){
        super(x,y,color,size,name);
    }
    
    public void move() {
        int dx = (int) (Math.random()*20) - 9;
        int dy = (int) (Math.random()*20) - 9;
        super.move(dx, dy);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package star.wars;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author jword
 */
public class Space extends JPanel {

    final int marginX;
    final int marginY;
    private Hero hero;
    private Enemy enemy;
    private Timer timer;
        
    public Space() {
        super();
        marginX = 10;
        marginY = 10;
        hero = new Hero(600, 480, Color.MAGENTA, 20, "Dude");
        enemy = new Enemy(50, 50, Color.RED, 20, "Enemy");
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 100);
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
            
        g.setColor(Color.YELLOW);
        drawStars(g);
        
        hero.draw(g);
        enemy.draw(g);
        //g.dispose();     
    }
    
    private class ScheduleTask extends TimerTask {
    
        @Override
        public void run() {
            
            enemy.move();
            repaint();
        }
    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hero.move(1, 0);
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hero.move(-1,0);
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            hero.move(0,-1);
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hero.move(0,1);
        }
    }
    
    private void drawStars(Graphics g) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < 1000; i++) {
          y = (int) (Math.random()*960);
          x = (int) (Math.random()*1200);
          Color curr = g.getColor();
          if (x % 2 == 0) 
              g.setColor(curr.brighter());
          else
              g.setColor(curr.darker());
          g.fillOval(x, y, 3, 3);
          
          System.out.println(x+" "+y);
          //if ( x > 1100 || y > 860) {
           //  break;
          //}
        }
    }
}

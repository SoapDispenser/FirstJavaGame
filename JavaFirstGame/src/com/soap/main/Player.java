package com.soap.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {

	Random r = new Random();
	Handler handler;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		

		 
	}

	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 48);
		y = Game.clamp(y, 0, Game.HEIGHT - 68);
		
		collision();
	}
	
	private void collision() {
		for(int i = 0; i < handler.object.size();i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			
			if (tempObject.getID() == ID.BasicEnemy) {
				if(getBounds().intersects(tempObject.getBounds())) {
					//Collision code
					HUD.HEALTH -=2;
					
				}
				
				
			}
					
		}
		
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}
	
	public Rectangle getBounds() {
		
		
		return new Rectangle(x,y,32,32);
	}

}

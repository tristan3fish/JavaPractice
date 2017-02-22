package com.tristan3fish.holeInOne;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Ball extends Circle {
	public Vec2D vel = new Vec2D();
	private Vec2D tvec = new Vec2D();
	public boolean sunk = false;
	
	Ball(int x, int y, int diam){
		super(x, y, diam);
	}
	
	public void decel (float val) {
		if (val >= vel.mag()){
			vel.setVec(0, 0);
		} else {
			tvec.setVec(vel.dx, vel.dy); 
			tvec.unitVec(); 
			tvec.mulVec(val); 
			vel.subVec(tvec);
		}
	}
	
	public boolean touches (int mx, int my) {
		return (new Circle(mx, my, 0)).dist(this) < radius;
	}

	public void putt (Point ptr) {
		vel.setVec((x - ptr.x) / 20, (y - ptr.y) / 20);
	}
	
	public boolean moving () {
		return vel.dx != 0 || vel.dy != 0;
	}
	
	//public void draw(Graphics g){
	//	g.setColor(Color.white);
	//	g.fillOval((int) (x - radius), (int)( y - radius), diam, diam);
	//}

	public void draw (Graphics g) {
		if (!sunk){
			g.setColor(Color.darkGray);
			g.fillOval((int) (x - radius) + 2, (int) (y - radius) + 2, diam, diam);
		}
		g.setColor(sunk ? Color.lightGray : Color.white); 
		g.fillOval((int) (x - radius), (int) (y - radius), diam, diam);
	}

	public void move(Rectangle bd, float friction){
		//Increment position to get ball's new position
		addPos(vel);
		decel(friction);
		
		//Check for edge collision
		if(x < 0 && vel.dx < 0){
			vel.dx = -vel.dx;
			x += -2*x;
			decel(vel.mag()*0.6f);
		} else if(y < 0 && vel.dy < 0){
			vel.dy = -vel.dy;
			y += -2*y;
			decel(vel.mag()*0.6f);
		}
		if (x + diam > bd.width && vel.dx > 0){
			vel.dx = -vel.dx;
			x += -2 * (x + diam - bd.width);
			decel(vel.mag()*0.6f);
		} else if (y + diam > bd.height && vel.dy > 0){
			vel.dy = -vel.dy;
			y += -2 * (y + diam - bd.height);
			decel(vel.mag()*0.6f);
		}
	}
	
	public void addPos (Vec2D vel){
		x += vel.dx;
		y += vel.dy;
	}

}

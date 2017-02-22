package com.tristan3fish.javaPool;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball extends Circle {
	public Vec2D vel = new Vec2D();
	private Vec2D tvec = new Vec2D();
	private Color color;
	float hCol, vCol;
	private static final float TABLE_FRICTION = 0f;//0.004f;
	
	
	Ball(int x, int y, int diam, Color color){
		super(x, y, diam);
		this.color = color;
		this.vel.setVec(0f, 0f);
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

	public boolean moving () {
		return vel.dx != 0 || vel.dy != 0;
	}

	public void draw (Graphics g) {

		g.setColor(new Color(0,150,0));
		g.fillOval((int) (x - radius) + 2, (int) (y - radius) + 2, diam, diam);
		g.setColor(color); 
		g.fillOval((int) (x - radius), (int) (y - radius), diam, diam);
		g.setColor(new Color(255,255,255));
		g.fillOval((int) (x - radius) + 2, (int) (y - radius) + 2, 3, 3);
	}

	public void move(Rectangle bd){//, float friction){
		//Increment position to get ball's new position
		addPos(vel);
		
		decel(TABLE_FRICTION);
		
		
		//float bounceFriction = 0.18f;
		//Check for edge collision
		if(x-radius < 0 && vel.dx < 0){
			vel.dx = -vel.dx;
			x += -2*(x-radius);
		} else if(y-radius < 0 && vel.dy < 0){
			vel.dy = -vel.dy;
			y += -2*(y-radius);
		}
		if (x + radius > bd.width && vel.dx > 0){
			vel.dx = -vel.dx;
			x += -2 * (x + radius - bd.width);
		} else if (y + radius > bd.height && vel.dy > 0){
			vel.dy = -vel.dy;
			y += -2 * (y + radius - bd.height);
		}
		
	}
	
	public void addPos (Vec2D vel){
		x += vel.dx;
		y += vel.dy;
	}

	public float pathIntercept (Ball b){
		float d = radius + b.radius;
		float ddx = vel.dx - b.vel.dx;
		float ddy = vel.dy - b.vel.dy;
		float dx = x - b.x;
		float dy = y - b.y;
		float A = ddx * ddx + ddy * ddy;
		float B = 2 * (dx * ddx + dy * ddy);
		float C = dx * dx + dy * dy - d * d ;
		return (-B - (float) Math.sqrt(B*B - 4*A*C)) / (2*A);
	}
	
	/*public float pathInterceptDelta (Ball b){
		float d = radius + b.radius;
		float ddx = vel.dx - b.vel.dx;
		float ddy = vel.dy - b.vel.dy;
		float A = ddx * ddx + ddy * ddy;
		
		float dx2 = (x+vel.dx) - (b.x + b.vel.dx);
		float dy2 = (y+vel.dy) - (b.y + b.vel.dy);
		float B2 = 2 * (dx2 * ddx + dy2 * ddy);
		float C2 = dx2 * dx2 + dy2 * dy2 - d * d ;
		float t2 = (-B2 - (float) Math.sqrt(B2*B2 - 4*A*C2)) / (2*A);
		
		float dx1 = (x) - (b.x);
		float dy1 = (y) - (b.y);
		float B1 = 2 * (dx1 * ddx + dy1 * ddy);
		float C1 = dx1 * dx1 + dy1 * dy1 - d * d ;
		float t1 = (-B1 - (float) Math.sqrt(B1*B1 - 4*A*C1)) / (2*A);
		
		return t2-t1;
	}*/
	
	public void moveToTime(float t){
		x += vel.dx * t;
		y += vel.dy * t;
	}
	
	public float edgeIntercept (Rectangle bd){
		if (vel.dx >= 0){
			hCol = (bd.width + bd.x - x - radius) / vel.dx; 
		}else{
			hCol = (bd.x - x + radius) / vel.dx;
		}
		if (vel.dy >=0){
			vCol = (bd.height + bd.y - y - radius) /vel.dy;
		}else{
			vCol = (bd.y - y + radius) / vel.dy;
		}
		return Math.min(hCol, vCol);
	}
	
	/*public void bounce (float t){
		if (t == hCol)
			vel.dx = -vel.dx; 
		if (t == vCol)
			vel.dy = -vel.dy;
	}*/
	
	public void collide (Ball b) {
		// calculate collision in b s reference frame
		float mv = vel.subVec(b.vel).mag();
		Vec2D v12 = (new Vec2D(this, b)).unitVec(); 
		Vec2D vlc = vel.copy().unitVec();
		float cos = vlc.dotProd(v12);
		vel.subVec(v12.mulVec(cos * mv)).addVec(b.vel);
		b.vel.addVec(v12);
		//addPos(vlc);
	}
}

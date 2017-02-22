package com.tristan3fish.holeInOne;

import java.awt.Color;
import java.awt.Graphics;

public class Hole extends Circle {

	Vec2D tvec = new Vec2D();
	
	Hole(int x, int y, int diam) {
		super(x, y, diam);
	}
	
	public void draw (Graphics g) {
		g.setColor(Color.black);
		g.fillOval((int) (x - radius), (int) (y - radius), diam, diam);
	}
	
	public void influence(Ball ball){
		float distin = radius - ball.radius;
		
		//hole to ball distance
		float hbdist = dist(ball);
		if(distin < hbdist && hbdist < radius){
			//compute and appy centrifugal pull onto the ball
			tvec.setVec(x - ball.x, y - ball.y);
			tvec.unitVec();
			tvec.mulVec(.25f);
			ball.vel.addVec(tvec);
			ball.decel(.1f);
		}
		
		ball.sunk = (ball.vel.mag() < radius) && (hbdist < distin);
		
		if(ball.sunk && hbdist > distin){
			tvec.setVec(x - ball.x, y - ball.y);
			tvec.mulVec((hbdist - distin) / hbdist);
			ball.vel.addVec(tvec);
			
			tvec.setVec(x - ball.x, y - ball.y);
			float m2 = tvec.mag() - distin;
			tvec.unitVec();
			tvec.mulVec(m2);
			ball.addPos(tvec);
		}
	}

}

package com.tristan3fish.ponglet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {
	public float x, y, dx, dy, dt;
	
	private Color color;
	//private int size;
	public int size, radius;
	
	public Ball(float x, float y, float dx, float dy, float dt, int size, Color color) {
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.dt = dt;
		this.size = size;
		this.radius = size >> 1;
		this.color = color;
	}
	
	public void draw(Graphics g){
		g.setColor(color);
		g.fillOval((int) x - radius, (int) y - radius, size, size);
	}
	
	public void move (Rectangle bounds) {
		// Add velocity values dx/dy to position to get  ball s new position
		double vx = dx/dt;
		double vy = dy/dt;
		
		x += vx;
		y += vy;
		
		// Check for collision with left or right edge
		if (
				(x < bounds.x && vx < 0) ||
				((x + size > (bounds.x + bounds.width)) && vx > 0)
				){
			x += (dx = -dx);
		}
	}
	
}

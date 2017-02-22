package com.tristan3fish.ponglet;

import java.awt.Color;
import java.awt.Graphics;

public class VectorBall {
	private Vector x;
	//t...
	private Vector dx;
	private double dt;
	
	private Color color;
	private double diameter;
	
	public VectorBall(Vector x, Vector dx, double diameter, Color color) {
		dt = 1*(PongApplet.getFramesPerSecond()); 
		
		this.x = x;
		this.dx = dx;
		this.diameter = diameter;
		this.color = color;
	}
	
	public void draw(Graphics g){
		g.setColor(color);
		g.fillOval((int)x.get(0), (int)x.get(1), (int)diameter, (int)diameter);
	}
	
	public void move(Vector bounds) {
		for(int i = 0 ; i < bounds.getDimention(); i++){
			//Increment position to get ball's new position
			x.add(i, dx.get(i)/dt);
			
			//Check for edge collision
			if(x.get(i) < 0 && dx.get(i)/dt < 0){
				dx.multiply(i, -1);
				x.add(i, -2*x.get(i));
			} else if (x.get(i) + diameter > bounds.get(i) && dx.get(i)/dt > 0){
				dx.multiply(i, -1);
				x.add(i, -2 * (x.get(i) + diameter - bounds.get(i)));
			}
		}
	}
	
	public void push(Vector v){
		//work in progress
		x = x.addVector(v);
	}
	
	public void setVelocity(Vector dx){
		//work in progress
		this.dx = dx;
	}
	
	public Vector getVelocity(){
		return new Vector(dx);
	}
	
	public Vector getVectorMomentum(){
		return getVelocity().multiplyScalar(getMass());
	}
	
	public double getScalarMomentum(){
		return getVelocity().getMagnetude()*getMass();
	}
	
	public Vector getCenter(){
		Vector c = new Vector(x.getDimention());
		for(int i = 0 ; i < x.getDimention(); i++){
			c.set(i, x.get(i)+getRadius());
		}
		return c;	
	}
	
	public double getRadius(){
		return diameter/2;
	}
	
	public double getArea(){
		return Math.PI * Math.pow(getRadius(), 2);
	}
	
	public double getMass(){
		return getArea();
	}
	
}

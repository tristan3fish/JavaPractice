package com.tristan3fish.javaPool;



public class Circle{
	public float x, y; 
	protected float radius; 
	protected int diam;
	
	Circle (int x, int y, int diam) {
		this.x = x;
		this.y = y;
		radius = (float) (this.diam = diam) / 2;
	}
	
	protected float dist (Circle loc) {
		float xSq = loc.x - x;
		float ySq = loc.y - y;
		return (float) Math.sqrt((xSq * xSq) + (ySq * ySq));
	}

}
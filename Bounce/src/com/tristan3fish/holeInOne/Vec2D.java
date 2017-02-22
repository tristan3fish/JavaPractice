package com.tristan3fish.holeInOne;

public class Vec2D {
	public float dx, dy;
	
	public void setVec (float dx, float dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public float mag () {
		return (float) Math.sqrt(dx * dx + dy * dy);
	}
	
	public void addVec (Vec2D vec) {
		dx += vec.dx;
		dy += vec.dy;
	}
	
	public void subVec (Vec2D vec) {
		dx -= vec.dx;
		dy -= vec.dy;
	}
	
	public void unitVec () {
		float mag = mag(); 
		setVec(dx / mag, dy / mag);
	}
	
	public void mulVec (float scale) {
		setVec(dx * scale, dy * scale);
	}
}

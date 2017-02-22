package com.tristan3fish.javaPool;

public class Vec2D {
	public float dx, dy;
	
	public Vec2D(Ball a, Ball b){
		dx = (a.x+a.radius) - (b.x +b.radius);
		dy = (a.y+a.radius) - (b.y +b.radius);
	}
	
	public Vec2D() {
		// TODO Auto-generated constructor stub
	}

	public Vec2D setVec (float dx, float dy) {
		this.dx = dx;
		this.dy = dy;
		return this;
	}
	
	public float mag () {
		return (float) Math.sqrt(dx * dx + dy * dy);
	}
	
	public Vec2D addVec (Vec2D vec) {
		dx += vec.dx;
		dy += vec.dy;
		return this;
	}
	
	public Vec2D subVec (Vec2D vec) {
		dx -= vec.dx;
		dy -= vec.dy;
		return this;
	}
	
	public Vec2D copy(){
		return new Vec2D().setVec(dx, dy);
	}
	
	public Vec2D unitVec() {
		float mag = mag(); 
		setVec(dx / mag, dy / mag);
		return this;
	}
	
	public Vec2D mulVec (float scale) {
		setVec(dx * scale, dy * scale);
		return this;
	}

	public float dotProd(Vec2D v) {
		// TODO Auto-generated method stub
		return dx*v.dx + dy*v.dy;
	}
}

package com.tristan3fish.ponglet;

import java.util.Stack;

public class BallPit {
	private Stack<VectorBall> balls;
	
	public BallPit() {
		balls = new Stack<VectorBall>();
	}
	
	public void addBall(VectorBall ball){
		balls.push(ball);
	}
	
	public void collisionCheck(){
		@SuppressWarnings("unchecked")
		Stack<VectorBall> ballsTmp = (Stack<VectorBall>) balls.clone();
		while(!ballsTmp.isEmpty()){
			VectorBall b1 = ballsTmp.pop();
			for(VectorBall b2: ballsTmp){				
				Vector deltaVec = b1.getCenter().addVector(b2.getCenter().multiplyScalar(-1));
				double minCenterPointDistance = b1.getRadius() + b2.getRadius();
				double gap = deltaVec.getMagnetude() - minCenterPointDistance;
				if(gap < 0){
					//double m1 = b1.getMass();
					//double m2 = b2.getMass();
					Vector unitDelta = deltaVec.getUnitVector();
					//b1.push(unitDelta.multiplyScalar(-(m2/(m1+m2))*gap));
					//b2.push(unitDelta.multiplyScalar((m1/(m1+m2))*gap));

					Vector v1 = b1.getVelocity();
					Vector v2 = b2.getVelocity();
					double s0 = v1.addVector(v2).getMagnetude();
					//Vector velocityDelta = v1.addVector(v2.multiplyScalar(-1));
					//velocityDelta.print();
					//double m1 = b1.getScalarMomentum();
					//double m2 = b2.getScalarMomentum();
					//b1.setVelocity(unitDelta.multiplyScalar((m2/(m1+m2)) * v2.getMagnetude()));
					//b2.setVelocity(unitDelta.multiplyScalar(-1 * (m1/(m1+m2)) * v1.getMagnetude()));
					b1.setVelocity(unitDelta.multiplyScalar(v2.getMagnetude()));
					b2.setVelocity(unitDelta.multiplyScalar(-1 * v1.getMagnetude()));
					
					v1 = b1.getVelocity();
					v2 = b2.getVelocity();
					double s1 = v1.addVector(v2).getMagnetude();
					
					System.out.println("s0: " + s0 + ", s1: " + s1);
				}
			}
		}			
	}
}

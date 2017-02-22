package com.tristan3fish.ponglet;

public class Vector{
	private int dimention;
	private double[] x;
	
	public Vector(int dimention) {
		this.dimention = dimention;
		x = new double[dimention];
		
		for(int i =0;i<dimention; i++){
			x[i]=0;
		}
	}
	
	public Vector(Vector v) {
		this.dimention = v.getDimention();
		x = new double[dimention];
		
		for(int i =0;i<dimention; i++){
			x[i]=v.get(i);
		}
	}
	
	public double get(int index){
		return x[index];
	}
	
	public Vector set(int index, double value){
		x[index] = value;
		return this;
	}
	
	public Vector add(int index, double value){
		x[index] += value;
		return this;
	}
	
	public Vector multiply(int index, double value){
		x[index] *= value;
		return this;
	}
	
	public int getDimention(){
		return dimention;
	}
	
	public double getMagnetude(){
		double dsqd = 0;
		for(int i =0; i < getDimention(); i++){
			dsqd += Math.pow(get(i), 2);
		}
		return Math.pow(dsqd, .5);
	}
	
	public Vector getUnitVector(){
		return new Vector(this).multiplyScalar(1/this.getMagnetude());
	}
	
	public Vector addVector(Vector v){
		Vector result = new Vector(this);
		for(int i =0; i < result.getDimention(); i++){
			result.add(i, v.get(i));
		}
		return result;
	}
	
	public Vector multiplyScalar(double s){
		Vector result = new Vector(this);
		for(int i = 0; i < result.getDimention(); i++){
			result.multiply(i, s);
		}
		return result;
	}
	
	public double dotProduct(Vector v){
		double result = 0;
		for(int i = 0; i < v.getDimention(); i++){
			result += this.get(i) * v.get(i);
		}
		return result;
	}
	
	public void print(){
		String s = "[";
		for(int i = 0; i<dimention; i++){
			s += x[i];
			if(i!=dimention-1){
				s += ",";
			}
		}
		s+= "]";
		
		System.out.println(s);
	}
}

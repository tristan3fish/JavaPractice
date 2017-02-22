package com.tristan3fish.curves;

import java.util.HashMap;

public class Curve {
	private HashMap<Integer, Double> curveValues;
	
	public Curve() {
		curveValues = new HashMap<Integer, Double>();
	}
	
	public void setValue(int index, double value){
		curveValues.put(index, value);
	}
	
	public double getValue(int index){
		return curveValues.get(index);
	}
}

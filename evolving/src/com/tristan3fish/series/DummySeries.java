package com.tristan3fish.series;

import java.util.HashMap;

public class DummySeries implements Series {
	private HashMap<String, Integer> itemNames;
	private int[][] values;
	
	public DummySeries() {
		itemNames = new HashMap<String, Integer>();
		itemNames.put("Light", 0);
		itemNames.put("LeafSize", 1);
		
		//could convert into endless functions at some point
		values = new int[][]{
			{0,1,2,3,4, 5, 6, 7, 8, 9,10,11,12,13,14, 15, 16, 17, 18, 19, 20},
			{0,0,1,3,6,10,15,21,28,36,41,51,62,74,87,103,118,134,151,169,188}
		};
	}

	@Override
	public String[] getItemNames(){
		return (String[]) itemNames.keySet().toArray();
	}

	@Override
	public int getValue(String item, int t){
		return getValue(itemNames.get(item), t);
	}
	
	@Override
	public int getValue(int x, int t){
		return values[x][t];
	}
}

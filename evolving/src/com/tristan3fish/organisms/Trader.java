package com.tristan3fish.organisms;




import com.tristan3fish.curves.Curve;
import com.tristan3fish.series.Series;

public class Trader {
	
	private Series series;
	private TradeStrategy tradeStrategy;
	private double initialAccount;
	
	public Trader(Series s, TradeStrategy ts, double initialAccount) {
		this.series = s;
		this.tradeStrategy = ts;
		this.initialAccount = initialAccount;
	}
	
	public Curve ProfitCurve(){
		//List<Double> profitCurve = new ArrayList<Double>();
		Curve curve = new Curve();
		double total = 0;
		for(int t=0;t<19;t++){
			//total += tradeStrategy.execute(series, t);
			curve.setValue(t, total);
			//System.out.println(total);
		}
		
		return curve;
	}
	
	/*public double OpinionAt(int t){
		//need to import common appache special package and use the erf method
		return Special
	}*/
}

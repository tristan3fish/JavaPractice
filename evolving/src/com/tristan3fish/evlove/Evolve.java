package com.tristan3fish.evlove;

import com.tristan3fish.curves.Curve;
//import com.tristan3fish.organisms.DummyTradeStrategy;
import com.tristan3fish.organisms.Trader;
import com.tristan3fish.series.DummySeries;
import com.tristan3fish.series.Series;

public class Evolve {

	private Series series;
	
	public static void main(String[] args) {
		new Evolve();
	}

	public Evolve() {
		series = new DummySeries();
		//Trader trader = new Trader(series, new DummyTradeStrategy(), 1);
		
		//testTrader(trader);
	}
	
	private void testTrader(Trader t){
		Curve profitCurve = t.ProfitCurve();
		//System.out.println(profit);
	}
}

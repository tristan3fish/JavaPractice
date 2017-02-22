package com.tristan3fish.organisms;

import com.tristan3fish.series.Series;

public interface TradeStrategy {

	double[] enterTrade(Series series, int t, double allocatedFunds);
	double closeTrade(Series series, int t, double[] openPositions);
	
}

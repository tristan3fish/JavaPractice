package com.tristan3fish.organisms;

//import com.tristan3fish.series.Series;

/*
public class DummyTradeStrategy implements TradeStrategy {

	
	@Override
	public double[] enterTrade(Series series, int t, int allocatedFunds) {
		series.getValue(0, t);
		return null;
	}
	@Override
	public double closeTrade(Series series, int t, double[] openPosition) {
		// TODO Auto-generated method stub
		return 0;
	}


}
*/




/*
@Override
public double enterTrade(Series series, int t) {
	
	int patience = 2;
	int buyCost = -(series.getValue(0, t) + series.getValue(1, t));
	int sellGain = series.getValue(0, t+patience) + series.getValue(1, t+patience);
	return buyCost + sellGain;
	
	int patience = 1;
	int buyCost = -(series.getValue(0, t));
	int sellGain = series.getValue(0, t + patience);

	return buyCost + sellGain;
}
*/

//[0,-1,-1;0]
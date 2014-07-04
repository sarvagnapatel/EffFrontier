package org.gradle

class UtilityFunction {
	
	static getHoldingPeriodReturn(double startPrice, double endPrice){
		return (endPrice - startPrice)/startPrice
	}
	
	static getStDev(List<Double> returns){
		return Math.sqrt(getVar(returns))
	}
	
	static getVar(List<Double> returns){
		def mean = getArithmeticMean(returns)
		return returns.inject(0, {sum, value -> sum + (value-mean)**2 })/(returns.size() - 1)
	}
	
	static getArithmeticMean(List<Double> returns){
		return returns.sum()/returns.size()
	}
	
	static getGeoMetricMean(List<Double> returns){
		return returns.inject(1) {acc, x -> acc * (1 + x)}**(1/returns.size()) - 1
	}
	
	static getRandomWeight(int numSec, int maxWeight, int minWeight){
		Random r = new Random()
		r.nextInt(maxWeight)
	}
}

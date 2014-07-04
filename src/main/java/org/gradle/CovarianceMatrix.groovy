package org.gradle

class CovarianceMatrix {
	FinSecurity xSec
	FinSecurity ySec
	
	double value
	
	CovarianceMatrix(FinSecurity xSec, FinSecurity ySec){
		this.xSec = xSec
		this.ySec = ySec
	}
	
	void calculate()
	{
		//x.periodReturns --loop
		//y.periodReturns --loop
		
		//xi - xbar	 
		
		double xMean = xSec.meanReturn
		double yMean = ySec.meanReturn
		
		double sum = 0
		
		int maxPeriod = Math.max(xSec.periodReturns.size(), ySec.periodReturns.size())
		
		(0..maxPeriod).eachWithIndex {a,i -> sum += (x(i) - xMean) * (y(i) - yMean)}
		
		value = sum/maxPeriod
	}
	
	def x(i){
		xSec.periodReturns[i]?.pReturn?:0 //return only non null		
	}
	
	def y(i){
		ySec.periodReturns[i]?.pReturn?:0
	}

}

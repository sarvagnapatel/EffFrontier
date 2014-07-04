package org.gradle

import groovy.transform.ToString;

import org.joda.time.*

@ToString
class FinSecurity {
	
	String ticker
	
	List quotes = []
	
	List periodReturns = []
	
	double meanReturn
	
	double stdDev
	
	double geoMetricReturn
	
	double maxPeriodReturn
	
	FinSecurity(String _ticker, _maxPeriodReturn){
		ticker = _ticker
		
		maxPeriodReturn = _maxPeriodReturn
		
		//def lineNum = 0
		
		new URL("http://ichart.yahoo.com/table.csv?s=$ticker&g=m").eachLine {x, lineNum -> parseQuoteData(x, lineNum)}
		
		calcStdDev()
		
		calcGeoMetricReturn()
	}
	
	void calcGeoMetricReturn()
	{	
		geoMetricReturn = UtilityFunction.getGeoMetricMean(periodReturns.collect{x -> x.pReturn})		
	}
	
	
	def parseQuoteData(x, lineNum){
		List data = x.split(",")
		
		if(data[0].toString().toUpperCase()!="DATE" && (lineNum - 1) < maxPeriodReturn)
		{
			Quote qt = new Quote(closePrice:Double.parseDouble(data[6]), date:new LocalDate(data[0]))
			quotes << qt
			
			//println lineNum - 1
		}
	}
	
	def calcStdDev()
	{
		getMonthlyReturn()
		
		stdDev = UtilityFunction.getStDev(periodReturns.collect{x -> x.pReturn})
		
	}
	
	def getMonthlyReturn(){
		List quoteReverse = quotes.reverse()
		for(int i = 0; i < quoteReverse.size(); i++){
			if(i != 0){
				PeriodReturn pr = new PeriodReturn()
				
				pr.startDate = quoteReverse[i-1].date
				pr.endDate = quoteReverse[i].date
				pr.startPrice = quoteReverse[i-1].closePrice
				pr.endPrice = quoteReverse[i].closePrice
				
				pr.pReturn = UtilityFunction.getHoldingPeriodReturn(pr.startPrice, pr.endPrice)
				
				periodReturns << pr
				
				//println pr
			}
		}
	}
	
}

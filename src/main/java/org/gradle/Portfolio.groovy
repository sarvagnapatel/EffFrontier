package org.gradle

class Portfolio {
	
	List<PortfolioSecurity> lstSecurities 
	double stdDev
	double expRet
	double maxReturnPeriod
	
	Portfolio(List<PortfolioSecurity> lstSec, double _maxReturnPeriod){
		
		lstSecurities = new ArrayList(lstSec)
		maxReturnPeriod = _maxReturnPeriod
		
		calculateStdDev()
		calculateExpectedReturn()
	
	}
	
	void calculateExpectedReturn()
	{
		double ret = 0
		for(sec in lstSecurities){
			ret += sec.weight * sec.security.geoMetricReturn
			
		}
		
		expRet = ret
	}
	
	void calculateStdDev(){

		
		double var = 0
		double cov = 0
		
		for(lst1 in lstSecurities)	{
		
			var += (lst1.weight**2)*(lst1.security.stdDev**2)
		
			for(lst2 in lstSecurities){
				
				if(lst1.security.ticker > lst2.security.ticker){
					cov = new CovarianceMatrix(lst1.security, lst2.security).value
					var += 2*lst1.weight*lst2.weight*cov
				}
		
			}
		
		}
		stdDev = Math.sqrt(var)
	}
	
}

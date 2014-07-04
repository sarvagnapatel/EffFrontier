package org.gradle

import org.junit.Test;


class TestPortfolioStdDev {

	@Test
	void testPortfolioStdDevGivenSec()
	{
		FinSecurity fs1 = new FinSecurity("AAPL")
		FinSecurity fs2 = new FinSecurity("MSFT")
		FinSecurity fs3 = new FinSecurity("V")
		
		PortfolioSecurity ps1 = new PortfolioSecurity()
		ps1.security = fs1
		ps1.weight = 0.5
		
		PortfolioSecurity ps2 = new PortfolioSecurity()
		ps2.security = fs2
		ps2.weight = 0.3
		
		PortfolioSecurity ps3 = new PortfolioSecurity()
		ps3.security = fs3
		ps3.weight = 0.2
		
		List<PortfolioSecurity> lst = []
		
		lst << ps1
		lst << ps2
		lst << ps3
		
		Portfolio p = new Portfolio(lst)
		
		println p.stdDev
		
		println p.expRet
	}
	
	@Test
	void testGeometricReturn()
	{
		List lst = [-0.5,1]
		//def returns = lst.collect{x -> (1 + x)}
		//def geoMetricReturn = returns.inject {acc, x -> acc * x} //** (1/lst.size()) - 1
		def geoMetricReturn = lst.inject(1) {acc, x -> acc * (1 + x)} ** (1/lst.size()) - 1
		 
		def xcct = lst.head()
		for (x in lst.tail()) {
			xcct = xcct * (1 + x)
		}
		assert xcct == lst.inject {acc, x -> acc * (1 + x)}
		
		
		def acct = 1
		for (x in lst) {
			acct = acct * (1 + x)
		}
		assert acct == lst.inject(1) {acc, x -> (1 + x) * acc}
		
		println geoMetricReturn
	}
}

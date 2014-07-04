package org.gradle

import org.junit.Test;


class TestCovarianceMatrix {
	
	@Test
	void testCov()
	{
		FinSecurity fs1 = new FinSecurity("TSLA")
		
		FinSecurity fs2 = new FinSecurity("TSLA")
		
		CovarianceMatrix covMatrix = new CovarianceMatrix(fs1, fs2)
		
		covMatrix.calculate()
		
		double corr = covMatrix.value/(fs1.stdDev * fs2.stdDev)
		
		println corr
		
	}	
	
	
	@Test
	void testStdDev()
	{
		
		StdDev std1 = new StdDev([10,20,-15,10])
		
		println std1.value
		/*
		FinSecurity fs1 = new FinSecurity("AAPL")
		
		FinSecurity fs2 = new FinSecurity("FB")
		
		for(ret in fs1.periodReturns){
			//println ret.pReturn
		}
		*/
			
	}
}

//-6.457992497124588E-5
//-6.457992497124588E-5
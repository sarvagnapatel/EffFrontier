package org.gradle

import org.junit.Test;

class TestUtilityFunction {
	@Test
	void testArithmeticMean(){
		assert 3 == UtilityFunction.getArithmeticMean([4,2])
	}
	
	@Test
	void testVar(){
		println UtilityFunction.getVar([4,2,1])
	}
	
	@Test
	void testStDev(){
		println UtilityFunction.getStDev([4,2,1])
	}
	
	@Test
	void testGeoMetricMean(){
		println UtilityFunction.getGeoMetricMean([0.4,0.2,-0.1])
	}
}

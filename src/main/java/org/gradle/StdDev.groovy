package org.gradle

import java.util.List;

class StdDev
{
	List values
	
	double value 
	
	double mean
	
	StdDev(List _values){
		values = _values
		value = getStd()
	}	
	
	def getStd(){
		getMean()
		double sumNom = 0
		
		for(value in values){
			//println "$sumNom"
			sumNom +=  (value - mean)**2
		}
		
		double var = sumNom/(values.size()-1)
		
		//println Math.sqrt(var)
		return Math.sqrt(var)
	}
	
	def getMean(){
		mean = values.sum()/values.size()
		//println "Mean $mean"
	}
}

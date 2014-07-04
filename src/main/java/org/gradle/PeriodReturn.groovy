package org.gradle

import groovy.transform.ToString;

import org.joda.time.*;

@ToString
class PeriodReturn
{
	LocalDate startDate
	LocalDate endDate
	double startPrice
	double endPrice
	double pReturn
}


import java.util.List;

import groovy.transform.ToString;

import org.joda.time.*
import org.gradle.*

println 'Enter a ticker(s). When done enter exit.'

List tickers = []

List finSecurities = []

String initTicker = System.in.newReader().readLine()

while (initTicker.toUpperCase() != "EXIT")
{
	if(initTicker!="")
	{
		tickers << initTicker
		
		initTicker = System.in.newReader().readLine()
	}
}

List<PortfolioSecurity> lstSecurities = []
double weight = 1/tickers.size()

for(ticker in tickers)
{
	FinSecurity fs = new FinSecurity(ticker, 12)
	PortfolioSecurity ps = new PortfolioSecurity()
	ps.security = fs
	ps.weight = weight
	lstSecurities << ps
}

Portfolio p = new Portfolio(lstSecurities, 12)

println "Portfolio's std dev is " + p.stdDev + " and expected return " + p.expRet


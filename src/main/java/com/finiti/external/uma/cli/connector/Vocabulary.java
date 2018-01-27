package com.finiti.external.uma.cli.connector;

/**
 * Vocabulary interface
 * 
 * @author camilo
 *
 */
public interface Vocabulary {
	
	public void updateKPINames();
	
	public void updateKPINames(String company);
	
	public void updateCompanyNames();
	
	public void updateCompanyNames(String kpi);
	
	public void updateDates();
	
	public void updateDates(String kpi, String company);

}

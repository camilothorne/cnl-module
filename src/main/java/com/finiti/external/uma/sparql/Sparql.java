package com.finiti.external.uma.sparql;

import java.util.ArrayList;

/**
 * SPARQL query interface
 * 
 * @author Camilo Thorne
 *
 */
public interface Sparql {
	
	public ArrayList<String> askCompanyNames(int limit) throws Exception;
	
	public ArrayList<String> askCompanyNames(String kpi, int limit) throws Exception;
	
	public ArrayList<String> askKPINames(String company, int limit) throws Exception;
	
	public ArrayList<String> askKPINames(int limit) throws Exception;
	
	public ArrayList<String> askDates(int limit) throws Exception;
	
	public ArrayList<String> askDates(String kpi, String company, int limit) throws Exception;
	
	public String prettyPrint (String query, int limit) throws Exception;

}

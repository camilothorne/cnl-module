package com.finiti.external.uma.cli.connector;


//java
import java.util.ArrayList;
import com.finiti.external.uma.cli.connector.Vocabulary;


/**
 * Vocabulary constructor (UMa + JENA)
 * 
 * @author Camilo Thorne
 *
 */
public class VocabularyJENA implements Vocabulary{

	
	SparqlJENA mysparql; 				// triplestore (UMa - JENA/http)
	public ArrayList<String> kpis;		// KPIs
	public ArrayList<String> companies;	// companies
	public ArrayList<String> dates;		// periods
	
	
	// dataset name
	private static final String graphURI = "<http://have.a.nice.day/#wtfpl_2015-10-15>";
	// schema prefix
	private static final String prefix =  "<http://finiti.com/ontology/company/2015-10-13#>";	
	
	
	/**
	 * constructor
	 */
	public VocabularyJENA() {
		this.mysparql = new SparqlJENA();
		try {
			this.kpis = this.mysparql.askKPINames(50);
			this.companies = this.mysparql.askCompanyNames(50);
			this.dates	= this.mysparql.askDates(100);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * requery KPIs
	 */
	public void updateKPINames(){
		try {
			this.kpis = this.mysparql.askKPINames(50);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * requery companies
	 */
	public void updateCompanyNames(){
		try {
			this.kpis = this.mysparql.askCompanyNames(50);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
	
	/**
	 * requery dates
	 */
	public void updateDates(){
		try {
			this.dates = this.mysparql.askDates(50);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}		

	
	/**
	 * requery KPis by company
	 */
	public void updateKPINames(String company){
		try {
			this.kpis = this.mysparql.askKPINames(company,50);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * requery companies by KPI
	 */
	public void updateCompanyNames(String kpi){
		try {
			this.companies = this.mysparql.askCompanyNames(kpi,50);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
	
	
	/**
	 * requery dates by KPI and company
	 */
	public void updateDates(String kpi, String company){
		try {
			this.dates = this.mysparql.askDates(kpi,company,50);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
	
	
	/**
	 * print KPI names
	 * 
	 * @throws Exception
	 */
	public void printKPINames() throws Exception{
		
		String query = "PREFIX finiti: " + prefix + " "
						+ "SELECT DISTINCT ?kpi "
						+ "FROM " + graphURI + " "
						+ "WHERE "
						+ "{ "
						+ 		"?bf finiti:isInstanceOf ?k . "
						+ 		"?k finiti:name ?kpi . "
						+		"?bf  finiti:hasUnit ?u . "
						+		"?u   finiti:hasUnitMeasure ?m . "
						+		"?m   finiti:name ?kpiUnit . "
						+ 		"FILTER (?t != 'text') "						
						+ "} "
						+ "ORDER BY RAND()";
		
		System.out.println(query+"\n"); // print the query
		System.out.println(this.mysparql.prettyPrint(query,100));//ask the query
		
	}
	
	
	/**
	 * print company names
	 * 
	 * @throws Exception
	 */
	public void printCompanyNames() throws Exception{
		
		String query = "PREFIX finiti: " + prefix + " "
				+ "SELECT DISTINCT ?company "
				+ "FROM " + graphURI + " "
				+ "WHERE "
				+ "{ "
				+ 		"?c finiti:name ?company . " 
				+ "} "
				+ "ORDER BY RAND()";
		
		System.out.println(query+"\n"); // print the query
		
		System.out.println(this.mysparql.prettyPrint(query,100));//ask the query
		
	}

//	// main
//	public static void main(String[] args) {
//		
//		VocabularyLOC voc = new VocabularyLOC("localhost");
//		System.out.println(voc.kpis.get(1));
//		System.out.println(voc.companies.get(1));
//		
//	}

}



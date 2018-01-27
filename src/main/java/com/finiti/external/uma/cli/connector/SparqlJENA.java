package com.finiti.external.uma.cli.connector;


//import com.finiti.external.uma.kb.core.DataAccessException;
import com.finiti.external.uma.cli.connector.Sparql;
import com.jakewharton.fliptables.FlipTable;
import java.util.ArrayList;
import java.util.List;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;


/**
* SPARQL JENA query interface (generic)
* 
* @author Camilo Thorne
* 
*/
public class SparqlJENA implements Sparql{
		
		
	// dataset name
	private static final String graphURI = "<http://have.a.nice.day/#wtfpl_2015-10-15>";

	
	// schema prefix
	private static final String prefix =  "<http://finiti.com/ontology/company/2015-10-13#>";	
	
	
	// virtuoso URI
	private static final String virtuosoURI = "http://schiedam.informatik.uni-mannheim.de:8890/sparql";
	
	
	/**
	 * stub constructor
	 */
	public SparqlJENA(){}
	
	
	// 1. Ask company names and dates
	
	
	/**
	 * get comapny names
	 * 	
	 * @param limit
	 * @return
	 * @throws Exception
	 */
	public ArrayList<String> askCompanyNames(int limit) throws Exception{
		
		String queryString = 
				  "PREFIX finiti: " + prefix + " "
				+ "SELECT DISTINCT ?company "
				+ "FROM " + graphURI + " "
				+ "WHERE "
				+ "{ "	
				+ 		"?c finiti:name ?company . " 
				+		"?c finiti:hasBusinessFact ?bf . "
				+		"?bf finiti:isInstanceOf ?k . "
				+		"?k finiti:name ?kpi . "
				+ "} "
				+ "ORDER BY RAND()";
	    
	    return oneDQuery(queryString + " LIMIT "+limit); 
		
	}	
	
	
	/**
	 * get company naes by KPI
	 * 
	 * @param kpi
	 * @param limit
	 * @return
	 * @throws Exception
	 */
	public ArrayList<String> askCompanyNames(String kpi, int limit) throws Exception{
		
		String queryString = 
				  "PREFIX finiti: " + prefix + " "
				+ "SELECT DISTINCT ?company "
				+ "FROM " + graphURI + " "
				+ "WHERE "
				+ "{ "
				+		"?c finiti:name ?company . "
				+		"?c finiti:hasBusinessFact ?bf . "
				+		"?bf finiti:isInstanceOf ?k . "
				+		"?k finiti:name ?kpi . "
				+ 		"FILTER regex(?kpi,'.*"+ kpi.replaceAll("\\s+",".*") +".*','i')"
				+ "} "
				+ "ORDER BY RAND()";
	    
	    return oneDQuery(queryString + " LIMIT "+limit); 
		
	}
	
	
	/**
	 * get periods
	 * 
	 * @param limit
	 * @return
	 * @throws Exception
	 */
	public ArrayList<String> askDates(int limit) throws Exception{
		
		String queryString = 
				  "PREFIX finiti: " + prefix + " "
				+ "SELECT DISTINCT ?period "
				+ "FROM " + graphURI + " "
				+ "WHERE "
				+ "{ "
				+ 		"?bf finiti:isInstanceOf ?k . "
				+ 		"?k  finiti:name ?kpi . "
				+		"?bf finiti:hasUnit ?u . "
				+ 		"?bf finiti:hasReportingPeriod ?d . "
				+ 		"?d  finiti:label ?period . "
				+		"?u  finiti:hasUnitMeasure ?m . "
				+		"?m  finiti:name ?t . "
				+ 		"FILTER (?t != 'text') "
				+ "}";	
	    
	    return oneDQuery(queryString + " LIMIT "+limit); 
		
	}	
	
	
	/**
	 * get periods by KPI and company name
	 * 
	 * @param kpi
	 * @param company
	 * @param limit
	 * @return
	 * @throws Exception
	 */
	public ArrayList<String> askDates(String kpi, String company, int limit) throws Exception{
		
		String queryString = 
				  "PREFIX finiti: " + prefix + " "
				+ "SELECT DISTINCT ?period "
				+ "FROM " + graphURI + " "
				+ "WHERE "
				+ "{ "
				+		"?c   finiti:name ?cc . "
				+		"?c   finiti:hasBusinessFact ?bf . "				
				+ 		"?bf finiti:isInstanceOf ?k . "
				+ 		"?k  finiti:name ?kpi . "
				+		"?bf finiti:hasUnit ?u . "
				+ 		"?bf finiti:hasReportingPeriod ?d . "
				+ 		"?d  finiti:label ?period . "
				+		"?u  finiti:hasUnitMeasure ?m . "
				+		"?m  finiti:name ?t . "
				+ 		"FILTER (?t != 'text') "
				+		"FILTER regex(?kpi,'.*"+ kpi.replaceAll("\\s+",".*") +".*','i') "
				+ 		"FILTER regex(?cc,'.*"+ company.replaceAll("\\s+",".*") +".*','i') "				
				+ "}";	
	    
	    return oneDQuery(queryString + " LIMIT "+limit); 
		
	}	
	
	
	// 2. Ask KPI names (tokenize camel cases)	
	
	
	/**
	 * get KPI names
	 * 
	 * @param limit
	 * @return
	 * @throws Exception
	 */
	public ArrayList<String> askKPINames(int limit) throws Exception{
		
		String queryString = 
				  "PREFIX finiti: " + prefix + " "
				+ "SELECT DISTINCT ?kpi "
				+ "FROM " + graphURI + " "
				+ "WHERE "
				+ "{ "
				+ 		"?bf  finiti:isInstanceOf ?k . "
				+ 		"?k   finiti:name ?kpi . "
				+		"?bf  finiti:hasUnit ?u . "
				+		"?u   finiti:hasUnitMeasure ?m . "
				+		"?m   finiti:name ?t . "
				+ 		"FILTER (?t != 'text') "
				+ "} "
				+ "ORDER BY RAND()";	
	    
	    ArrayList<String> myres = new ArrayList<String>();
		
	    // create query
		Query query=QueryFactory.create(queryString);
		QueryExecution queryExec = QueryExecutionFactory.
				sparqlService(virtuosoURI, query);

		try {

			// execute query
			ResultSet rs = queryExec.execSelect();
			String res = rs.getResultVars().get(0);

			// collect results
		    while (rs.hasNext()){
		    	myres.add(normCCase(rs.nextSolution().getLiteral(res).toString()));
		    }

		} catch (Throwable e) {
			// throw exception
			throw new Exception(
					"Couldn't execute SPARQL query " + query.serialize(), e);
		} finally {
			// close
			queryExec.close();
		}
		
	    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
	    System.out.println(queryString);
	    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
		
	    return myres;
	    
	}	
	
	
	@Override
	public ArrayList<String> askKPINames(String company, int limit)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	// 3. Utility methods
	
	
	/**
	 * generic method for asking 1-D queries to triplestore
	 * 
	 * @param queryString
	 * @return
	 * @throws DataAccessException
	 */
	public ArrayList<String> oneDQuery(String queryString) throws Exception {
		
	    ArrayList<String> myres = new ArrayList<String>();
		
	    // create query
		Query query=QueryFactory.create(queryString);
		QueryExecution queryExec = QueryExecutionFactory.
				sparqlService(virtuosoURI, query);

		try {

			// execute query
			ResultSet rs = queryExec.execSelect();
			String res = rs.getResultVars().get(0);

			// collect results
		    while (rs.hasNext()){
		    	myres.add(rs.nextSolution().getLiteral(res).toString());
		    }

		} catch (Throwable e) {
			// throw exception
			throw new Exception(
					"Couldn't execute SPARQL query " + query.serialize(), e);
		} finally {
			// close
			queryExec.close();
		}
		

	    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
	    System.out.println(queryString);
	    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
		
	    return myres;
		
	}
	

	/**
	 * check if query is empty
	 * 
	 * @param queryString
	 * @return
	 * @throws Exception
	 */
	public boolean isEmpty (String queryString) throws Exception{
		
		// value to return
		boolean res;
		
	    // create query
		Query query=QueryFactory.create(queryString);
		QueryExecution queryExec = QueryExecutionFactory.
				sparqlService(virtuosoURI, query);

		try {

			// execute query
			ResultSet rs = queryExec.execSelect();

		    if (!rs.hasNext()){
		    	res= true;
		    }else{
		    	res= false;
		    }

		} catch (Throwable e) {
			// throw exception
			throw new Exception(
					"Couldn't execute SPARQL query " + query.serialize(), e);
		} finally {
			// close
			queryExec.close();
		}
		
	    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
	    System.out.println(queryString);
	    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");	
	    if (res==true){
	    	System.out.println("empty query!");
	    }else{
	    	System.out.println("non-empty query!");
	    }
	    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");	    
		
	    return res;
		
	}
	
	
	/**
	 * normalize (tokenize) KPI camel cases
	 * 
	 * @param camel
	 * @return
	 */
	public static String normCCase(String camel){
		
		String[] words = camel.split("(?<!^)(?=[A-Z])");
		String res = words[0];
		
		for (int i=1;i<words.length;i++){
			res = res + " " + words[i];
		}
		
		return res;
	}
	
	
	/**
	 * print 1-D result set on stout
	 * 
	 * @param array
	 */
    public static void printOneDArray(ArrayList<String> array){
	    System.out.println("-------------------------------------------------");	
    	for (String s : array){
    		System.out.println(s);
    	}
	    System.out.println("-------------------------------------------------");
    }	

    
    /**
     * pretty print n-D result set as a (string) table 
     * 
     * @param queryString
     * @param limit
     */
	public String prettyPrint (String queryString, int limit) 
			throws Exception{
		
	    ResultSet result;
	    int count;
	    ArrayList<String[]> myres;
	    String[] metadata;
	    String[][] myres2;
	    
	    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
	    System.out.println(queryString);
	    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
	    
	    // create query
		Query query=QueryFactory.create(queryString + " LIMIT "+limit);
		QueryExecution queryExec = QueryExecutionFactory.
				sparqlService(virtuosoURI, query);
		
		try {
		
			// get result set
			result = queryExec.execSelect();
		    
		    // store results
		    myres = new ArrayList<String[]>();
		    
		    // get result set metadata
		    List<String> mdata = result.getResultVars();  
		    metadata = new String[mdata.size()];
		    mdata.toArray(metadata);
		    count = mdata.size();
	    
		    // loop over result set
		    while (result.hasNext()){
		    	String[] data = new String[count];
	    		QuerySolution qs = result.next();
		    	for (int c = 0; c < count; c++){
		    		if (!qs.contains(metadata[c])){
		    			data[c] = "NaN";
		    		}
		    		else{
		    			if(metadata[c].equals("kpi")){
		    				data[c] = normCCase(qs.getLiteral(metadata[c]).toString());
		    			}else{
		    				data[c] = qs.getLiteral(metadata[c]).toString();
		    			}
		    		}
		    	}
		    	myres.add(data);
		    }
	    
		} catch (Exception e) {
			// throw exception
			throw new Exception(
					"Couldn't execute SPARQL query " + query.serialize(), e);
		} finally {
			// close
			queryExec.close();
		}
	    
	    // pretty print result set as table
	    myres2 = myres.toArray(new String[myres.size()][count]);
	    return FlipTable.of(metadata,myres2);
	    
	}
	
	
	// main class (for tests)
	public static void main(String[] args) throws Exception{
		
		SparqlJENA spar = new SparqlJENA();
		//printOneDArray(spar.askCompanyNames(100));
		
		String queryString = 
				  "PREFIX finiti: " + prefix + " "
				+ "SELECT DISTINCT ?kpi ?t "
				+ "FROM " + graphURI + " "
				+ "WHERE "
				+ "{ "
				+ 		"?bf  finiti:isInstanceOf ?k . "
				+ 		"?k   finiti:name ?kpi . "
				+		"?bf  finiti:hasUnit ?u . "
				+		"?u   finiti:hasUnitMeasure ?m . "
				+		"?m   finiti:name ?t . "
				+ 		"FILTER (?t != 'text') "
				+ "} "
				+ "ORDER BY RAND()";
		
		System.out.println(spar.prettyPrint(queryString,100));
		
	}	
	
	
}



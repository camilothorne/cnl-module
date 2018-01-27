package com.finiti.external.uma.sparql;


//import com.finiti.external.uma.kb.core.DataAccessException;
import com.finiti.external.uma.sparql.Sparql;
import com.jakewharton.fliptables.FlipTable;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.atlas.web.auth.HttpAuthenticator;
import org.apache.jena.atlas.web.auth.SimpleAuthenticator;
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
@SuppressWarnings("unused")
public class SparqlJENA{
		
		
	// dataset name
	private static final String graphURI = "<http://babelnet.org/rdf/>";

	String prefix = "";
	
	// schema prefixes
	private static final String lemmon =  "<http://www.lemon-model.net/lemon#>";	
	private static final String babelnet = "<http://babelnet.org/model/babelnet#>";
	private static final String skos = "<http://www.w3.org/2009/08/skos-reference/skos.html#>";
	private static final String lexinfo = "http://www.lexinfo.net/ontology/2.0/lexinfo#";
	private static final String rdfschema = "<http://www.w3.org/2000/01/rdf-schema#>";
	private static final String dublin_core = "http://dublincore.org/documents/2012/06/14/dcmi-terms/?v=elements#";
	private static final String dublin_terms = "http://dublincore.org/documents/2012/06/14/dcmi-terms/?v=terms#";
	
	// API key
	private static final String apikey = "51bde060-bd99-49e0-a78f-5cc4e9cd8add";
	
	// virtuoso URI
	private static final String BabelNetURI = "http://babelnet.org/sparql";
	
	
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
				  "PREFIX finiti: " + lemmon + " "
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
	public ArrayList<String> test(int limit) throws Exception{
		
		String queryString = 
				  "PREFIX lemmon: " + prefix + " "
				+ "SELECT DISTINCT ?sense ?synset WHERE {"
				+	    "?entries a lemon:LexicalEntry ."
				+	    "?entries lemon:sense ?sense ."
				+	    "?sense lemon:reference ?synset ."
				+	    "?entries rdfs:label 'home'@en .";
	    
	    ArrayList<String> myres = new ArrayList<String>();
		
	    // create query
		Query query=QueryFactory.create(queryString);
		QueryExecution queryExec = QueryExecutionFactory.
				sparqlService(BabelNetURI, query);

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
	
	
	//@Override
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
				sparqlService(BabelNetURI, query);

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
				sparqlService(BabelNetURI, query);

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
		Query query=QueryFactory.create(queryString);

		System.out.println("query parsed");
		
		HttpAuthenticator authenticator = new SimpleAuthenticator("camilothorne", apikey.toCharArray());
		
		QueryExecution queryExec = QueryExecutionFactory.
				createServiceRequest(BabelNetURI, query, authenticator);
		
		System.out.println("created request");
		
		try {
		
			// get result set
			result = queryExec.execSelect();

			System.out.println("request successful");
			
		    // store results
		    myres = new ArrayList<String[]>();
		    
		    // get result set metadata
		    List<String> mdata = result.getResultVars();  
		    metadata = new String[mdata.size()];
		    mdata.toArray(metadata);
		    count = mdata.size();
		    
		    System.out.print(count);
	    
		    // loop over result set
		    while (result.hasNext()){
		    	String[] data = new String[count];
	    		QuerySolution qs = result.next();
		    	for (int c = 0; c < count; c++){
		    		
		    		System.out.println(qs);
		    		
		    		System.out.println(qs.getResource(metadata[c]));
		    		
		    		if (!qs.contains(metadata[c])){
		    			data[c] = "NaN";
		    		}
		    		else{
		    			//if(metadata[c].equals("kpi")){
		    			//	data[c] = normCCase(qs.getLiteral(metadata[c]).toString());
		    			//}else{
		    				data[c] = qs.getResource(metadata[c]).toString();
		    			//}
		    		}
		    	}
		    	myres.add(data);
		    }
	    
		} catch (Exception e) {
			// throw exception
			throw new Exception(
					"Couldn't execute SPARQL query \n\n" + query.serialize(), e);
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
				  "PREFIX lemon: " + lemmon + " "
				+ "PREFIX rdfs: " + rdfschema + " "  
				+ "SELECT DISTINCT ?sense ?synset "
				+ "FROM " + graphURI + " "		  
				+ "WHERE "
				+ "{"
				+	    "?entries a lemon:LexicalEntry ."
				+	    "?entries lemon:sense ?sense ."
				+	    "?sense lemon:reference ?synset ."
				+	    "?entries rdfs:label 'home'@en ."
				+ "}";
		
		System.out.println(spar.prettyPrint(queryString,30));
		
	}	
	
	
}



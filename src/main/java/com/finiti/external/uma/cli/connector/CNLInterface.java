package com.finiti.external.uma.cli.connector;


// Java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;



// ANTLR 4
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;


// CNL parser and lexer


import com.finiti.external.uma.cli.antlrnew.FinCNLLexer;
import com.finiti.external.uma.cli.antlrnew.FinCNLParser;
// string sorting by length and lexicographic order 
import com.finiti.external.uma.cli.util.StringComparator;

// dynamically builds CNL vocabulary content words) from the UMa triplestore
import com.finiti.external.uma.cli.connector.VocabularyJENA;


/**
 * CNL Parsing 
 * 
 * @author Camilo Thorne
 */
public class CNLInterface {
	
	
	/**
	 * Fields
	 */
	// remote triplestore
	VocabularyJENA 		voc;	
	// content words from triplesore
	ArrayList<String> 	kpis;
	ArrayList<String> 	companies;
	ArrayList<String> 	dates;
	// fixed function words 
	ArrayList<String> 	keywords;
	ArrayList<String> 	qwords;

	
	/**
	 * constructor
	 * @param sparqlJena 
	 */
	public CNLInterface(SparqlJENA sparqlJena) {
		
        // init vocabulary   
        this.voc 			= new VocabularyJENA(); // call remote triplestore      
        this.kpis 			= this.voc.kpis;
        this.companies 		= this.voc.companies;
        this.dates			= this.voc.dates;
        
        // init question words
        this.qwords 		= new ArrayList<String>(); 
        this.qwords.add("which are the");
        this.qwords.add("what is the");        
                
        // init keywords
        this.keywords 		= new ArrayList<String>();
        this.keywords.add("in");
        this.keywords.add("of");
        this.keywords.add("between");
        this.keywords.add("and");  
		
	}

	
	/**
	 * parsing method
	 * 
	 * @param  question: 	CNL question
	 * @param  limit: 		result set limit
	 * 
	 * @return query: 		SPARQL query
	 */
	public String parseQuestion(String question, int limit){
		
	    ANTLRInputStream input = new ANTLRInputStream(question);
	    FinCNLLexer lexer = new FinCNLLexer(input);
	    lexer.removeErrorListeners();        
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	    FinCNLParser parser = new FinCNLParser(tokens);
		String query = parser.eval().value + "\nORDER BY RAND()" + "\nLIMIT " + limit;
		System.out.println("Q: " + question + "\n"); // print question (debugging)	
		System.out.println(query); // print the query (debugging)
		return query;
		
	}

	
	/**
	 * completion method
	 * 
	 * @param ui_input: 			current GUI input
	 * @param ui_suggestion_index:	index of suggestion
	 * @param list_id:				id of list (dates, keywords, qwords, KPIs, companies,
	 * @param kpi_suggestion:		current KPI selected
	 * @param comapny_suggestion:	current company selected
	 * 
	 * @return suggestions:			list of suggestions, sorted by length and alphabetic order
	 */
	public ArrayList<String> getSuggestions(String ui_input, 
			int ui_suggestion_index, String list_id, 
			String kpi_suggestion, String company_suggestion){		
		
	  	String[] values = ui_input.split(" ");
    	String value = values[values.length-1]; 
        int index = value.lastIndexOf(value);    
    	 
    	System.out.println("-------------------------------------------------");
    	System.out.println("length: " + values.length);
    	System.out.println("curr word : " + value);   	
    	System.out.println("-------------------------------------------------");        
    	
	    // Q words
	    if (values.length == 1){     	
	    	System.out.println("fire WHs");    	
	    	if(index==-1) 
	            return null;
	        final String prefix = index==value
	        		.length()-1 ? null : value.substring(index)
	        				.toLowerCase();      
	        List<String> myfilter = this.qwords.stream()
	        	    .filter(w -> prefix!=null ? w.toLowerCase().startsWith(prefix) : true)
	        	    		.collect(Collectors.toList());	        
	        if(myfilter == null){  
	            return new ArrayList<String>(); 
	        } else{ 
            	Collections.sort(myfilter);
            	Collections.sort(myfilter, new StringComparator());	        	
	        	return (ArrayList<String>) myfilter;
	        }
	       
	    }else{
	    	
	    // keywords
	    if (values.length < 4){    	
	    	System.out.println("fire keywords");    	
	    	if(index==-1) 
	            return null;
	        final String prefix = index==value
	        		.length()-1 ? null : value.substring(index)
	        				.toLowerCase();      
	        List<String> myfilter = this.keywords.stream()
	        	    .filter(w -> prefix!=null ? w.toLowerCase().startsWith(prefix) : true)
	        	    		.collect(Collectors.toList());	        
	        if(myfilter == null){  
	            return new ArrayList<String>(); 
	        } else{ 
            	Collections.sort(myfilter);
            	Collections.sort(myfilter, new StringComparator());
	        	return (ArrayList<String>) myfilter;
	        }
	           
	    }else{
		    
	    // KPIs
	    if (values[values.length-2].equals("the")){    	
	    	System.out.println("==> last word: " + values[values.length-2]); 	
	    	System.out.println("==> fire KPIs");
	    	if(index==-1) 
	            return null;
	        final String prefix = index==value
	        		.length()-1 ? null : value.substring(index)
	        				.toLowerCase();
	        List<String> myfilter = this.kpis.stream()
	        	    .filter(w -> prefix!=null ? w.toLowerCase().startsWith(prefix) : true)
	        	    		.collect(Collectors.toList());	        
	        if(myfilter == null){  
	            return new ArrayList<String>(); 
	        } else{ 
            	Collections.sort(myfilter);
            	Collections.sort(myfilter, new StringComparator());
	        	return (ArrayList<String>) myfilter;
	        }
	            
	    }else{
	    	
		    // companies
		    if (values[values.length-2].equals("of")){
		    	System.out.println("==> last word: " + values[values.length-2]); 	
		    	System.out.println("==> fire Companies");
		    	// reset KPI names
		    	this.voc.updateKPINames(); // queries triplestore
		    	this.kpis = this.voc.kpis;
		    	// filter companies by KPI
		    	this.voc.updateCompanyNames(kpi_suggestion); // queries triplestore
		    	this.companies = this.voc.companies;
		    	// create list
		    	if(index==-1) 
		            return null;
		        final String prefix = index==value
		        		.length()-1 ? null : value.substring(index)
		        				.toLowerCase();      
		        List<String> myfilter = this.companies.stream()
		        	    .filter(w -> prefix!=null ? w.toLowerCase().startsWith(prefix) : true)
		        	    		.collect(Collectors.toList());	        
		        if(myfilter == null){  
		            return new ArrayList<String>(); 
		        } else{ 
	            	Collections.sort(myfilter);
	            	Collections.sort(myfilter, new StringComparator());
		        	return (ArrayList<String>) myfilter;
		        }
		    		        
		}else{
		    			
		    // dates
		    if (values[values.length-2].equals("in") || values[values.length-2].equals("between") 
		    		|| values[values.length-2].equals("and")){
		    		
		    	System.out.println("==> last word: " + values[values.length-2]); 
		    	System.out.println("==> fire Dates");	 
		    	// reset companies
		    	this.voc.updateCompanyNames(); // queries triplestore
		    	this.companies = this.voc.companies;
		    	// filter dates by KPI and company
		    	this.voc.updateDates(kpi_suggestion,company_suggestion); // queries triplestore
		    	this.dates = this.voc.dates;		    	
		    	// create list
		    	if(index==-1) 
		            return null;
		        final String prefix = index==value
		        		.length()-1 ? null : value.substring(index)
		        				.toLowerCase();      
		        List<String> myfilter = this.dates.stream()
		        	    .filter(w -> prefix!=null ? w.toLowerCase().startsWith(prefix) : true)
		        	    		.collect(Collectors.toList());	        
		        if(myfilter == null){  
		            return new ArrayList<String>(); 
		        } else{ 
	            	Collections.sort(myfilter);
	            	Collections.sort(myfilter, new StringComparator());
		        	return (ArrayList<String>) myfilter;
		        } 
					        
		    }else{
		    		    	
			    // keywords again
		    	System.out.println("==> finishing question?");
		    	// create list
		    	if(index==-1) 
		            return null;
		        final String prefix = index==value
		        		.length()-1 ? null : value.substring(index)
		        				.toLowerCase();      
		        List<String> myfilter = this.keywords.stream()
		        	    .filter(w -> prefix!=null ? w.toLowerCase().startsWith(prefix) : true)
		        	    		.collect(Collectors.toList());	        
		        if(myfilter == null){  
		            return new ArrayList<String>(); 
		        } else{ 
	            	Collections.sort(myfilter);
	            	Collections.sort(myfilter, new StringComparator());
		        	return (ArrayList<String>) myfilter;
		        } 
		    		
		    }}}}
	    }
		
	}
	
	
    /**
     * print list of suggestions on stout for
     * debugging purposes
     * 
     * @param array
     */
    protected void printOneDArray(ArrayList<String> array){
    	for (String s : array){
    		System.out.println(s);
    	}
    }	
	
	
}

package com.finiti.external.uma.cli.antlr;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import com.finiti.external.uma.cli.connector.Sparql;
import com.finiti.external.uma.cli.connector.SparqlJENA;
import com.finiti.external.uma.cli.antlrnew.FinCNLLexer;
import com.finiti.external.uma.cli.antlrnew.FinCNLParser;


/**
 * 
 * Unit test for CNL parser
 * parses and evaluates a CNL question
 * 
 */
public class CNLTestA extends TestCase {
	
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */	
	public CNLTestA(String name) {
		super(name);
	}

	
    /**
     * @return the suite of tests being tested
     */
    public static Test suite(){
        return new TestSuite( CNLTestA.class );
    }	
    
    
    /**
     * Test - question 1
     */ 
	public void testParser1() throws Exception {
		
		ANTLRInputStream input;
		FinCNLLexer lexer;
		FinCNLParser parser;
		CommonTokenStream tokens;   
		SparqlJENA sparql = new SparqlJENA();
		String queryString;
		
		input = new ANTLRInputStream("what is the Oil and Gas Sales Revenue of Bonanza Creek Energy, Inc. in Year 2014?");		
		lexer = new FinCNLLexer(input);
		lexer.removeErrorListeners();
		tokens = new CommonTokenStream(lexer);
		parser = new FinCNLParser(tokens);
		
		assertEquals(0,parser.getNumberOfSyntaxErrors());
		
		System.out.println("Q: what is the Oil and Gas Sales Revenue of Bonanza Creek Energy, Inc. in Year 2014?\n");			
		queryString = parser.eval().value;
		System.out.println(queryString); // print the query
		
		assertEquals(false,sparql.isEmpty(queryString));
		
		System.out.println(sparql.prettyPrint(queryString,100));//ask the query
 		
	}
	
	
    /**
     * Test - question 2
     */ 	
	public void testParser2() throws Exception {
		
		ANTLRInputStream input;
		FinCNLLexer lexer;
		FinCNLParser parser;
		CommonTokenStream tokens;   
		Sparql sparql = new SparqlJENA();
		String query;
		
		input = new ANTLRInputStream("what is the Accretion of Discount of Bonanza Creek Energy, Inc. in Year 2013?");		
		lexer = new FinCNLLexer(input);
		lexer.removeErrorListeners();
		tokens = new CommonTokenStream(lexer);
		parser = new FinCNLParser(tokens);
		
		assertEquals(0,parser.getNumberOfSyntaxErrors());
		
		System.out.println("Q: what is the Accretion of Discount of Bonanza Creek Energy, Inc. in Year 2013?\n");
		query = parser.eval().value;
		System.out.println(query); // print the query
		System.out.println(sparql.prettyPrint(query,100));//ask the query
		
	}
	
	
    /**
     * Test - question 3
     */ 
	public void testParser3() throws Exception {
		
		ANTLRInputStream input;
		FinCNLLexer lexer;
		FinCNLParser parser;
		CommonTokenStream tokens;   
		Sparql sparql = new SparqlJENA();
		String query;
			
		input = new ANTLRInputStream("which is the revenue of bonanza between 2011 and 2014?");
		lexer = new FinCNLLexer(input);
		lexer.removeErrorListeners();
		tokens = new CommonTokenStream(lexer);
		parser = new FinCNLParser(tokens);
		
		assertEquals(0,parser.getNumberOfSyntaxErrors());
		
		System.out.println("Q: which is the revenue of bonanza between 2011 and 2015?\n");
		query = parser.eval().value;
		System.out.println(query); // print the query
		System.out.println(sparql.prettyPrint(query,100));//ask the query
		
		
	}
	

//    /**
//     * Test - question 4
//     */ 
//	public void testParser4() throws Exception {
//		
//		ANTLRInputStream input;
//		FinCNLLexer lexer;
//		FinCNLParser parser;
//		CommonTokenStream tokens;   
//		Sparql sparql = new SparqlJENA();
//		String query;
//			
//		input = new ANTLRInputStream("which is the revenue and sales of bonanza creek in 2014?");		
//		lexer = new FinCNLLexer(input);
//		lexer.removeErrorListeners();
//		tokens = new CommonTokenStream(lexer);
//		parser = new FinCNLParser(tokens);
//		
//		assertEquals(0,parser.getNumberOfSyntaxErrors());
//		
//		System.out.println("Q: which is the revenue and sales of bonanza in 2014?\n");		
//		query = parser.eval().value;
//		System.out.println(query); // print the query
//		System.out.println(sparql.prettyPrint(query,100));//ask the query
//		
//	}
//	
//
//	
//    /**
//     * Test - question 5
//     */ 
//	public void testParser5() throws Exception {
//		
//		ANTLRInputStream input;
//		FinCNLLexer lexer;
//		FinCNLParser parser;
//		CommonTokenStream tokens;   
//		Sparql sparql = new SparqlJENA();
//		String query;
//			
//		input = new ANTLRInputStream("which is the revenue of bonanza creek in Q1 2014?");		
//		lexer = new FinCNLLexer(input);
//		lexer.removeErrorListeners();
//		tokens = new CommonTokenStream(lexer);
//		parser = new FinCNLParser(tokens);
//		
//		assertEquals(0,parser.getNumberOfSyntaxErrors());
//		
//		System.out.println("Q: which is the revenue of bonanza creek in Q1 2014?\n");		
//		query = parser.eval().value;
//		System.out.println(query); // print the query
//		System.out.println(sparql.prettyPrint(query,100));//ask the query
//		
//	}
//	
//	
//    /**
//     * Test - question 6
//     */ 
//	public void testParser6() throws Exception {
//		
//		ANTLRInputStream input;
//		FinCNLLexer lexer;
//		FinCNLParser parser;
//		CommonTokenStream tokens;   
//		Sparql sparql = new SparqlJENA();
//		String query;
//			
//		input = new ANTLRInputStream("which is the revenue of bonanza creek between Q1 2013 and Q4 2013?");		
//		lexer = new FinCNLLexer(input);
//		lexer.removeErrorListeners();
//		tokens = new CommonTokenStream(lexer);
//		parser = new FinCNLParser(tokens);
//		
//		assertEquals(0,parser.getNumberOfSyntaxErrors());
//		
//		System.out.println("Q: which is the revenue of bonanza creek between Q1 2013 and Q4 2013?\n");		
//		query = parser.eval().value;
//		System.out.println(query); // print the query
//		System.out.println(sparql.prettyPrint(query,100));//ask the query
//		
//	}	
//	
//	
//    /**
//     * Test - question 7
//     */ 
//	public void testParser7() throws Exception {
//		
//		ANTLRInputStream input;
//		FinCNLLexer lexer;
//		FinCNLParser parser;
//		CommonTokenStream tokens;   
//		Sparql sparql = new SparqlJENA();
//		String query;
//			
//		input = new ANTLRInputStream("which is the revenue of bonanza creek between Q1 2013 and Q3 2015?");		
//		lexer = new FinCNLLexer(input);
//		lexer.removeErrorListeners();
//		tokens = new CommonTokenStream(lexer);
//		parser = new FinCNLParser(tokens);
//		
//		assertEquals(0,parser.getNumberOfSyntaxErrors());
//		
//		System.out.println("Q: which is the revenue of bonanza creek between Q1 2013 and Q3 2015?\n");		
//		query = parser.eval().value;
//		System.out.println(query); // print the query
//		System.out.println(sparql.prettyPrint(query,100));//ask the query
//		
//	}		
//	
//	
//    /**
//     * Test - question 8
//     */ 
//	public void testParser8() throws Exception {
//		
//		ANTLRInputStream input;
//		FinCNLLexer lexer;
//		FinCNLParser parser;
//		CommonTokenStream tokens;   
//		Sparql sparql = new SparqlJENA();
//		String query;
//			
//		input = new ANTLRInputStream("what is the revenue of bonanza creek in each Q1?");		
//		lexer = new FinCNLLexer(input);
//		lexer.removeErrorListeners();
//		tokens = new CommonTokenStream(lexer);
//		parser = new FinCNLParser(tokens);
//		
//		assertEquals(0,parser.getNumberOfSyntaxErrors());
//		
//		System.out.println("Q: what is the revenue of bonanza creek in each Q1?\n");		
//		query = parser.eval().value;
//		System.out.println(query); // print the query
//		System.out.println(sparql.prettyPrint(query,100));//ask the query
//		
//	}	

	
}



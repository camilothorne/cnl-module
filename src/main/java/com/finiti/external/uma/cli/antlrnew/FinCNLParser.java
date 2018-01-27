// Generated from FinCNL.g4 by ANTLR 4.5.1
package com.finiti.external.uma.cli.antlrnew;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FinCNLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, WH=14, DATE=15, DUR=16, COP=17, 
		CHAR=18;
	public static final int
		RULE_eval = 0, RULE_cnlQuery = 1, RULE_nPhrase = 2, RULE_pPhrase = 3, 
		RULE_eNT = 4, RULE_kPI = 5, RULE_aTOM = 6;
	public static final String[] ruleNames = {
		"eval", "cnlQuery", "nPhrase", "pPhrase", "eNT", "kPI", "aTOM"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'?'", "'the'", "'of'", "'in'", "'in each'", "'between'", "'and'", 
		"'or'", "'by'", "'from'", "'for'", "'to'", "'on'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "WH", "DATE", "DUR", "COP", "CHAR"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "FinCNL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }




	/* graph URI */
	final String graphURI = "<http://have.a.nice.day/#wtfpl_2015-10-15>";


	/* FINITI prefix */
	final String prefix 	= "<http://finiti.com/ontology/company/2015-10-13#>";



	public FinCNLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class EvalContext extends ParserRuleContext {
		public String value;
		public CnlQueryContext query;
		public TerminalNode WH() { return getToken(FinCNLParser.WH, 0); }
		public CnlQueryContext cnlQuery() {
			return getRuleContext(CnlQueryContext.class,0);
		}
		public EvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FinCNLListener ) ((FinCNLListener)listener).enterEval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FinCNLListener ) ((FinCNLListener)listener).exitEval(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FinCNLVisitor ) return ((FinCNLVisitor<? extends T>)visitor).visitEval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EvalContext eval() throws RecognitionException {
		EvalContext _localctx = new EvalContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_eval);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			match(WH);
			setState(15);
			((EvalContext)_localctx).query = cnlQuery();
			setState(16);
			match(T__0);

			    			((EvalContext)_localctx).value = 	"PREFIX finiti: " + prefix + "\n" 
			    						+ 	"SELECT DISTINCT\n" + ((EvalContext)_localctx).query.value;
			    		
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CnlQueryContext extends ParserRuleContext {
		public String value;
		public NPhraseContext np;
		public TerminalNode COP() { return getToken(FinCNLParser.COP, 0); }
		public NPhraseContext nPhrase() {
			return getRuleContext(NPhraseContext.class,0);
		}
		public CnlQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cnlQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FinCNLListener ) ((FinCNLListener)listener).enterCnlQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FinCNLListener ) ((FinCNLListener)listener).exitCnlQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FinCNLVisitor ) return ((FinCNLVisitor<? extends T>)visitor).visitCnlQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CnlQueryContext cnlQuery() throws RecognitionException {
		CnlQueryContext _localctx = new CnlQueryContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_cnlQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			match(COP);
			setState(20);
			((CnlQueryContext)_localctx).np = nPhrase();

			    			((CnlQueryContext)_localctx).value =   	"\t?company ?kpi ?value ?unit ?dimension ?period" 
			    				 	+	"\nFROM\n" 		+ "\t" + graphURI 
			    				 	+   "\nWHERE\n" 	+ "{\n"
			    				 	+	((CnlQueryContext)_localctx).np.value 		+ "}\n"
			    				 	+ 	"ORDER BY desc(?period) \n" ;
			    		
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NPhraseContext extends ParserRuleContext {
		public String value;
		public KPIContext kpi;
		public ENTContext entity;
		public PPhraseContext time;
		public KPIContext kPI() {
			return getRuleContext(KPIContext.class,0);
		}
		public ENTContext eNT() {
			return getRuleContext(ENTContext.class,0);
		}
		public PPhraseContext pPhrase() {
			return getRuleContext(PPhraseContext.class,0);
		}
		public NPhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nPhrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FinCNLListener ) ((FinCNLListener)listener).enterNPhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FinCNLListener ) ((FinCNLListener)listener).exitNPhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FinCNLVisitor ) return ((FinCNLVisitor<? extends T>)visitor).visitNPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NPhraseContext nPhrase() throws RecognitionException {
		NPhraseContext _localctx = new NPhraseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_nPhrase);
		try {
			setState(36);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(23);
				match(T__1);
				setState(24);
				((NPhraseContext)_localctx).kpi = kPI();
				setState(25);
				match(T__2);
				setState(26);
				((NPhraseContext)_localctx).entity = eNT();

				    			((NPhraseContext)_localctx).value =   "\t?c finiti:name ?company . 	\n"
								+ "\t?c finiti:hasBusinessFact ?bf . 	\n"
								+ "\t?bf finiti:value ?value . 			\n"
								+ "\t?bf finiti:isInstanceOf ?k . 		\n"
								+ "\t?k finiti:name ?kpi . 				\n"
								+ "\t?bf finiti:hasReportingPeriod ?d . \n"
								+ "\t?bf finiti:hasLabel ?lbl . \n"
								+ "\t?lbl finiti:type 'http://www.xbrl.org/2003/role/label' . \n"
								+ "\t?lbl finiti:text ?label . \n"
								+ "\tOPTIONAL { ?d finiti:label ?period } 		\n"
								+ "\tOPTIONAL { ?bf finiti:hasSegment ?seg . 	\n"
								+ "\t?seg finiti:dimension ?dimension } 		\n"
								+ "\t?bf  finiti:hasUnit ?u . 			\n"
								+ "\t?u   finiti:hasUnitMeasure ?m . 	\n"
								+ "\t?m   finiti:name ?unit . 			\n"
								+ "\tFILTER regex(?company, '" 	+ ".*" + ((NPhraseContext)_localctx).entity.value 	+ ".*" + "', 'i') \n"
								+ "\tFILTER regex(?label, '" 		+ ".*" + ((NPhraseContext)_localctx).kpi.value 	+ ".*" + "', 'i') \n" ;
							
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(29);
				match(T__1);
				setState(30);
				((NPhraseContext)_localctx).kpi = kPI();
				setState(31);
				match(T__2);
				setState(32);
				((NPhraseContext)_localctx).entity = eNT();
				setState(33);
				((NPhraseContext)_localctx).time = pPhrase();

				    			((NPhraseContext)_localctx).value =  "\t?c finiti:name ?company . 	\n"
								+ "\t?c finiti:hasBusinessFact ?bf . 	\n"
								+ "\t?bf finiti:value ?value . 			\n"
								+ "\t?bf finiti:isInstanceOf ?k . 		\n"
								+ "\t?k finiti:name ?kpi . 				\n"
								+ "\t?bf finiti:hasReportingPeriod ?d . \n"
								+ "\t?bf finiti:hasLabel ?lbl .\n"
								+ "\t?lbl finiti:type 'http://www.xbrl.org/2003/role/label' .\n"
								+ "\t?lbl finiti:text ?label . \n"
								+ "\tOPTIONAL { ?d finiti:label ?period } 		\n"
								+ "\tOPTIONAL { ?bf finiti:hasSegment ?seg . 	\n"
								+ "\t?seg finiti:dimension ?dimension } 		\n"
								+ "\t?bf  finiti:hasUnit ?u . 			\n"
								+ "\t?u   finiti:hasUnitMeasure ?m . 	\n"
								+ "\t?m   finiti:name ?unit . 			\n"
								+ "\tFILTER regex(?company, '" 	+ ".*" + ((NPhraseContext)_localctx).entity.value 	+ ".*" + "', 'i') \n"
								+ "\tFILTER regex(?label, '" 		+ ".*" + ((NPhraseContext)_localctx).kpi.value 	+ ".*" + "', 'i') \n" 
																+ ((NPhraseContext)_localctx).time.value;								
							
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PPhraseContext extends ParserRuleContext {
		public String value;
		public Token year;
		public Token q;
		public Token year1;
		public Token year2;
		public Token q1;
		public Token q2;
		public List<TerminalNode> DATE() { return getTokens(FinCNLParser.DATE); }
		public TerminalNode DATE(int i) {
			return getToken(FinCNLParser.DATE, i);
		}
		public List<TerminalNode> DUR() { return getTokens(FinCNLParser.DUR); }
		public TerminalNode DUR(int i) {
			return getToken(FinCNLParser.DUR, i);
		}
		public PPhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pPhrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FinCNLListener ) ((FinCNLListener)listener).enterPPhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FinCNLListener ) ((FinCNLListener)listener).exitPPhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FinCNLVisitor ) return ((FinCNLVisitor<? extends T>)visitor).visitPPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PPhraseContext pPhrase() throws RecognitionException {
		PPhraseContext _localctx = new PPhraseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pPhrase);
		try {
			setState(60);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				match(T__3);
				setState(39);
				((PPhraseContext)_localctx).year = match(DATE);
				((PPhraseContext)_localctx).value =  	"\tFILTER regex(?period, '.*" 	+ (((PPhraseContext)_localctx).year!=null?((PPhraseContext)_localctx).year.getText():null) 	+ ".*', 'i')\n" ;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				match(T__3);
				setState(42);
				((PPhraseContext)_localctx).q = match(DUR);
				setState(43);
				((PPhraseContext)_localctx).year = match(DATE);
				((PPhraseContext)_localctx).value =  	"\tFILTER regex(?period, '.*" 	+ (((PPhraseContext)_localctx).q!=null?((PPhraseContext)_localctx).q.getText():null) + " " + (((PPhraseContext)_localctx).year!=null?((PPhraseContext)_localctx).year.getText():null) 	+ ".*', 'i')\n" ;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(45);
				match(T__4);
				setState(46);
				((PPhraseContext)_localctx).q = match(DUR);
				((PPhraseContext)_localctx).value =  	"\tFILTER regex(?period, '.*" 	+ (((PPhraseContext)_localctx).q!=null?((PPhraseContext)_localctx).q.getText():null) + ".*', 'i')\n" ;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(48);
				match(T__5);
				setState(49);
				((PPhraseContext)_localctx).year1 = match(DATE);
				setState(50);
				match(T__6);
				setState(51);
				((PPhraseContext)_localctx).year2 = match(DATE);

								
								Integer ini		= Integer.parseInt((((PPhraseContext)_localctx).year1!=null?((PPhraseContext)_localctx).year1.getText():null));
								Integer end		= Integer.parseInt((((PPhraseContext)_localctx).year2!=null?((PPhraseContext)_localctx).year2.getText():null));
								Integer	off		= end - ini;

								String mid		= "|";
								for (Integer i=1; i<=off; i++){
									if(ini < end-1){
										ini = ini + 1;
										mid = mid + ini + "|";
									}
								}
								
								String regex 	= (((PPhraseContext)_localctx).year1!=null?((PPhraseContext)_localctx).year1.getText():null) + mid + (((PPhraseContext)_localctx).year2!=null?((PPhraseContext)_localctx).year2.getText():null);
								
								((PPhraseContext)_localctx).value =  	"\tFILTER regex(?period, '.*("  + regex + ").*', 'i')\n";
								
							
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(53);
				match(T__5);
				setState(54);
				((PPhraseContext)_localctx).q1 = match(DUR);
				setState(55);
				((PPhraseContext)_localctx).year1 = match(DATE);
				setState(56);
				match(T__6);
				setState(57);
				((PPhraseContext)_localctx).q2 = match(DUR);
				setState(58);
				((PPhraseContext)_localctx).year2 = match(DATE);

								
								Integer ini		= Integer.parseInt((((PPhraseContext)_localctx).year1!=null?((PPhraseContext)_localctx).year1.getText():null));
								Integer end		= Integer.parseInt((((PPhraseContext)_localctx).year2!=null?((PPhraseContext)_localctx).year2.getText():null));
								
								String Q1		= Character.toString((((PPhraseContext)_localctx).q1!=null?((PPhraseContext)_localctx).q1.getText():null).charAt(1));
								String Q2		= Character.toString((((PPhraseContext)_localctx).q2!=null?((PPhraseContext)_localctx).q2.getText():null).charAt(1));
								
								Integer q1		= Integer.parseInt(Q1);
								Integer	q2		= Integer.parseInt(Q2);
								
								Integer	yoff	= end - ini;
								Integer qoff1	= 4 - q1;
								Integer qoff2	= q2;
								Integer diff	= q2 - q1;
								
								String regex 	= "";
								
								if (ini < end){
								
									String start	= (((PPhraseContext)_localctx).q1!=null?((PPhraseContext)_localctx).q1.getText():null) + " " + (((PPhraseContext)_localctx).year1!=null?((PPhraseContext)_localctx).year1.getText():null);
									String mid1		= "";
									for (Integer i=1; i<=qoff1; i++){
											q1 = q1 + 1;
											mid1 = mid1 + "|" + "Q" + q1 + " " + (((PPhraseContext)_localctx).year1!=null?((PPhraseContext)_localctx).year1.getText():null);
									}
									start = start + mid1;				
									
									String send		= (((PPhraseContext)_localctx).q2!=null?((PPhraseContext)_localctx).q2.getText():null) + " " + (((PPhraseContext)_localctx).year2!=null?((PPhraseContext)_localctx).year2.getText():null);
									String mid2		= "";
									for (Integer i=qoff2; i>1; i--){
											q2 = q2 - 1;
											mid2 = mid2 + "|" + "Q" + q2 + " " + (((PPhraseContext)_localctx).year2!=null?((PPhraseContext)_localctx).year2.getText():null);
									}
									send = send + mid2;				
									
									String mid3		= "";
									
									for (Integer i=1; i<=yoff; i++){
										if(ini < end-1){
											ini = ini + 1;
											for (Integer j=1;j<=4;j++)
											mid3 = mid3 + "|" + "Q" + j + " " + ini;
										}
									}			
									
									regex = regex + start + mid3 + "|" + send;
								
								}else{
									
									String start	= (((PPhraseContext)_localctx).q1!=null?((PPhraseContext)_localctx).q1.getText():null) + " " + (((PPhraseContext)_localctx).year1!=null?((PPhraseContext)_localctx).year1.getText():null);
									String mid1		= "";
									for (Integer i=1; i<=qoff1; i++){
											q1 = q1 + 1;
											mid1 = mid1 + "|" + "Q" + q1 + " " + (((PPhraseContext)_localctx).year1!=null?((PPhraseContext)_localctx).year1.getText():null);
									}
									
									regex = regex + start + mid1;
									
								}
								
								((PPhraseContext)_localctx).value =  	"\tFILTER regex(?period, '.*("  + regex + ").*', 'i')\n";
									
							
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ENTContext extends ParserRuleContext {
		public String value;
		public ATOMContext en1;
		public ENTContext en2;
		public ATOMContext aTOM() {
			return getRuleContext(ATOMContext.class,0);
		}
		public ENTContext eNT() {
			return getRuleContext(ENTContext.class,0);
		}
		public ENTContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eNT; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FinCNLListener ) ((FinCNLListener)listener).enterENT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FinCNLListener ) ((FinCNLListener)listener).exitENT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FinCNLVisitor ) return ((FinCNLVisitor<? extends T>)visitor).visitENT(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ENTContext eNT() throws RecognitionException {
		ENTContext _localctx = new ENTContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_eNT);
		try {
			setState(69);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				((ENTContext)_localctx).en1 = aTOM();
				((ENTContext)_localctx).value =  ((ENTContext)_localctx).en1.value;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				((ENTContext)_localctx).en1 = aTOM();
				setState(66);
				((ENTContext)_localctx).en2 = eNT();
				((ENTContext)_localctx).value =  ((ENTContext)_localctx).en1.value + ".*" + ((ENTContext)_localctx).en2.value;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KPIContext extends ParserRuleContext {
		public String value;
		public ATOMContext mod;
		public KPIContext kpi;
		public ATOMContext aTOM() {
			return getRuleContext(ATOMContext.class,0);
		}
		public KPIContext kPI() {
			return getRuleContext(KPIContext.class,0);
		}
		public KPIContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kPI; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FinCNLListener ) ((FinCNLListener)listener).enterKPI(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FinCNLListener ) ((FinCNLListener)listener).exitKPI(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FinCNLVisitor ) return ((FinCNLVisitor<? extends T>)visitor).visitKPI(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KPIContext kPI() throws RecognitionException {
		KPIContext _localctx = new KPIContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_kPI);
		try {
			setState(123);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				((KPIContext)_localctx).mod = aTOM();
				((KPIContext)_localctx).value =  ((KPIContext)_localctx).mod.value;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				((KPIContext)_localctx).mod = aTOM();
				setState(75);
				((KPIContext)_localctx).kpi = kPI();
				((KPIContext)_localctx).value =  ((KPIContext)_localctx).mod.value + ".*" + ((KPIContext)_localctx).kpi.value;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				((KPIContext)_localctx).mod = aTOM();
				setState(79);
				match(T__6);
				setState(80);
				((KPIContext)_localctx).kpi = kPI();
				((KPIContext)_localctx).value =  ((KPIContext)_localctx).mod.value + ".*and.*" + ((KPIContext)_localctx).kpi.value;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(83);
				((KPIContext)_localctx).mod = aTOM();
				setState(84);
				match(T__7);
				setState(85);
				((KPIContext)_localctx).kpi = kPI();
				((KPIContext)_localctx).value =  ((KPIContext)_localctx).mod.value + ".*or.*" + ((KPIContext)_localctx).kpi.value;
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(88);
				((KPIContext)_localctx).mod = aTOM();
				setState(89);
				match(T__2);
				setState(90);
				((KPIContext)_localctx).kpi = kPI();
				((KPIContext)_localctx).value =  ((KPIContext)_localctx).mod.value + ".*of.*" + ((KPIContext)_localctx).kpi.value;
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(93);
				((KPIContext)_localctx).mod = aTOM();
				setState(94);
				match(T__8);
				setState(95);
				((KPIContext)_localctx).kpi = kPI();
				((KPIContext)_localctx).value =  ((KPIContext)_localctx).mod.value + ".*by.*" + ((KPIContext)_localctx).kpi.value;
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(98);
				((KPIContext)_localctx).mod = aTOM();
				setState(99);
				match(T__9);
				setState(100);
				((KPIContext)_localctx).kpi = kPI();
				((KPIContext)_localctx).value =  ((KPIContext)_localctx).mod.value + ".*from.*" + ((KPIContext)_localctx).kpi.value;
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(103);
				((KPIContext)_localctx).mod = aTOM();
				setState(104);
				match(T__10);
				setState(105);
				((KPIContext)_localctx).kpi = kPI();
				((KPIContext)_localctx).value =  ((KPIContext)_localctx).mod.value + ".*for.*" + ((KPIContext)_localctx).kpi.value;
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(108);
				((KPIContext)_localctx).mod = aTOM();
				setState(109);
				match(T__3);
				setState(110);
				((KPIContext)_localctx).kpi = kPI();
				((KPIContext)_localctx).value =  ((KPIContext)_localctx).mod.value + ".*in.*" + ((KPIContext)_localctx).kpi.value;
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(113);
				((KPIContext)_localctx).mod = aTOM();
				setState(114);
				match(T__11);
				setState(115);
				((KPIContext)_localctx).kpi = kPI();
				((KPIContext)_localctx).value =  ((KPIContext)_localctx).mod.value + ".*to.*" + ((KPIContext)_localctx).kpi.value;
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(118);
				((KPIContext)_localctx).mod = aTOM();
				setState(119);
				match(T__12);
				setState(120);
				((KPIContext)_localctx).kpi = kPI();
				((KPIContext)_localctx).value =  ((KPIContext)_localctx).mod.value + ".*on.*" + ((KPIContext)_localctx).kpi.value;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ATOMContext extends ParserRuleContext {
		public String value;
		public Token atom;
		public TerminalNode CHAR() { return getToken(FinCNLParser.CHAR, 0); }
		public ATOMContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aTOM; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FinCNLListener ) ((FinCNLListener)listener).enterATOM(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FinCNLListener ) ((FinCNLListener)listener).exitATOM(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FinCNLVisitor ) return ((FinCNLVisitor<? extends T>)visitor).visitATOM(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ATOMContext aTOM() throws RecognitionException {
		ATOMContext _localctx = new ATOMContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_aTOM);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			((ATOMContext)_localctx).atom = match(CHAR);
			((ATOMContext)_localctx).value =  (((ATOMContext)_localctx).atom!=null?((ATOMContext)_localctx).atom.getText():null);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\24\u0083\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
		"\'\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\5\5?\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6H\n\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5"+
		"\7~\n\7\3\b\3\b\3\b\3\b\2\2\t\2\4\6\b\n\f\16\2\2\u008b\2\20\3\2\2\2\4"+
		"\25\3\2\2\2\6&\3\2\2\2\b>\3\2\2\2\nG\3\2\2\2\f}\3\2\2\2\16\177\3\2\2\2"+
		"\20\21\7\20\2\2\21\22\5\4\3\2\22\23\7\3\2\2\23\24\b\2\1\2\24\3\3\2\2\2"+
		"\25\26\7\23\2\2\26\27\5\6\4\2\27\30\b\3\1\2\30\5\3\2\2\2\31\32\7\4\2\2"+
		"\32\33\5\f\7\2\33\34\7\5\2\2\34\35\5\n\6\2\35\36\b\4\1\2\36\'\3\2\2\2"+
		"\37 \7\4\2\2 !\5\f\7\2!\"\7\5\2\2\"#\5\n\6\2#$\5\b\5\2$%\b\4\1\2%\'\3"+
		"\2\2\2&\31\3\2\2\2&\37\3\2\2\2\'\7\3\2\2\2()\7\6\2\2)*\7\21\2\2*?\b\5"+
		"\1\2+,\7\6\2\2,-\7\22\2\2-.\7\21\2\2.?\b\5\1\2/\60\7\7\2\2\60\61\7\22"+
		"\2\2\61?\b\5\1\2\62\63\7\b\2\2\63\64\7\21\2\2\64\65\7\t\2\2\65\66\7\21"+
		"\2\2\66?\b\5\1\2\678\7\b\2\289\7\22\2\29:\7\21\2\2:;\7\t\2\2;<\7\22\2"+
		"\2<=\7\21\2\2=?\b\5\1\2>(\3\2\2\2>+\3\2\2\2>/\3\2\2\2>\62\3\2\2\2>\67"+
		"\3\2\2\2?\t\3\2\2\2@A\5\16\b\2AB\b\6\1\2BH\3\2\2\2CD\5\16\b\2DE\5\n\6"+
		"\2EF\b\6\1\2FH\3\2\2\2G@\3\2\2\2GC\3\2\2\2H\13\3\2\2\2IJ\5\16\b\2JK\b"+
		"\7\1\2K~\3\2\2\2LM\5\16\b\2MN\5\f\7\2NO\b\7\1\2O~\3\2\2\2PQ\5\16\b\2Q"+
		"R\7\t\2\2RS\5\f\7\2ST\b\7\1\2T~\3\2\2\2UV\5\16\b\2VW\7\n\2\2WX\5\f\7\2"+
		"XY\b\7\1\2Y~\3\2\2\2Z[\5\16\b\2[\\\7\5\2\2\\]\5\f\7\2]^\b\7\1\2^~\3\2"+
		"\2\2_`\5\16\b\2`a\7\13\2\2ab\5\f\7\2bc\b\7\1\2c~\3\2\2\2de\5\16\b\2ef"+
		"\7\f\2\2fg\5\f\7\2gh\b\7\1\2h~\3\2\2\2ij\5\16\b\2jk\7\r\2\2kl\5\f\7\2"+
		"lm\b\7\1\2m~\3\2\2\2no\5\16\b\2op\7\6\2\2pq\5\f\7\2qr\b\7\1\2r~\3\2\2"+
		"\2st\5\16\b\2tu\7\16\2\2uv\5\f\7\2vw\b\7\1\2w~\3\2\2\2xy\5\16\b\2yz\7"+
		"\17\2\2z{\5\f\7\2{|\b\7\1\2|~\3\2\2\2}I\3\2\2\2}L\3\2\2\2}P\3\2\2\2}U"+
		"\3\2\2\2}Z\3\2\2\2}_\3\2\2\2}d\3\2\2\2}i\3\2\2\2}n\3\2\2\2}s\3\2\2\2}"+
		"x\3\2\2\2~\r\3\2\2\2\177\u0080\7\24\2\2\u0080\u0081\b\b\1\2\u0081\17\3"+
		"\2\2\2\6&>G}";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
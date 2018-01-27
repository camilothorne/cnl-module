// Generated from FinCNL.g4 by ANTLR 4.5.1
package com.finiti.external.uma.cli.antlrnew;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FinCNLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, WH=14, DATE=15, DUR=16, COP=17, 
		CHAR=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "WH", "DATE", "DUR", "COP", "CHAR"
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




	/* graph URI */
	final String graphURI = "<http://have.a.nice.day/#wtfpl_2015-10-15>";


	/* FINITI prefix */
	final String prefix 	= "<http://finiti.com/ontology/company/2015-10-13#>";




	public FinCNLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FinCNL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\24\u009d\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\5\17f\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\5\20v\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\5\21\u0090\n\21\3\22\3\22\3\22\3\22\3\22\5\22\u0097\n\22\3\23\6"+
		"\23\u009a\n\23\r\23\16\23\u009b\2\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\3\2\3\4\2C\\c|"+
		"\u00a9\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5)\3\2\2\2\7-\3\2\2\2\t\60\3\2\2\2"+
		"\13\63\3\2\2\2\r;\3\2\2\2\17C\3\2\2\2\21G\3\2\2\2\23J\3\2\2\2\25M\3\2"+
		"\2\2\27R\3\2\2\2\31V\3\2\2\2\33Y\3\2\2\2\35e\3\2\2\2\37u\3\2\2\2!\u008f"+
		"\3\2\2\2#\u0096\3\2\2\2%\u0099\3\2\2\2\'(\7A\2\2(\4\3\2\2\2)*\7v\2\2*"+
		"+\7j\2\2+,\7g\2\2,\6\3\2\2\2-.\7q\2\2./\7h\2\2/\b\3\2\2\2\60\61\7k\2\2"+
		"\61\62\7p\2\2\62\n\3\2\2\2\63\64\7k\2\2\64\65\7p\2\2\65\66\7\"\2\2\66"+
		"\67\7g\2\2\678\7c\2\289\7e\2\29:\7j\2\2:\f\3\2\2\2;<\7d\2\2<=\7g\2\2="+
		">\7v\2\2>?\7y\2\2?@\7g\2\2@A\7g\2\2AB\7p\2\2B\16\3\2\2\2CD\7c\2\2DE\7"+
		"p\2\2EF\7f\2\2F\20\3\2\2\2GH\7q\2\2HI\7t\2\2I\22\3\2\2\2JK\7d\2\2KL\7"+
		"{\2\2L\24\3\2\2\2MN\7h\2\2NO\7t\2\2OP\7q\2\2PQ\7o\2\2Q\26\3\2\2\2RS\7"+
		"h\2\2ST\7q\2\2TU\7t\2\2U\30\3\2\2\2VW\7v\2\2WX\7q\2\2X\32\3\2\2\2YZ\7"+
		"q\2\2Z[\7p\2\2[\34\3\2\2\2\\]\7y\2\2]^\7j\2\2^_\7k\2\2_`\7e\2\2`f\7j\2"+
		"\2ab\7y\2\2bc\7j\2\2cd\7c\2\2df\7v\2\2e\\\3\2\2\2ea\3\2\2\2f\36\3\2\2"+
		"\2gh\4\62;\2hi\4\62;\2ij\4\62;\2jv\4\62;\2kl\4\62;\2lm\4\62;\2mn\4\62"+
		";\2no\4\62;\2op\7/\2\2pq\4\62;\2qr\4\62;\2rs\7/\2\2st\4\62;\2tv\4\62;"+
		"\2ug\3\2\2\2uk\3\2\2\2v \3\2\2\2wx\7S\2\2x\u0090\7\63\2\2yz\7S\2\2z\u0090"+
		"\7\64\2\2{|\7S\2\2|\u0090\7\65\2\2}~\7S\2\2~\u0090\7\66\2\2\177\u0080"+
		"\7s\2\2\u0080\u0090\7\63\2\2\u0081\u0082\7s\2\2\u0082\u0090\7\64\2\2\u0083"+
		"\u0084\7s\2\2\u0084\u0090\7\65\2\2\u0085\u0086\7s\2\2\u0086\u0090\7\66"+
		"\2\2\u0087\u0088\7{\2\2\u0088\u0089\7g\2\2\u0089\u008a\7c\2\2\u008a\u0090"+
		"\7t\2\2\u008b\u008c\7[\2\2\u008c\u008d\7g\2\2\u008d\u008e\7c\2\2\u008e"+
		"\u0090\7t\2\2\u008fw\3\2\2\2\u008fy\3\2\2\2\u008f{\3\2\2\2\u008f}\3\2"+
		"\2\2\u008f\177\3\2\2\2\u008f\u0081\3\2\2\2\u008f\u0083\3\2\2\2\u008f\u0085"+
		"\3\2\2\2\u008f\u0087\3\2\2\2\u008f\u008b\3\2\2\2\u0090\"\3\2\2\2\u0091"+
		"\u0092\7k\2\2\u0092\u0097\7u\2\2\u0093\u0094\7c\2\2\u0094\u0095\7t\2\2"+
		"\u0095\u0097\7g\2\2\u0096\u0091\3\2\2\2\u0096\u0093\3\2\2\2\u0097$\3\2"+
		"\2\2\u0098\u009a\t\2\2\2\u0099\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c&\3\2\2\2\b\2eu\u008f\u0096\u009b"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
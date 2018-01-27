// Generated from FinCNL.g4 by ANTLR 4.5.1
package com.finiti.external.uma.cli.antlrnew;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FinCNLParser}.
 */
public interface FinCNLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FinCNLParser#eval}.
	 * @param ctx the parse tree
	 */
	void enterEval(FinCNLParser.EvalContext ctx);
	/**
	 * Exit a parse tree produced by {@link FinCNLParser#eval}.
	 * @param ctx the parse tree
	 */
	void exitEval(FinCNLParser.EvalContext ctx);
	/**
	 * Enter a parse tree produced by {@link FinCNLParser#cnlQuery}.
	 * @param ctx the parse tree
	 */
	void enterCnlQuery(FinCNLParser.CnlQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link FinCNLParser#cnlQuery}.
	 * @param ctx the parse tree
	 */
	void exitCnlQuery(FinCNLParser.CnlQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link FinCNLParser#nPhrase}.
	 * @param ctx the parse tree
	 */
	void enterNPhrase(FinCNLParser.NPhraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link FinCNLParser#nPhrase}.
	 * @param ctx the parse tree
	 */
	void exitNPhrase(FinCNLParser.NPhraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link FinCNLParser#pPhrase}.
	 * @param ctx the parse tree
	 */
	void enterPPhrase(FinCNLParser.PPhraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link FinCNLParser#pPhrase}.
	 * @param ctx the parse tree
	 */
	void exitPPhrase(FinCNLParser.PPhraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link FinCNLParser#eNT}.
	 * @param ctx the parse tree
	 */
	void enterENT(FinCNLParser.ENTContext ctx);
	/**
	 * Exit a parse tree produced by {@link FinCNLParser#eNT}.
	 * @param ctx the parse tree
	 */
	void exitENT(FinCNLParser.ENTContext ctx);
	/**
	 * Enter a parse tree produced by {@link FinCNLParser#kPI}.
	 * @param ctx the parse tree
	 */
	void enterKPI(FinCNLParser.KPIContext ctx);
	/**
	 * Exit a parse tree produced by {@link FinCNLParser#kPI}.
	 * @param ctx the parse tree
	 */
	void exitKPI(FinCNLParser.KPIContext ctx);
	/**
	 * Enter a parse tree produced by {@link FinCNLParser#aTOM}.
	 * @param ctx the parse tree
	 */
	void enterATOM(FinCNLParser.ATOMContext ctx);
	/**
	 * Exit a parse tree produced by {@link FinCNLParser#aTOM}.
	 * @param ctx the parse tree
	 */
	void exitATOM(FinCNLParser.ATOMContext ctx);
}
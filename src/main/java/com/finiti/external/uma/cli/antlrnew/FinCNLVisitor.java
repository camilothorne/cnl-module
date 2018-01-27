// Generated from FinCNL.g4 by ANTLR 4.5.1
package com.finiti.external.uma.cli.antlrnew;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FinCNLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FinCNLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FinCNLParser#eval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEval(FinCNLParser.EvalContext ctx);
	/**
	 * Visit a parse tree produced by {@link FinCNLParser#cnlQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCnlQuery(FinCNLParser.CnlQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link FinCNLParser#nPhrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNPhrase(FinCNLParser.NPhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link FinCNLParser#pPhrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPPhrase(FinCNLParser.PPhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link FinCNLParser#eNT}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitENT(FinCNLParser.ENTContext ctx);
	/**
	 * Visit a parse tree produced by {@link FinCNLParser#kPI}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKPI(FinCNLParser.KPIContext ctx);
	/**
	 * Visit a parse tree produced by {@link FinCNLParser#aTOM}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitATOM(FinCNLParser.ATOMContext ctx);
}
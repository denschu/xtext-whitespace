package com.denschu.xtext.whitespace.parser;

import org.antlr.runtime.Token;
import org.eclipse.xtext.parser.antlr.AbstractSplittingTokenSource;
import org.eclipse.xtext.parser.antlr.ITokenAcceptor;

/**
 * IndentTokenSource yields additional INDENT / DEDENT tokens for (\n+ \t*) NL
 * tokens whenever the amount of tabs (indentation) changes.
 */
public class IndentTokenSource extends AbstractSplittingTokenSource {

	private int level;

	@Override
	protected boolean shouldSplitToken(Token token) {
		System.out.println("shouldSplitToken: " + token.toString());
		//return token.getType() == InternalMyDslLexer.RULE_EOL || token.getType() == Token.EOF;
		return true;
	}

	@Override
	protected void doSplitToken(Token token, ITokenAcceptor result) {
		//System.out.println("doSplitToken: " + token.toString());
		result.accept(token);
	}

	private int countTabs(String text) {
		int firstTab = text.indexOf("\t");
		return (firstTab == -1) ? 0 : text.length() - firstTab;
	}
}

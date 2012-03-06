package com.denschu.xtext.whitespace.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.eclipse.xtext.parser.antlr.AbstractSplittingTokenSource;
import org.eclipse.xtext.parser.antlr.ITokenAcceptor;

import com.denschu.xtext.whitespace.parser.antlr.internal.InternalMyDslLexer;

/**
 * IndentTokenSource yields additional INDENT / DEDENT tokens for (\n+ \t*) NL
 * tokens whenever the amount of tabs (indentation) changes.
 */
public class IndentTokenSource extends AbstractSplittingTokenSource {

	private Token lastToken;

	@Override
	protected boolean shouldSplitToken(Token token) {
		System.out.println("shouldSplitToken: " + token.toString());
		return true;
	}

	@Override
	protected void doSplitToken(Token token, ITokenAcceptor result) {
		lastToken = token;
		if(lastToken.getType() == InternalMyDslLexer.RULE_WS && token.getType() == InternalMyDslLexer.RULE_WS){
			result.accept(new CommonToken(InternalMyDslLexer.RULE_TAB, ""));	
		}else{
			result.accept(lastToken);
		}
	}

}

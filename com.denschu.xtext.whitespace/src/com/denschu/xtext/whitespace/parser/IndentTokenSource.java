package com.denschu.xtext.whitespace.parser;

import org.antlr.runtime.Token;
import org.eclipse.xtext.parser.antlr.AbstractSplittingTokenSource;
import org.eclipse.xtext.parser.antlr.ITokenAcceptor;

/**
 * IndentTokenSource yields additional INDENT / DEDENT tokens for (\n+ \t*) NL
 * tokens whenever the amount of tabs (indentation) changes.
 */
public class IndentTokenSource extends AbstractSplittingTokenSource {

	private StringBuffer buffer;
	private Token lastToken;

	@Override
	protected boolean shouldSplitToken(Token token) {
		System.out.println("shouldSplitToken: " + token.toString());
		return true;
	}

	@Override
	protected void doSplitToken(Token token, ITokenAcceptor result) {
//		System.out.println("doSplitToken: " + token.toString());
//		lastToken = token;
//		if(token.getType() == InternalMyDslLexer.RULE_WS){
//			buffer.append(token.getText());		
//		}else{
//			result.accept(token);			
//		}
		result.accept(token);
	}

}

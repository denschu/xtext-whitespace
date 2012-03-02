package com.denschu.xtext.whitespace.parser;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;

import com.denschu.xtext.whitespace.parser.antlr.MyDslParser;

public class IndentMyDslParser extends MyDslParser {
	@Override
	protected TokenSource createLexer(CharStream stream) {
		IndentTokenSource tokenSource = new IndentTokenSource();
		tokenSource.setDelegate(super.createLexer(stream));
		return tokenSource;
	}
}

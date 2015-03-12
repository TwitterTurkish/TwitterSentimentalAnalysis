package com.utku.process.nlp.zemberek;

import java.util.List;

import org.antlr.v4.runtime.Token;

import zemberek.tokenizer.ZemberekLexer;

public class ZemberekTokenizer {

	public static List<Token> tokenizeSentence(String text) {
		ZemberekLexer lexer = new ZemberekLexer();
		return lexer.tokenizeAll(text);
	}

}

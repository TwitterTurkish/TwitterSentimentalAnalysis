package com.utku.process.nlp.model;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;

import zemberek.morphology.parser.MorphParse;

import com.utku.process.nlp.zemberek.ZemberekMorphParser;
import com.utku.process.nlp.zemberek.ZemberekTokenizer;

public class ZemberekParsedSentence {
	private List<TokenAndMorphParse> sentenceComponents;
	private String sentence;
	private String stemmedSentence;

	public ZemberekParsedSentence(String text) {
		sentenceComponents = new ArrayList<TokenAndMorphParse>();
		this.sentence = text;
		List<Token> result = ZemberekTokenizer.tokenizeSentence(text);
		ZemberekMorphParser z = new ZemberekMorphParser();

		StringBuilder sb = new StringBuilder();
		for (Token token : result) {
			sb.append(" ");
			List<MorphParse> parses = z.parse(token.getText());
			sentenceComponents.add(new TokenAndMorphParse(token, parses));
			sb.append(parses.get(0).getStems().get(0));
		}
		stemmedSentence = sb.toString().trim();

	}

	public List<TokenAndMorphParse> getSentenceComponents() {
		return sentenceComponents;
	}

	public String getSentence() {
		return sentence;
	}

	public String getStemmedSentence() {
		return stemmedSentence;
	}

}

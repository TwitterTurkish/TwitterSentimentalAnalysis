package com.utku.process.nlp.model;

import java.util.List;

public class ZemberekParsedSentence {
	private List<TokenAndMorphParse> sentenceComponents;
	private String sentence;
	private String stemmedSentence;

	public ZemberekParsedSentence(String sentence, String stemmedSentence,
			List<TokenAndMorphParse> sentenceComponents) {
		this.sentence = sentence;
		this.stemmedSentence = stemmedSentence;
		this.sentenceComponents = sentenceComponents;

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

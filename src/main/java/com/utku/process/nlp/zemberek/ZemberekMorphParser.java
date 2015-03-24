package com.utku.process.nlp.zemberek;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;

import zemberek.morphology.apps.TurkishMorphParser;
import zemberek.morphology.parser.MorphParse;

import com.utku.process.nlp.model.TokenAndMorphParse;
import com.utku.process.nlp.model.ZemberekParsedSentence;

public class ZemberekMorphParser {

	private static ZemberekMorphParser instance = new ZemberekMorphParser();
	// private static final Logger logger = Logger
	// .getLogger(ZemberekMorphParser.class);
	private TurkishMorphParser parser;

	private ZemberekMorphParser() {
		init();
	}

	private void init() {
		try {
			this.parser = TurkishMorphParser.createWithDefaults();
			// logger.info("Turkish Morph Parser initialized. Created with defaults");
		} catch (IOException e) {
			parser = null;
			// logger.info("Error initializing parser:");
			// logger.info(e.getMessage());
		} catch (Exception e) {
			parser = null;
			// logger.info("Error initializing parser:");
			// logger.info(e.getMessage());
		}
	}

	public static ZemberekMorphParser getInstance() {
		return instance;
	}

	public ZemberekParsedSentence parseSentence(String text) {
		List<TokenAndMorphParse> sentenceComponents = new ArrayList<TokenAndMorphParse>();
		String sentence = text;
		List<Token> result = ZemberekTokenizer.tokenizeSentence(text);

		StringBuilder sb = new StringBuilder();
		for (Token token : result) {
			sb.append(" ");
			List<MorphParse> parses = this.parse(token.getText());
			if (token.getText() != null && parses.size() != 0) {
				sentenceComponents.add(new TokenAndMorphParse(token, parses));
				sb.append(parses.get(0).getStems().get(0));
			}
		}
		String stemmedSentence = sb.toString().trim();
		return new ZemberekParsedSentence(text, stemmedSentence,
				sentenceComponents);
	}

	public List<MorphParse> parse(String word) {
		if (parser == null)
			return new ArrayList<MorphParse>();
		return parser.parse(word);
	}

}

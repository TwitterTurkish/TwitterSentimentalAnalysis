package com.utku.process.nlp.zemberek;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import zemberek.morphology.apps.TurkishMorphParser;
import zemberek.morphology.parser.MorphParse;

public class ZemberekMorphParser {
	private TurkishMorphParser parser;

	public ZemberekMorphParser() {
		try {
			this.parser = TurkishMorphParser.createWithDefaults();
		} catch (IOException e) {
			e.printStackTrace();
			parser = null;
		}
	}

	public ZemberekMorphParser(TurkishMorphParser parser) {
		this.parser = parser;
	}

	public List<MorphParse> parse(String word) {
		if (parser == null)
			return new ArrayList<MorphParse>();
		return parser.parse(word);
	}

}

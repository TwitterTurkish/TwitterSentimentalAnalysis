package com.utku.process.nlp.model;

import java.util.List;

import org.antlr.v4.runtime.Token;

import zemberek.morphology.parser.MorphParse;

public class TokenAndMorphParse {

	private Token token;
	private List<MorphParse> morphParses;

	public TokenAndMorphParse(Token token, List<MorphParse> morphParse) {
		this.token = token;
		this.morphParses = morphParse;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public List<MorphParse> getMorphParse() {
		return morphParses;
	}

	public void setMorphParse(List<MorphParse> morphParse) {
		this.morphParses = morphParse;
	}

}

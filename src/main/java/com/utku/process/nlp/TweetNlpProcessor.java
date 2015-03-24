package com.utku.process.nlp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.utku.model.TweetSimple;
import com.utku.process.nlp.model.TokenAndMorphParse;
import com.utku.process.nlp.model.ZemberekParsedSentence;
import com.utku.process.nlp.zemberek.ZemberekMorphParser;

public class TweetNlpProcessor {

	public static Map<String, Integer> generateBagOfWords(
			List<TweetSimple> tweets) {
		Map<String, Integer> bagOfWords = new HashMap<String, Integer>();
		ZemberekMorphParser zembMorph = ZemberekMorphParser.getInstance();
		for (TweetSimple tweetSimple : tweets) {
			ZemberekParsedSentence zps = zembMorph.parseSentence(tweetSimple
					.getText());
			List<TokenAndMorphParse> sentenceComponents = zps
					.getSentenceComponents();
			for (TokenAndMorphParse word : sentenceComponents) {
				String stemmedWord = word.getMorphParse().get(0).getStems()
						.get(0);
				if (bagOfWords.containsKey(stemmedWord))
					bagOfWords
							.put(stemmedWord, bagOfWords.get(stemmedWord) + 1);
				else {
					bagOfWords.put(stemmedWord, 1);
				}
			}

		}
		return bagOfWords;
	}
}

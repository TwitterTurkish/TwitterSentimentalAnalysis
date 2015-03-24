package com.utku.service;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;

import twitter4j.Query;
import twitter4j.Query.ResultType;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import com.utku.model.QueryResultDummyImpl;

public class TwitterAPIService {

	private static final Logger logger = Logger
			.getLogger(TwitterAPIService.class);

	private Twitter twitter;

	protected String lang;

	protected String resultType;

	protected int count;

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@PostConstruct
	private void afterInitialize() {
		twitter = TwitterFactory.getSingleton();
	}

	public QueryResult search(String keyword) {

		Query query = new Query();
		query.setLang(lang);
		query.setResultType(ResultType.valueOf(resultType));
		query.setCount(count);
		query.setQuery(keyword);
		try {
			logger.info("Search initialized.");
			QueryResult result = twitter.search(query);
			logger.info("Search successful.");
			return result;
		} catch (TwitterException e) {
			logger.error("Search failed");
			logger.error(e);
			return new QueryResultDummyImpl();
		}
	}

}

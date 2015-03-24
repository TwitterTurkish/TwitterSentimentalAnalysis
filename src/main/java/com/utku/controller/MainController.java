package com.utku.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import twitter4j.QueryResult;
import twitter4j.Status;

import com.utku.model.TweetSimple;
import com.utku.service.TwitterAPIService;
import com.utku.service.TwitterNlpService;

@Controller
public class MainController {
	@Autowired
	private ApplicationContext _applicationContext;
	private static final Logger logger = Logger.getLogger(MainController.class);

	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String search(
			@RequestParam(value = "name", required = true) String searchKey,
			@RequestParam(value = "count", required = false) Integer count) {
		logger.info("Search with name: " + searchKey);
		TwitterAPIService instance = (TwitterAPIService) _applicationContext
				.getBean("twitterService");
		if (count != null)
			instance.setCount(count);
		QueryResult search = instance.search(searchKey);
		List<Status> tweets = search.getTweets();
		return TweetSimple.toTweetSimple(tweets).toString();
	}

	@RequestMapping(value = "/word.count", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String wordCounts(
			@RequestParam(value = "name", required = true) String searchKey,
			@RequestParam(value = "count", required = false) Integer count) {

		logger.info("Search with name: " + searchKey);
		TwitterAPIService instance = (TwitterAPIService) _applicationContext
				.getBean("twitterService");
		if (count != null)
			instance.setCount(count);
		QueryResult search = instance.search(searchKey);
		List<Status> tweets = search.getTweets();
		Map<String, Integer> generateBagOfWords = TwitterNlpService
				.generateBagOfWords(TweetSimple.toTweetSimple(tweets));
		return generateBagOfWords.toString();
	}
}

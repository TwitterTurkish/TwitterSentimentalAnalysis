package com.utku.model;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Status;

public class TweetSimple {
	private String userName;
	private String text;

	public TweetSimple(String userName, String text) {
		this.userName = userName;
		this.text = text;
	}

	@Override
	public String toString() {
		return "@" + userName + ":" + " " + text;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public static TweetSimple toTweetSimple(Status status) {
		return new TweetSimple(status.getUser().getScreenName(),
				status.getText());
	}

	public static List<TweetSimple> toTweetSimple(List<Status> statuses) {
		List<TweetSimple> results = new ArrayList<TweetSimple>();
		for (Status tweet : statuses) {
			results.add(new TweetSimple(tweet.getUser().getScreenName(), tweet
					.getText()));
		}
		return results;
	}
}

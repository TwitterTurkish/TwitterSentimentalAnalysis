package com.utku.model;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.RateLimitStatus;
import twitter4j.Status;

public class QueryResultDummyImpl implements QueryResult {

	public QueryResultDummyImpl() {

	}
	@Override
	public RateLimitStatus getRateLimitStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAccessLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getSinceId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getMaxId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getRefreshURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getCompletedIn() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Status> getTweets() {
		// TODO Auto-generated method stub
		return new ArrayList<Status>();
	}

	@Override
	public Query nextQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

}

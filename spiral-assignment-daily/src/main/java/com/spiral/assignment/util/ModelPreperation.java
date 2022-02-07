package com.spiral.assignment.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.spiral.assignment.model.QuoteFeed;
import com.spiral.assignment.model.StatusFeed;


public class ModelPreperation 
{
	private static int idStatus = 0;
	private static int idQuote  = 0;
	private HashMap<Integer, StatusFeed> statusFeeds = new HashMap<Integer, StatusFeed>();
	private HashMap<Integer, QuoteFeed> quoteFeeds = new HashMap<Integer, QuoteFeed>();
		
	public ModelPreperation()
	{
		for(int i = 0; i < 5; ++i)
		{
			createStatusFeed();
			createQuoteFeed();
		}
		createRestrictedStatusFeed();
		createRestrictedQuoteFeed();
	}
	
	public boolean createStatusFeed()
	{
		++idStatus;
		StatusFeed sFeed = new StatusFeed();
		sFeed.setId(idStatus);
		sFeed.setCardTitle("Important Security Update " + idStatus);
		sFeed.setIcon("https://tinyurl.com/y5mdph2g");
		sFeed.setMessage("Message"+idStatus);		
		sFeed.setButtonText("Got it, thanks!");
		statusFeeds.put(idStatus, sFeed);		
		return true;
	}
	public boolean createRestrictedStatusFeed()
	{
		++idStatus;
		StatusFeed sFeed = new StatusFeed();
		sFeed.setId(idStatus);
		sFeed.setCardTitle("Restricted Status Update");
		sFeed.setIcon("https://tinyurl.com/y5mdph2g");
		sFeed.setMessage("Status Restricted");		
		sFeed.setButtonText("View Restrictions");
		statusFeeds.put(idStatus, sFeed);		
		return true;
	}
	
	public boolean createQuoteFeed()
	{
		++idQuote;
		QuoteFeed qFeed = new QuoteFeed();
		qFeed.setId(idQuote);
		qFeed.setAuthor("Author"+idQuote);
		
		StatusFeed sFeed = new StatusFeed();
		sFeed.setId(null);
		sFeed.setCardTitle("Daily Quote");
		sFeed.setMessage("Quote"+idStatus);		
		sFeed.setButtonText(null);
		qFeed.setStatus(sFeed);
		
		quoteFeeds.put(idQuote, qFeed);
		return true;
	}
	public boolean createRestrictedQuoteFeed()
	{
		++idQuote;
		QuoteFeed qFeed = new QuoteFeed();
		qFeed.setId(idQuote);
		qFeed.setAuthor("Hidden");
		
		StatusFeed sFeed = new StatusFeed();
		sFeed.setId(null);
		sFeed.setCardTitle("Restricted Daily Quote");
		sFeed.setMessage("Restricted Daily Quote");		
		sFeed.setButtonText(null);
		qFeed.setStatus(sFeed);
		
		quoteFeeds.put(idQuote, qFeed);
		return true;
	}
	
	public StatusFeed getStatusFeed(int id)
	{
		return statusFeeds.get(id);
	}
	public StatusFeed getStatusFeed(int id, String condition)
	{		
		if(condition != null && !condition.isEmpty())
		{
			return statusFeeds.get(6);
		}
		return statusFeeds.get(id);
	}

	public QuoteFeed getQuoteFeed(int id)
	{
		return quoteFeeds.get(id);
	}
	public QuoteFeed getQuoteFeed(int id, String condition)
	{
		if(condition != null && !condition.isEmpty())
		{
			return quoteFeeds.get(6);
		}
		return quoteFeeds.get(id);
	}
	
	public List<StatusFeed> getStatusFeeds()
	{
		return new ArrayList<StatusFeed>(statusFeeds.values());
	}
	public List<StatusFeed> getStatusFeeds(String condition)
	{

		if(condition != null && !condition.isEmpty())
		{
			StatusFeed feed = statusFeeds.get(6);
			
			ArrayList<StatusFeed> list = new ArrayList<StatusFeed>();
			list.add(feed);
			
			return list;
		}
		
		ArrayList<StatusFeed> feeds = new ArrayList<StatusFeed>(statusFeeds.values());
		
		return feeds;
	}

	public List<QuoteFeed> getQuoteFeeds()
	{
		return new ArrayList<QuoteFeed>(quoteFeeds.values());
	}	
	public List<QuoteFeed> getQuoteFeeds(String condition)
	{
		if(condition != null && !condition.isEmpty())
		{
			QuoteFeed feed = quoteFeeds.get(6);
			
			ArrayList<QuoteFeed> list = new ArrayList<QuoteFeed>();
			list.add(feed);
			
			return list;
		}
		
		ArrayList<QuoteFeed> feeds = new ArrayList<QuoteFeed>(quoteFeeds.values());
		
		return feeds;
	}
}

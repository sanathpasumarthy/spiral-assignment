package com.spiral.assignment.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spiral.assignment.model.QuoteFeed;
import com.spiral.assignment.model.StatusFeed;
import com.spiral.assignment.util.ModelPreperation;

@RestController
@RequestMapping("/cardfeeds")
public class CardFeedResource 
{

	private static final ModelPreperation model = new ModelPreperation();
	
	@RequestMapping("/status")
	public List<StatusFeed> getStatusFeeds()
	{
		return model.getStatusFeeds();
	}
	
	@RequestMapping("/quotes")
	public List<QuoteFeed> getQuoteFeeds()
	{
		return new ArrayList<QuoteFeed>(model.getQuoteFeeds());
	}	
	
	@RequestMapping("/status/{id}")
	public StatusFeed getStatusFeed(@PathVariable("id") int id)
	{
		return model.getStatusFeed(id, getCondition());
	}
	
	@RequestMapping("/quotes/{id}")
	public QuoteFeed getQuoteFeed(@PathVariable("id") int id)
	{
		return model.getQuoteFeed(id, getCondition());
	}	
	
	private String getCondition()
	{
		String condition = System.currentTimeMillis()%2==0?"time-constrained":null;
		return condition;
	}
}

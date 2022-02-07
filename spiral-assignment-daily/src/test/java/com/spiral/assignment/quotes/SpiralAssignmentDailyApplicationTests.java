package com.spiral.assignment.quotes;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.spiral.assignment.resources.CardFeedResource;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CardFeedResource.class)
class SpiralAssignmentDailyApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void testQuoteRetrieval() throws Exception
	{

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/cardfeeds/quotes/3").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assertTrue(result != null);
		

		String expected1 = "{\"id\":3,\"status\":{\"cardTitle\":\"Daily Quote\",\"message\":\"Quote3\"},\"author\":\"Author3\"}";
		String expected2 = "{\"id\":6,\"status\":{\"cardTitle\":\"Restricted Daily Quote\",\"message\":\"Restricted Daily Quote\"},\"author\":\"Hidden\"}";

		String res = result.getResponse().getContentAsString();

		assertTrue(res != null);
		
		assertTrue(res.equals(expected1) || res.equals(expected2));
	}
	
	@Test
	public void testStatusRetrieval() throws Exception
	{

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/cardfeeds/status/3").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assertTrue(result != null);
		
		String expected1 = "{\"id\":3,\"cardTitle\":Important Security Update 3,icon:https://tinyurl.com/y5mdph2g,message:Message3,buttonText:Got it, thanks!}";
		String expected2 = "{\"id\":6,\"cardTitle\":\"Restricted Status Update\",\"icon\":\"https://tinyurl.com/y5mdph2g\",\"message\":\"Status Restricted\",\"buttonText\":\"View Restrictions\"}";

		String res = result.getResponse().getContentAsString();

		assertTrue(res != null);
		
		assertTrue(res.equals(expected1) || res.equals(expected2));
	}
}

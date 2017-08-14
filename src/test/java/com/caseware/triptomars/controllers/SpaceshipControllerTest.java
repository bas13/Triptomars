package com.caseware.triptomars.controllers;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.caseware.triptomars.TriptomarsApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TriptomarsApplication.class)
@WebAppConfiguration
public class SpaceshipControllerTest {

	private MediaType contentType = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("utf8"));
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext; 
	
	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

	}
	
	@Test
	public void testNextSpot() throws Exception {
		mockMvc.perform(get("/next/spot/{o}", 1)).andExpect(status().isOk()).andDo(print());
	}
	
	@Test
	public void testGetShipState() throws Exception {
		mockMvc.perform(get("/state")).andExpect(status().isOk()).andExpect(content().contentType(contentType)).andDo(print());
	}
	
	@Test
	public void testObjectAt() throws Exception {
		mockMvc.perform(get("/object/at/{i}/{j}/{k}",0,1,1)).andExpect(status().isOk()).andDo(print());
	}
	
	

}

package com.caseware.triptomars.controllers;

import static org.junit.Assert.*;
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
import com.caseware.triptomars.domains.Spaceship;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TriptomarsApplication.class)
@WebAppConfiguration
public class SpaceshipControllerTest {

	private MediaType contentType = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("utf8"));
	
	private MockMvc mockMvc;
	
	private Spaceship spaceShip;
	
	@Autowired
	private WebApplicationContext webApplicationContext; 
	
	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

	}
	
	@Test
	public void testGetShipState() throws Exception {
		
		//spaceShip = (Spaceship) webApplicationContext.getBean("spaceship");
		//String result = spaceShip.toString();
		mockMvc.perform(get("")).andExpect(status().isOk()).andExpect(content().contentType(contentType)).andDo(print());
	}

}

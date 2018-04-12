package com.jinhu.controller;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
public class AuthorControllerTest {
	
	@Test
	public void testFind() throws Exception{
		AuthorController controller=new AuthorController();
		MockMvc mockMvc=MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(MockMvcRequestBuilders.get("/author/1"))
		.andExpect(MockMvcResultMatchers.view().name("author"));
	}
}

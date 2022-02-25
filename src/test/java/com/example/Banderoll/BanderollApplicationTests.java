package com.example.Banderoll;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

@AutoConfigureMockMvc
@SpringBootTest
class BanderollApplicationTests {

	@Autowired
	MockMvc mvc;

	@Autowired
	ObjectMapper mapper;

	@Test
	void contextLoads() {
	}

	@Test
	public void testFrontPage() throws Exception {
		mvc.perform(
						MockMvcRequestBuilders.get("/")
				)
				.andExpect(status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.content().string(containsString("Welcome to Banderole!")));
	}

	@Test
	public void testPlayerSignup() throws Exception {
		mvc.perform(
						MockMvcRequestBuilders.get("/player")
				)
				.andExpect(status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.content().string(containsString("Create Account")));

		mvc.perform (
					MockMvcRequestBuilders.post("/player")

							.content(mapper.writeValueAsString(new Player("bill", "123")))
							.contentType(MediaType.APPLICATION_JSON_UTF8)
				)
							.andExpect(status().is2xxSuccessful());


	}
	@Test
	public void testQuizPage() throws Exception {
		mvc.perform(
				MockMvcRequestBuilders.get("/quiz")

		)
				.andExpect(status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.content().string(containsString("GUESS THE CAPITAL")));
	}
	@Test
	public void testLogIn() throws Exception{
		mvc.perform(
				MockMvcRequestBuilders.get("")

		)
				.andExpect(status().is2xxSuccessful());
		mvc.perform(
				MockMvcRequestBuilders.post("")
						.content(mapper.writeValueAsString(new Player("bill", "123")))
						.contentType(MediaType.APPLICATION_JSON_UTF8)
		)
				.andExpect(status().is2xxSuccessful());


	}



}

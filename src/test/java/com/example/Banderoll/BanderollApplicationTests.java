package com.example.Banderoll;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
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
	@Autowired
	QuestionService qs;
	@Test
	public void testQuestionServiceCapitalsRightAnswer() throws Exception {
		Question q = qs.getQuestion(2);
		String result = q.getRightAnswer();
		String[] resultArray = q.getAnswers();
		String result2 = resultArray[0];
		System.out.println(result);
		Assert.assertEquals(true, result2.equals(result));
		// Om man ger qs choice "2" betyder det att spelaren väljer att bli quizad på huvudstäder.
	}

	@Test
	public void testQuestionServiceCapitalsWrongAnswer() throws Exception {
		Question q = qs.getQuestion(2);
		String result = q.getRightAnswer();
		String[] resultArray = q.getAnswers();
		String result2 = resultArray[1];
		System.out.println(result);
		Assert.assertEquals(false, result2.equals(result));
		// Om man ger qs choice "2" betyder det att spelaren väljer att bli quizad på huvudstäder.
	}

	@Test
	public void testQuestionServiceFlags() throws Exception {
		Question q = qs.getQuestion(3);
		String result = q.getRightAnswer();
		String[] resultArray = q.getAnswers();
		String result2 = resultArray[0];
		System.out.println(result);
		Assert.assertEquals(true, result2.equals(result));
		// Om man ger qs choice "2" betyder det att spelaren väljer att bli quizad på flaggor.
	}

	@Autowired
	QuestionService qs;
	@Test
	public void testQuestionServiceCapitalsRightAnswer() throws Exception {
		Question q = qs.getQuestion(2);
		String result = q.getRightAnswer();
		String[] resultArray = q.getAnswers();
		String result2 = resultArray[0];
		System.out.println(result);
		Assert.assertEquals(true, result2.equals(result));
		// Om man ger qs choice "2" betyder det att spelaren väljer att bli quizad på huvudstäder.
	}

	@Test
	public void testQuestionServiceCapitalsWrongAnswer() throws Exception {
		Question q = qs.getQuestion(2);
		String result = q.getRightAnswer();
		String[] resultArray = q.getAnswers();
		String result2 = resultArray[1];
		System.out.println(result);
		Assert.assertEquals(false, result2.equals(result));
		// Om man ger qs choice "2" betyder det att spelaren väljer att bli quizad på huvudstäder.
	}

	@Test
	public void testQuestionServiceFlags() throws Exception {
		Question q = qs.getQuestion(3);
		String result = q.getRightAnswer();
		String[] resultArray = q.getAnswers();
		String result2 = resultArray[0];
		System.out.println(result);
		Assert.assertEquals(true, result2.equals(result));
		// Om man ger qs choice "2" betyder det att spelaren väljer att bli quizad på flaggor.
	}

	@Autowired
	CountryRepository countryRepository;
	@Test
	public void testCapitalRepository() throws Exception {



	}



}

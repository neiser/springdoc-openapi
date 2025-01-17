package test.org.springdoc.api.app41;

import static org.hamcrest.Matchers.*;
import static org.skyscreamer.jsonassert.JSONAssert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;
import org.springdoc.core.Constants;
import org.springframework.test.web.servlet.MvcResult;

import test.org.springdoc.api.AbstractSpringDocTest;

public class SpringDocApp41Test extends AbstractSpringDocTest {

	@Test
	public void testApp() throws Exception {
		String className = getClass().getSimpleName();
		String testNumber = className.replaceAll("[^0-9]", "");
		MvcResult mockMvcResult = mockMvc.perform(get(Constants.DEFAULT_API_DOCS_URL)).andExpect(status().isOk())
				.andExpect(jsonPath("$.openapi", is("3.0.1"))).andReturn();
		// Test result consistency
		mockMvcResult = mockMvc.perform(get(Constants.DEFAULT_API_DOCS_URL)).andExpect(status().isOk())
				.andExpect(jsonPath("$.openapi", is("3.0.1"))).andReturn();
		String result = mockMvcResult.getResponse().getContentAsString();
		Path path = Paths.get(getClass().getClassLoader().getResource("results/app" + testNumber + ".json").toURI());
		byte[] fileBytes = Files.readAllBytes(path);
		String expected = new String(fileBytes);
		assertEquals(expected, result, false);
	}

}
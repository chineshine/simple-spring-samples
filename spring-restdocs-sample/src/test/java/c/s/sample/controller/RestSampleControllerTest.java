/**
 * 
 */
package c.s.sample.controller;

import static org.junit.Assert.*;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.*;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 
 * @author chineshine
 * @since 2020-8-28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestSampleControllerTest {

	private @Autowired WebApplicationContext context;
	@Rule
	public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
				.apply(documentationConfiguration(this.restDocumentation)).alwaysDo(document("{method-name}/{step}"))
				.build();
	}
	
	@Test
	public void indexTest() throws Exception {
		this.mockMvc.perform(get("/").accept(MediaType.TEXT_PLAIN))
		.andExpect(status().isOk())
		;
	}

}

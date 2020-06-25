package com.donus.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FilmeControllerTest {
	
	
	@Autowired
	public WebApplicationContext context;
	
	private MockMvc mvc;
	
	@Before
	public void setup() {	
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();		
	}
	
	@Test
	public void testListRequisitionFail() throws Exception {
		String url = "/movie/list";
		this.mvc.perform(MockMvcRequestBuilders.get(url)).		
		andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	public void testListRequisitionSucess() throws Exception {
		String url = "/movie/list?nivel_censura=CENSURADO";
		this.mvc.perform(MockMvcRequestBuilders.get(url)).		
		andExpect(MockMvcResultMatchers.status().isOk());
		
		String url2 = "/movie/list?nivel_censura=SEM_CENSURA";
		this.mvc.perform(MockMvcRequestBuilders.get(url2)).		
		andExpect(MockMvcResultMatchers.status().isOk());
	
	}
	
	@Test
	public void testCreateRequisitionSucess() throws Exception {
		String url = "/movie/create";
		String json = "{\n" + 
				"	\"nome\": \"TesteRequisicao\",\n" + 
				"	\"dataLancamento\": \"1991-12-16\",\n" + 
				"	\"censura\": \"CENSURADO\",\n" + 
				"	\"direcao\": \"Anderson\",\n" + 
				"	\"atores\": [\n" + 
				"	\"Anderson\"\n" + 
				"	]\n" + 
				"}";
		this.mvc.perform(MockMvcRequestBuilders.post(url).
				contentType(MediaType.APPLICATION_JSON).
				content(json).
				characterEncoding("utf-8")).
		andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
	}
	
	@Test
	public void testCreateRequisitionAtoresFail() throws Exception {
		String url = "/movie/create";
		String json = "{\n" + 
				"	\"nome\": \"TesteRequisicao\",\n" + 
				"	\"dataLancamento\": \"1991-12-16\",\n" + 
				"	\"censura\": \"CENSURADO\",\n" + 
				"	\"direcao\": \"Anderson\",\n" + 
				"	\"atores\": [\n" + 
				"	\"teste1\"\n" +	"	\"teste2\"\n" +	"	\"teste3\"\n" +"	\"teste4\"\n" +
				"	\"teste5\"\n" +	"	\"teste6\"\n" +	"	\"teste7\"\n" +"	\"teste8\"\n" +
				"	\"teste9\"\n" +	"	\"teste10\"\n" +"	\"teste11\"\n" +"	\"teste12\"\n" +
				"	]\n" + 
				"}";
		this.mvc.perform(MockMvcRequestBuilders.post(url).
				contentType(MediaType.APPLICATION_JSON).
				content(json).
				characterEncoding("utf-8")).
		andExpect(MockMvcResultMatchers.status().isBadRequest()).andReturn();
	}
	
	@Test
	public void testCreateRequisitionNomeFail() throws Exception {
		String url = "/movie/create";
		String json = "{\n" + 
				"	\"nome\": \"FilmeTeste\",\n" + 
				"	\"dataLancamento\": \"1991-12-16\",\n" + 
				"	\"censura\": \"CENSURADO\",\n" + 
				"	\"direcao\": \"Anderson\",\n" + 
				"	\"atores\": [\n" + 
				"	\"teste1\"\n" +	"	\"teste2\"\n" +	"	\"teste3\"\n" +"	\"teste4\"\n" +
				"	]\n" + 
				"}";
		this.mvc.perform(MockMvcRequestBuilders.post(url).
				contentType(MediaType.APPLICATION_JSON).
				content(json).
				characterEncoding("utf-8")).
		andExpect(MockMvcResultMatchers.status().isBadRequest()).andReturn();
	}
}

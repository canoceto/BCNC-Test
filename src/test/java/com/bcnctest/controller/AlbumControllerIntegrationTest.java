package com.bcnctest.controller;

import com.bcnctest.BcncTestApplication;
import jakarta.servlet.ServletContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@SpringBootTest(classes = BcncTestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class AlbumControllerIntegrationTest {

    private static final String CONTENT_TYPE = "application/json";
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void givenWac_whenServletContext_thenItProvidesGreetController() {
        final ServletContext servletContext = webApplicationContext.getServletContext();
        assertNotNull(servletContext);
        assertInstanceOf(MockServletContext.class, servletContext);
        assertNotNull(webApplicationContext.getBean("AlbumController"));
    }


//
//    @Test
//    public void givenHomePageURI_whenMockMVC_thenReturnsIndexJSPViewName() throws Exception {
//        this
//                .mockMvc
//                .perform(MockMvcRequestBuilders.get("/homePage"))
//                .andDo(print())
//                .andExpect(MockMvcResultMatchers.view().name("index"));
//    }
//
//    @Test
//    public void givenGreetURI_whenMockMVC_thenVerifyResponse() throws Exception {
//        final MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/greet"))
//                .andDo(print())
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Hello World!!!"))
//                .andReturn();
//        assertEquals(CONTENT_TYPE, mvcResult.getResponse().getContentType());
//    }
//
//    @Test
//    public void givenGreetURIWithPathVariable_whenMockMVC_thenResponseOK() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/greetWithPathVariable/John")).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(CONTENT_TYPE))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Hello World John!!!"));
//    }
//
//    @Test
//    public void givenGreetURIWithPathVariable_2_whenMockMVC_thenVerifyResponse() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/greetWithPathVariable/{name}", "Doe")).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(CONTENT_TYPE))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Hello World Doe!!!"));
//    }
//
//    @Test
//    public void givenGreetURIWithQueryParameter_whenMockMVC_thenResponseOK() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/greetWithQueryVariable").param("name", "John Doe")).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(CONTENT_TYPE))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Hello World John Doe!!!"));
//    }
//
//    @Test
//    public void givenGreetURIWithPost_whenMockMVC_thenVerifyResponse() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/greetWithPost")).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(CONTENT_TYPE))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Hello World!!!"));
//    }

    @Test
    public void givenGreetURIWithPostAndFormData_whenMockMVC_thenResponseOK() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/api/load/all"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(CONTENT_TYPE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("Load successfully"));
    }
}

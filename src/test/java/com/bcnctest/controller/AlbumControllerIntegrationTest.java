package com.bcnctest.controller;

import com.bcnctest.dto.AlbumDTO;
import com.bcnctest.repository.IAlbumRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletContext;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
class AlbumControllerIntegrationTest {

    private static final String CONTENT_TYPE = "application/json";
    private static final String BASE_PATH = "http://localhost:8080";

    private final ObjectMapper objectMapper = new ObjectMapper();


    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private IAlbumRepository albumRepository;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    void validateApplicationContextLoadsProperly() {
        final ServletContext servletContext = webApplicationContext.getServletContext();
        assertNotNull(servletContext);
        assertInstanceOf(MockServletContext.class, servletContext);
    }

    @Test
    void givenGreetURIWithPostAndFormData_whenMockMVC_thenResponseOK() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post(BASE_PATH + "/api/load/all"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(CONTENT_TYPE))
                .andExpect(MockMvcResultMatchers.redirectedUrl(BASE_PATH + "/api/all"));

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders
                        .get(BASE_PATH + "/api/all")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(CONTENT_TYPE))
                .andReturn();

        List<AlbumDTO> albums = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
        });

        assertThat(albums).isNotEmpty();
    }

    @Test
    @DisplayName("Validate the albums and photos were saved in db")
    @Sql(scripts = "classpath:/sql/clean_up.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void givenTheRequestToLoadAlbumsIsSuccessfulThenAlbumsAreSavedInDb() {
        assertThat(albumRepository.findAll()).isEmpty();
        givenTheAlbumsAreLoaded();
        var albums = albumRepository.findAll();
        assertThat(albums).isNotEmpty();
    }

    @SneakyThrows
    private void givenTheAlbumsAreLoaded() {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/api/load/all")).andReturn();
    }
}

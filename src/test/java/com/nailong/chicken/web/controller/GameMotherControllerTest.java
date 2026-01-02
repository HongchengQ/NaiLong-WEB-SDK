package com.nailong.chicken.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nailong.chicken.web.model.dto.AuthDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;

@SpringBootTest
@RequiredArgsConstructor
@Log4j2
class GameMotherControllerTest {

    private final WebApplicationContext wac;

    private MockMvc mockMvc;
    private static final String baseUrl = "/yostar";
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void getAuth() throws Exception {
        AuthDto authDto = new AuthDto();
        authDto.setAccount("test_account");
        authDto.setCode("000000");

        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.post(baseUrl + "/get-auth")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(authDto))
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        log.info(result);
    }

    @Test
    void genToken() throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.post(baseUrl + "/gen-token")
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        log.info(result);
    }

    @Test
    void sendCode() throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.post(baseUrl + "/send-code")
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        log.info(result);
    }
}
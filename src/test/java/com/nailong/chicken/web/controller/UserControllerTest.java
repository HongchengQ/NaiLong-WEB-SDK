package com.nailong.chicken.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nailong.chicken.web.model.dto.LoginBodyDto;
import com.nailong.chicken.web.model.dto.UserSetDataBodyDto;
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
class UserControllerTest {

    private final WebApplicationContext wac;

    private MockMvc mockMvc;
    private static final String baseUrl = "/user";
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void login() throws Exception {
        LoginBodyDto loginBodyDto = new LoginBodyDto();
        loginBodyDto.setType("test_type");
        loginBodyDto.setToken("test_token");

        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.post(baseUrl + "/login")
                                .header("X-Region", "cn")
                                .header("Authorization", "test_auth")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(loginBodyDto))
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        log.info(result);
    }

    @Test
    void quickLogin() throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.post(baseUrl + "/quick-login")
                                .header("X-Region", "cn")
                                .header("Authorization", "test_auth")
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        log.info(result);
    }

    @Test
    void detail() throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.post(baseUrl + "/detail")
                                .header("X-Region", "cn")
                                .header("Authorization", "test_auth")
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        log.info(result);
    }

    @Test
    void sendSms() throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.post(baseUrl + "/send-sms")
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        log.info(result);
    }

    @Test
    void infoSet() throws Exception {
        UserSetDataBodyDto setDataBodyDto = new UserSetDataBodyDto();
        setDataBodyDto.setKey("test_key");
        setDataBodyDto.setValue("test_value");

        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.post(baseUrl + "/set")
                                .header("X-Region", "cn")
                                .header("Authorization", "test_auth")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(setDataBodyDto))
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        log.info(result);
    }

    @Test
    void setInfo() throws Exception {
        UserSetDataBodyDto setDataBodyDto = new UserSetDataBodyDto();
        setDataBodyDto.setKey("test_key");
        setDataBodyDto.setValue("test_value");

        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.post(baseUrl + "/set-info")
                                .header("X-Region", "cn")
                                .header("Authorization", "test_auth")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(setDataBodyDto))
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        log.info(result);
    }
}
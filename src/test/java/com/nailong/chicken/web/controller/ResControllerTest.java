package com.nailong.chicken.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
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
class ResControllerTest {

    private final WebApplicationContext wac;

    private MockMvc mockMvc;
    private static final String baseUrl = "/res";

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void resWinRedirect() throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.get(baseUrl + "/win/test")
                                .header("X-Region", "cn")
                ).andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        log.info(result);
    }

    @Test
    void resAndroidRedirect() throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.get(baseUrl + "/and/test")
                                .header("X-Region", "cn")
                ).andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        log.info(result);
    }

    @Test
    void resIosRedirect() throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.get(baseUrl + "/ios/test")
                                .header("X-Region", "cn")
                ).andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        log.info(result);
    }
}
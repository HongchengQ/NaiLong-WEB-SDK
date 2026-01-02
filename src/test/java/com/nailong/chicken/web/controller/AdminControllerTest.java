package com.nailong.chicken.web.controller;

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
class AdminControllerTest {

    private final WebApplicationContext wac;

    private MockMvc mockMvc;
    private static final String baseUrl = "/admin";

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void decodeServerList() throws Exception {
        String requestBody = "https://nova-static.yostar.cn/notice/noticelist.html";
        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.post(baseUrl + "/decode_server_list")
                                .param("region", "cn")
                                .contentType(MediaType.TEXT_PLAIN)
                                .content(requestBody)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        log.info(result);
    }

    @Test
    void decodeServerListErrorArea() throws Exception {
        String requestBody = "https://nova-static.yostar.cn/notice/noticelist.html";
        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.post(baseUrl + "/decode_server_list")
                                .param("region", "tw")
                                .contentType(MediaType.TEXT_PLAIN)
                                .content(requestBody)
                )
                .andExpect(MockMvcResultMatchers.jsonPath("Code").value(100500))
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        log.info(result);
    }

    @Test
    void decodeServerListFakeLink() throws Exception {
        String requestBody = "uiweyeduwy1@#!#!  da";
        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.post(baseUrl + "/decode_server_list")
                                .param("region", "cn")
                                .contentType(MediaType.TEXT_PLAIN)
                                .content(requestBody)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        log.info(result);
    }

    @Test
    void decodeServerListEmptyLink() throws Exception {
        String requestBody = "";
        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.post(baseUrl + "/decode_server_list")
                                .param("region", "cn")
                                .contentType(MediaType.TEXT_PLAIN)
                                .content(requestBody)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        log.info(result);
    }
}
package com.nailong.websdk.controller;

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
class MetaControllerTest {

    private final WebApplicationContext wac;

    private MockMvc mockMvc;
    private static final String baseUrl = "";

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void serverListHtml() throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.get(baseUrl + "/meta/serverlist.html")
                                .header("X-Region", "cn")
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        byte[] result = mvcResult.getResponse().getContentAsByteArray();
        log.info("Response length: " + result.length);
    }

    @Test
    void noticeListHtml() throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.get(baseUrl + "/notice/noticelist.html")
                                .header("X-Region", "cn")
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        byte[] result = mvcResult.getResponse().getContentAsByteArray();
        log.info("Response length: " + result.length);
    }

    @Test
    void androidPatches() throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.get(baseUrl + "/meta/and.html")
                                .header("X-Region", "cn")
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        byte[] result = mvcResult.getResponse().getContentAsByteArray();
        log.info("Response length: " + result.length);
    }

    @Test
    void winPatches() throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.get(baseUrl + "/meta/win.html")
                                .header("X-Region", "cn")
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        byte[] result = mvcResult.getResponse().getContentAsByteArray();
        log.info("Response length: " + result.length);
    }

    @Test
    void iosPatches() throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.get(baseUrl + "/meta/ios.html")
                                .header("X-Region", "cn")
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        byte[] result = mvcResult.getResponse().getContentAsByteArray();
        log.info("Response length: " + result.length);
    }

    @Test
    void test() throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.get(baseUrl + "/meta/test")
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        log.info(result);
    }
}
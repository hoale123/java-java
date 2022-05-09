package com.webService.webService.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WordController.class)
public class WordControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() {

    }

    @Test
    public void shouldReturnRandomQuote() throws Exception {
        // Arrange
//        System.out.println(MagicEightBallController.getCorrectInt());
        mockMvc.perform(get("/word"))
                .andDo(print())
                .andExpect(status().isOk())                              // ASSERT that we got 200 OK.
                .andExpect(jsonPath("$.word").isNotEmpty())         // ASSERT that we got back a non-empty name.
                .andExpect(jsonPath("$.definition").isNotEmpty())           // ASSERT that we got back a non-empty id.
                .andExpect(jsonPath("$.id").isNotEmpty());  // ASSERT that we got back a non-empty description.

    }
}
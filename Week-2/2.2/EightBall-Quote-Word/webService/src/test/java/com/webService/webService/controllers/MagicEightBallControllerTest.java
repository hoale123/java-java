package com.webService.webService.controllers;

import com.webService.webService.controllers.MagicEightBallController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.Assert.*;
//engine spring thing
@RunWith(SpringRunner.class)
//run a test on the magicEightBallController
@WebMvcTest(MagicEightBallController.class)
public class MagicEightBallControllerTest {

    //with null there no null ->
    @Autowired
    //return null
    private MockMvc mockMvc;

    //Object to JSON
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() {

    }

    @Test
    public void shouldReturnRandomQuote() throws Exception {
        // Arrange
        //perform is to call an endpoint
        mockMvc.perform(get("/magicEightBall"))
                .andDo(print())// to print out in console all the information
                .andExpect(status().isOk())//                          // ASSERT that we got 200 OK.
                .andExpect(jsonPath("$.question").isNotEmpty())         // ASSERT that we got back a non-empty question.
                .andExpect(jsonPath("$.answer").isNotEmpty())           // ASSERT that we got back a non-empty answer.
                .andExpect(jsonPath("$.id").isNotEmpty());  // ASSERT that we got back a non-empty id.
        //look through the property and see if it exists

    }
}
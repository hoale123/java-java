package com.company.EchoRangeService.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@RunWith(SpringRunner.class)
@WebMvcTest(EchoRangeServiceController.class)
public class EchoRangeServiceControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldEchoInputInValidRange() throws Exception {
        // Arrange - not necessary
        // Act
        mockMvc.perform(get("/echo/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("1"));    // Assert
    }

    @Test
    public void shouldRespondWithUnprocessableEntityWhenInputIsOutOfRange() throws Exception {
        // Arrange - not necessary
        // Act
        mockMvc.perform(get("/echo/12"))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());  // Assert
    }

    @Test
    public void shouldRespondWithNotAcceptableWhenInputIsFive() throws Exception {
        mockMvc.perform(get("/echo/5"))         // Act
                .andDo(print())
                .andExpect(status().isNotAcceptable());   // Assert
    }

}
package com.trilogyed.config.controller;

import com.trilogyed.config.util.feign.QuoteClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloCloudServiceController.class)
public class HelloCloudServiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuoteClient quoteClient;

    @Before
    public void setUp() {
        when(quoteClient.getRandomQuote()).thenReturn("NEVERMORE!!!");
    }

    @Test
    public void shouldReturn200WhenRequestingAQuote() throws Exception {
        // Arrange
        String expectedResult = "Here's your quote: NEVERMORE!!!";

        // Act
        mockMvc.perform(get("/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResult));
    }
}
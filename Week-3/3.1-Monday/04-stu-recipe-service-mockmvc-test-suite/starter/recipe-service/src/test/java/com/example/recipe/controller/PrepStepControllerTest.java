package com.example.recipe.controller;

import com.example.recipe.CorsConfig;
import com.example.recipe.model.PrepStep;
import com.example.recipe.repository.PrepStepRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RestController
@RunWith(SpringRunner.class)
@WebMvcTest(PrepStepController.class)
public class PrepStepControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean// dont want the real one.
    private PrepStepRepository repo;

    ObjectMapper mapper = new ObjectMapper();


    @Test
    public void ShouldReturnPrepStepById() throws Exception{
        PrepStep prepStep1 = new PrepStep();
        prepStep1.setPrepStepId(1);
        prepStep1.setStepNumber(1);
        prepStep1.setRecipeId(1);
        prepStep1.setPrepStepText("23232");
        List<PrepStep> mockAllPrepTestOutput = new ArrayList<>();
        mockAllPrepTestOutput.add(prepStep1);
        doReturn(Optional.of(prepStep1)).when(repo).findById(1);


        String outputJson = mapper.writeValueAsString(prepStep1);
        mockMvc.perform(get("/prepsteps/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
        //do this thing and return what the method will perform
    }

}
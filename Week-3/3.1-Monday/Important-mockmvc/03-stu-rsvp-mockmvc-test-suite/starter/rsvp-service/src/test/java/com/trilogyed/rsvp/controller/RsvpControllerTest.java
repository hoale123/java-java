package com.trilogyed.rsvp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.rsvp.model.Rsvp;
import com.trilogyed.rsvp.repository.RsvpRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RsvpController.class)
public class RsvpControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RsvpRepository repo;

    private static final int noRsvpId = 13;

    ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() {
        Rsvp mockInput = new Rsvp();
        mockInput.setName("Joe");
        mockInput.setTotalAttending(2);
        mockInput.setId(42);

        Rsvp mockOutput = new Rsvp();
        mockOutput.setName("Joe");
        mockOutput.setTotalAttending(2);
        mockOutput.setId(42);

        Rsvp findByIdOutput = new Rsvp();
        findByIdOutput.setName("Rachel");
        findByIdOutput.setTotalAttending(3);
        findByIdOutput.setId(58);

        List<Rsvp> mockAllRsvpOutput = new ArrayList<>();
        mockAllRsvpOutput.add(mockOutput);
        mockAllRsvpOutput.add(findByIdOutput);

        doReturn(mockOutput).when(repo).save(mockInput);
        doReturn(Optional.of(findByIdOutput)).when(repo).findById(1001);
        doReturn(mockAllRsvpOutput).when(repo).findAll();
        doReturn(Optional.empty()).when(repo).findById(noRsvpId);

    }

    @Test
    public void shouldCreateNewRsvpOnPostRequest() throws Exception {
        Rsvp inputRsvp = new Rsvp();
        inputRsvp.setName("Joe");
        inputRsvp.setTotalAttending(2);
        inputRsvp.setId(42);
        String inputJson = mapper.writeValueAsString(inputRsvp);

        Rsvp outputRsvp = new Rsvp();
        outputRsvp.setName("Joe");
        outputRsvp.setTotalAttending(2);
        outputRsvp.setId(42);
        String outputJson = mapper.writeValueAsString(outputRsvp);

        // should be created status
        mockMvc.perform(post("/rsvps")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldReturnRsvpById() throws Exception {
        // Arrange
        Rsvp outputRsvp = new Rsvp();
        outputRsvp.setName("Rachel");
        outputRsvp.setTotalAttending(3);
        outputRsvp.setId(58);
        String outputJson = mapper.writeValueAsString(outputRsvp);

        // Act
        mockMvc.perform(get("/rsvps/1001"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldBStatusOkForNonExistentRsvpId() throws Exception {
            mockMvc.perform(get("/rsvps/" + noRsvpId))
                    .andDo(print())
                    .andExpect(status().isOk());

    }

    @Test
    public void shouldReturnAllRsvps() throws Exception {
        List<Rsvp> expectedOutputList = new ArrayList<>();
        Rsvp output1 = new Rsvp();
        output1.setName("Joe");
        output1.setTotalAttending(2);
        output1.setId(42);

        Rsvp output2 = new Rsvp();
        output2.setName("Rachel");
        output2.setTotalAttending(3);
        output2.setId(58);
        expectedOutputList.add(output1);
        expectedOutputList.add(output2);

        String outputJson = mapper.writeValueAsString(expectedOutputList);

        mockMvc.perform(get("/rsvps"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldUpdateByIdAndReturn200StatusCode() throws Exception {
        Rsvp outputRsvp = new Rsvp();
        outputRsvp.setName("Dr. Strange");
        outputRsvp.setTotalAttending(-109);
        outputRsvp.setId(58);

        String outputJson = mapper.writeValueAsString(outputRsvp);
        mockMvc.perform(put("/rsvps")
                        .content(outputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteByIdAndReturn200StatusCode() throws Exception {
//        Rsvp outputRsvp = new Rsvp();
//        outputRsvp.setName("Rachel");
//        outputRsvp.setTotalAttending(3);
//        outputRsvp.setId(58);

        // Act
        mockMvc.perform(delete("/rsvps/-1001"))
                .andDo(print())
                .andExpect(status().isOk());

    }

}
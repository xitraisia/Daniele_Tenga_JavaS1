package com.company.Summative.Assessment.controller;

import static org.junit.Assert.*;

import com.company.Summative.Assessment.model.Magic_8_Ball;
import com.company.Summative.Assessment.model.Quote;
import org.springframework.test.context.junit4.SpringRunner;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.xml.bind.annotation.XmlElementRefs;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(Magic_8_BallController.class)
public class Magic_8_BallControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // a List of Records for testing purposes
    private List<Magic_8_Ball> magic;

    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void shouldReturnAllMagic_8_BallInCollection() throws Exception {

        // ARRANGE
        Magic_8_Ball inputMagic = new Magic_8_Ball();
        inputMagic.setId(1);
        inputMagic.setAnswer("2000");


        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(inputMagic);


        // ACT
        mockMvc.perform(
                post("/magic")                                // perform the POST request
                        .content(inputJson)                         // Set the request body
                        .contentType(MediaType.APPLICATION_JSON)    // Tell the server it's in JSON format
        )
                .andDo(print())                                     // print results to console
                .andExpect(status().isCreated());                    // ASSERT (status code is 201)
    }


}
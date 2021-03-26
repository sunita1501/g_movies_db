package com.gmovies;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class GmovieDBIT {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;


    @Test
    public void getmoviesTest()throws Exception{
        mockMvc.perform(get("/movies").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void addMoviesTest()throws Exception{
        MovieDTO movieDTO1 =new MovieDTO("Awesome","Joe");
        MovieDTO movieDTO2 =new MovieDTO("Awesome2","Joe2");
        MovieDTO movieDTO3 =new movieDTO("Awesome3","Joe3");
        mockMvc.perform(post("/movie").content(objectMapper.writeValueAsString(movieDTO1)).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
        mockMvc.perform(post("/movie").content(objectMapper.writeValueAsString(movieDTO2)).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
        mockMvc.perform(post("/movie").content(objectMapper.writeValueAsString(movieDTO3)).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
        mockMvc.perform(get("/movies").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).
                andExpect(jsonPath("[0].title").value("Awesome")).andExpect(jsonPath("length()").value(3));
    }

}

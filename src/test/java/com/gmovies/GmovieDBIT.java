package com.gmovies;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
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
        Movie movie1=new Movie("Awesome","Joe");
        Movie movie2=new Movie("Awesome2","Joe2");
        Movie movie3=new Movie("Awesome3","Joe3");
        mockMvc.perform(post("/movie").content(objectMapper.writeValueAsString(movie1)).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
        mockMvc.perform(post("/movie").content(objectMapper.writeValueAsString(movie2)).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
        mockMvc.perform(post("/movie").content(objectMapper.writeValueAsString(movie3)).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
        mockMvc.perform(get("/movies").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).
                andExpect(jsonPath("[0].title").value("Awesome")).andExpect(jsonPath("length()").value(3));
    }
    @Test
    public void getSpecificMovieTest()throws Exception{
        Movie movie1=new Movie("Awesome","Joe");
        Movie movie2=new Movie("Awesome2","Joe2");
        Movie movie3=new Movie("Awesome3","Joe3");
        mockMvc.perform(post("/movie").content(objectMapper.writeValueAsString(movie1)).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
        mockMvc.perform(post("/movie").content(objectMapper.writeValueAsString(movie2)).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
        mockMvc.perform(post("/movie").content(objectMapper.writeValueAsString(movie3)).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
        mockMvc.perform(get("/movie").queryParam("Awesome2").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).
                andExpect(jsonPath("[0].title").value("Awesome2")).andExpect(jsonPath("length()").value(1));
    }
}

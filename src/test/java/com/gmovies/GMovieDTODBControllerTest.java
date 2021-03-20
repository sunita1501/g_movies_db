package com.gmovies;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GMovieDTODBControllerTest {

    @InjectMocks
    GMovieDBController gMovieDBController;

    @Mock
    GMovieDBService service;


    @Test
    public void gMovieDBIsEmptyTest() {
        assertTrue(gMovieDBController.getMovies().isEmpty());
    }

    @Test
    public void gMovieDBReturnsMovieTest() {
        MovieDTO movieDTO = new MovieDTO("Awesome", "Joe");
        when(service.findByMovieTitle("Awesome")).thenReturn(movieDTO);

        assertEquals(movieDTO, gMovieDBController.getMovieByTitle("Awesome"));
    }

    @Test
    public void gMovieDBretrunAllTest() {
        List<MovieDTO> movieDTOList = new ArrayList<>();
        movieDTOList.add(new MovieDTO("Awesome1", "Joe1"));
        movieDTOList.add(new MovieDTO("Awesome2", "Joe2"));
        movieDTOList.add(new MovieDTO("Awesome3", "Joe3"));

        when(service.fetchAll()).thenReturn(movieDTOList);

        assertEquals(3, gMovieDBController.getMovies().size());
    }


}

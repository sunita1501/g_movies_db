package com.gmovies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GMovieDTODBControllerTest {

    @Test
    public void gMovieDBIsEmptyTest() {
        GMovieDBController gMovieDBController = new GMovieDBController();

        assertTrue(gMovieDBController.getMovies().isEmpty());
    }

    @Test
    public void gMovieDBReturnsMovieTest() {
        GMovieDBController gMovieDBController = new GMovieDBController();

        gMovieDBController.addMovie(new MovieDTO("Awesome","Joe"));
        assertEquals("Awesome", gMovieDBController.getMovies().get(0).title);
    }

    @Test
    public void gMovieDBretrunAllTest() {
        GMovieDBController gMovieDBController = new GMovieDBController();
        gMovieDBController.addMovie(new MovieDTO("Awesome","Joe"));
        gMovieDBController.addMovie(new MovieDTO("Awesome","Joe"));
        gMovieDBController.addMovie(new MovieDTO("Awesome","Joe"));

        assertEquals(3, gMovieDBController.getMovies().size());
    }


}

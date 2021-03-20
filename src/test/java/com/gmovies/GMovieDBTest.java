package com.gmovies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GMovieDBTest {

    @Test
    public void gMovieDBIsEmptyTest() {
        GMovieDB gMovieDB = new GMovieDB();

        assertTrue(gMovieDB.getMovies().isEmpty());
    }

    @Test
    public void gMovieDBReturnsMovieTest() {
        GMovieDB gMovieDB = new GMovieDB();

        gMovieDB.addMovie(new Movie("Awesome","Joe"));
        assertEquals("Awesome",gMovieDB.getMovies().get(0).title);
    }

    @Test
    public void gMovieDBretrunAllTest() {
        GMovieDB gMovieDB = new GMovieDB();
        gMovieDB.addMovie(new Movie("Awesome","Joe"));
        gMovieDB.addMovie(new Movie("Awesome","Joe"));
        gMovieDB.addMovie(new Movie("Awesome","Joe"));

        assertEquals(3,gMovieDB.getMovies().size());
    }


}

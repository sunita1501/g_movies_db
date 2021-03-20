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
       
        gMovieDB.addMovie("movie1");
        assertEquals("movie1",gMovieDB.getMovies().get(0));
    }

    @Test
    public void gMovieDBretrunAllTest() {
        GMovieDB gMovieDB = new GMovieDB();
        gMovieDB.addMovie("movie1");
        gMovieDB.addMovie("movie2");
        gMovieDB.addMovie("movie3");

        assertEquals(3,gMovieDB.getMovies().size());
    }


}

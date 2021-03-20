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
        gMovieDB.movieList.add("movie1");

        assertEquals(gMovieDB.getMovies().get(0), "movie1");
    }

    @Test
    public void gMovieDBretrunAllTest() {
        GMovieDB gMovieDB = new GMovieDB();
        gMovieDB.movieList.add("movie1");
        gMovieDB.movieList.add("movie2");
        gMovieDB.movieList.add("movie3");

        assertEquals(3,gMovieDB.getMovies().size());
    }


}

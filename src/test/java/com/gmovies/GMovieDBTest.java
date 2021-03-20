package com.gmovies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GMovieDBTest {

    @Test
    public void gMovieDBIsEmptyTest() {
        GMovieDB gMovieDB = new GMovieDB();

        assertNull(gMovieDB.getMovies());
    }

    @Test
    public void gMovieDBReturnsMovieTest() {
        GMovieDB gMovieDB = new GMovieDB();
        gMovieDB.movie = "movie";

        assertEquals(gMovieDB.getMovies(), "movie");
    }

    @Test
    public void gMovieDBretrunAllTest() {
        GMovieDB gMovieDB = new GMovieDB();
        gMovieDB.movie = "movie";

        assertEquals(3,gMovieDB.getMovies().size());
    }


}

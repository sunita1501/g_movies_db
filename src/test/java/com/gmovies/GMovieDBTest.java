package com.gmovies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class GMovieDBTest {

    @Test
    public void gMovieDBIsEmptyTest() {
        GMovieDB gMovieDB = new GMovieDB();

        assertNull(gMovieDB.getMovies());
    }

}

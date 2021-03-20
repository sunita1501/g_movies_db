package com.gmovies;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class GMovieDB {

    List<String> movieList = new ArrayList<String>();

@GetMapping("movies")
    public List<String> getMovies() {


        return movieList;
    }
}

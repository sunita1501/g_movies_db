package com.gmovies;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class GMovieDB {

    List<String> movieList = new ArrayList<String>();

@GetMapping("movies")
    public List<String> getMovies() {


        return movieList;
    }

    @PostMapping("movie")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMovie(@RequestBody String movieName) {


         movieList.add(movieName);
    }
}

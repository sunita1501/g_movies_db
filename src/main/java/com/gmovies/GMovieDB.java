package com.gmovies;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class GMovieDB {

    List<Movie> movieList = new ArrayList<Movie>();

@GetMapping("movies")
    public List<Movie> getMovies() {


        return movieList;
    }

    @PostMapping("movie")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMovie(@RequestBody Movie movieName) {


         movieList.add(movieName);
    }

    @GetMapping("movie/{name}")
    public Movie getMovies(@PathVariable String name) {

        for (Movie m:movieList )
        {
            if (name.equals(m.title)){
                return m;
            }

        }

        return null;
    }
}

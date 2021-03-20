package com.gmovies;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class GMovieDBController {

    List<MovieDTO> movieDTOList = new ArrayList<MovieDTO>();

@GetMapping("movies")
    public List<MovieDTO> getMovies() {


        return movieDTOList;
    }

    @PostMapping("movie")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMovie(@RequestBody MovieDTO movieDTOName) {


         movieDTOList.add(movieDTOName);
    }

    @GetMapping("movie/{name}")
    public MovieDTO getMovies(@PathVariable String name) {

        for (MovieDTO m: movieDTOList)
        {
            if (name.equals(m.title)){
                return m;
            }

        }

        return null;
    }
}

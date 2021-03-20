package com.gmovies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class GMovieDBController {

    GMovieDBService gMovieDBService;

    @Autowired
    public GMovieDBController(GMovieDBService gMovieDBService) {
        this.gMovieDBService = gMovieDBService;
    }

    @GetMapping("movies")
    public List<MovieDTO> getMovies() {
        return gMovieDBService.fetchAll();
    }

    @PostMapping("movie")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMovie(@RequestBody MovieDTO movie) {
        gMovieDBService.saveMovie(movie);
    }

    @GetMapping("movie/{name}")
    public MovieDTO getMovieByTitle(@PathVariable String name) {
        return gMovieDBService.findByMovieTitle(name);
    }
}

package com.gmovies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GMovieDBService {

    private final GMovieDBRepository gMovieDBRepository;

    @Autowired
    public GMovieDBService(GMovieDBRepository gMovieDBRepository) {
        this.gMovieDBRepository = gMovieDBRepository;
    }

    public void saveMovie(MovieDTO movieDTO) {
        gMovieDBRepository.save(new MovieEntity(movieDTO.title, movieDTO.director));
    }
}

package com.gmovies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<MovieDTO> fetchAll() {
        return gMovieDBRepository.findAll().stream().map(movieEntity ->
                new MovieDTO(movieEntity.title, movieEntity.director)
        ).collect(Collectors.toList());

    }
}

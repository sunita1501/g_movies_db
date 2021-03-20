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
        gMovieDBRepository.save(new MovieEntity(movieDTO.title, movieDTO.director,movieDTO.rating,movieDTO.actors,movieDTO.release_year,movieDTO.description));
    }

    public List<MovieDTO> fetchAll() {
        return gMovieDBRepository.findAll().stream().map(movieEntity ->
                new MovieDTO(movieEntity.title, movieEntity.director,movieEntity.rating,movieEntity.actors,movieEntity.release_year, movieEntity.description)
        ).collect(Collectors.toList());

    }

    public MovieDTO findByMovieTitle(String movieTitle) {
        MovieEntity movieEntity = gMovieDBRepository.findByTitle(movieTitle);
        if(movieEntity== null){
            return null;
        }
        return new MovieDTO(movieEntity.title, movieEntity.director,movieEntity.rating,movieEntity.actors, movieEntity.release_year,movieEntity.description);

    }
}

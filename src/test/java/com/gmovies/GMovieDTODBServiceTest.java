package com.gmovies;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class GMovieDTODBServiceTest {

    @Mock
    GMovieDBRepository repository;

    @InjectMocks
    GMovieDBService service;


    @Test
    public void serviceSaveMovieToDB() {
        MovieDTO movieDTO = new MovieDTO("Awesome", "Joe");
        service.saveMovie(movieDTO);

        verify(repository).save(new MovieEntity("Awesome", "Joe"));
    }

}

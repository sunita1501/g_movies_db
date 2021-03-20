package com.gmovies;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @Test
    public void serviceFindAllFromDB() {
        MovieEntity movieEntity = new MovieEntity("Awesome", "Joe");

        when(repository.findAll()).thenReturn(Collections.singletonList(movieEntity));

        List<MovieDTO> movieDTOList = service.fetchAll();

        verify(repository).findAll();
        assertEquals(movieDTOList.get(0).title,  "Awesome");
    }

}

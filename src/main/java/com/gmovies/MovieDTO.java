package com.gmovies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class MovieDTO {
    String title;
    String director;
    int rating;
    List<String> actors;
    int release_year;
    String description;



    public MovieDTO(String title, String director) {
        this.title = title;
        this.director = director;
    }

    public MovieDTO(String title, String director, int rating) {
        this.title = title;
        this.director = director;
        this.rating = rating;
    }
}

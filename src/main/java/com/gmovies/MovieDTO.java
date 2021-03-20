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


    public MovieDTO(String title, String director) {
        this.title = title;
        this.director = director;
    }
}

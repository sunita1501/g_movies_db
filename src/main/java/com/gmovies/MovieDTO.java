package com.gmovies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

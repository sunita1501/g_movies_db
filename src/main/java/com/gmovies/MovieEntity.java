package com.gmovies;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String title;
    String director;
    int rating;
    @ElementCollection
    List<String> actors;
    int release_year;
    String description;

    public MovieEntity(String title, String director, int rating,List<String> actors, int year,String des) {
        this.title = title;
        this.director = director;
        this.rating=rating;
        this.release_year=year;
        this.actors=actors;
        this.description=des;
    }

    public MovieEntity(String title, String director) {
        this.title = title;
        this.director = director;
    }
}

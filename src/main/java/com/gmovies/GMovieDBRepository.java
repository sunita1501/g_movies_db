package com.gmovies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GMovieDBRepository extends JpaRepository<MovieEntity, Long> {



}

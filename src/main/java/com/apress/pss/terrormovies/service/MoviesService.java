package com.apress.pss.terrormovies.service;

import com.apress.pss.terrormovies.model.Movie;

import java.util.Collection;
import java.util.List;

public interface MoviesService {
    Movie getMovieByName(String name);

    void addNewMovies(List<String> movies);

    Collection<Movie> getAllMovies();
}
package com.apress.pss.terrormovies.service;

import com.apress.pss.terrormovies.model.Movie;

public interface MoviesService {
    Movie getMovieByName(String name);
}
package com.apress.pss.terrormovies.service;

import com.apress.pss.terrormovies.model.Movie;
import org.springframework.security.access.prepost.PostAuthorize;

import java.util.HashMap;
import java.util.Map;

public class MoviesServiceImpl implements MoviesService {

    private static final Map<String, Movie> MOVIES = new HashMap<String, Movie>();

    static {
        MOVIES.put("die hard", new Movie("Die Hard", "20000000"));
        MOVIES.put("two days in paris", new Movie("two days in paris ", "1000000"));
    }

    @PostAuthorize("T(java.lang.Integer).parseInt(getReturnObject().budget) < 5000000")
    public Movie getMovieByName(String name) {
        return MOVIES.get(name.toLowerCase());
    }

}
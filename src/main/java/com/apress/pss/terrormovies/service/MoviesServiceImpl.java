package com.apress.pss.terrormovies.service;

import com.apress.pss.terrormovies.model.Movie;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.HashMap;
import java.util.Map;

public class MoviesServiceImpl implements MoviesService {

    private static final Map<String, Movie> MOVIES = new HashMap<String, Movie>();

    static {
        MOVIES.put("die hard", new Movie("Die Hard", "20000000"));
    }

    @PreAuthorize("#name.length() < 50 and hasRole('ROLE_USER')")
    public Movie getMovieByName(String name) {
        return MOVIES.get(name.toLowerCase());
    }

}
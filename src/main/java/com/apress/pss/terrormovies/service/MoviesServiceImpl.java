package com.apress.pss.terrormovies.service;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.security.RolesAllowed;

import org.springframework.security.access.annotation.Secured;

import com.apress.pss.terrormovies.model.Movie;

public class MoviesServiceImpl implements MoviesService {

    private static final Map<String, Movie> MOVIES = new HashMap<String, Movie>();

    static {
        MOVIES.put("die hard", new Movie("Die Hard", "20000000"));
    }

    @RolesAllowed("ROLE_USER")
    public Movie getMovieByName(String name) {
        return MOVIES.get(name.toLowerCase());
    }

}
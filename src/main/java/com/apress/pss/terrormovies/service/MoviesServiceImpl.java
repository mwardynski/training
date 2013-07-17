package com.apress.pss.terrormovies.service;

import com.apress.pss.terrormovies.model.Movie;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;

import java.util.*;

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

    public void addNewMovies(List<String> movies) {
        for (String movie : movies) {
            MOVIES.put(movie, new Movie(movie, "10000"));
        }
    }

    public Collection<Movie> getAllMovies() {
        return new ArrayList<Movie>(MOVIES.values());
    }

}
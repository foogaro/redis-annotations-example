package com.foogaro.data.example.services;

import com.foogaro.data.example.models.Movie;
import com.foogaro.data.example.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public List<Movie> byTitle(String title) {
        return repository.byTitle(title);
    }

    public List<Movie> byRating(long rating) {
        return repository.byRating(rating);
    }

    public List<Movie> byYear(int year) {
        return repository.byYear(year);
    }

}

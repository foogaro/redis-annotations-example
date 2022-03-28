package com.foogaro.data.example.repositories;

import com.foogaro.data.example.models.Movie;
import com.foogaro.data.redisframework.annotations.DataStore;
import com.foogaro.data.redisframework.annotations.search.Query;
import com.foogaro.data.redisframework.annotations.search.Search;

import java.util.List;

@DataStore
public interface MovieRepository {

    @Search(query = @Query("@title:({{title}})"))
    public List<Movie> byTitle(String title);
    @Search(query = @Query("@rating:({{rating}})"))
    public List<Movie> byRating(long rating);
    @Search(query = @Query("@year:({{year}})"))
    public List<Movie> byYear(int year);

}

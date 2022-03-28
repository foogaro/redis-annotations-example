package com.foogaro.data.example.models;

import com.foogaro.data.redisframework.annotations.json.RedisJSON;
import com.foogaro.data.redisframework.annotations.search.Index;
import com.foogaro.data.redisframework.annotations.search.Numeric;
import com.foogaro.data.redisframework.annotations.search.Text;
import com.foogaro.data.redisframework.model.FTSIndexStrategy;
import com.foogaro.data.redisframework.model.KeyValueModel;

@RedisJSON(index = @Index(name = "ix-movies", indexStrategy = FTSIndexStrategy.NONE, prefix = "movies:"))
public class Movie implements KeyValueModel {

    private long id;
    @Text(sortable = true)
    private String title;
    @Numeric(sortable = true)
    private int rating;
    @Numeric
    private int year;

    public Movie() {
    }

    public Movie(String title, int rating, int year) {
        this.title = title;
        this.rating = rating;
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = Long.parseLong(id.substring(id.lastIndexOf(':')+1));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", year=" + year +
                '}';
    }
}

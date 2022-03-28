package com.foogaro.data.example.repositories;

import com.foogaro.data.example.models.Actor;
import com.foogaro.data.redisframework.annotations.DataStore;
import com.foogaro.data.redisframework.annotations.search.Query;
import com.foogaro.data.redisframework.annotations.search.Search;

import java.util.List;

@DataStore
public interface ActorRepository {

    @Search(query = @Query("@firstname:({{firstname}})"))
    public List<Actor> byFirstname(String firstname);
    @Search(query = @Query("@lastname:({{lastname}})"))
    public List<Actor> byLastname(String lastname);
    @Search(query = @Query("@yearOfBirth:({{yearOfBirth}})"))
    public List<Actor> byYearOfBirth(int yearOfBirth);

}

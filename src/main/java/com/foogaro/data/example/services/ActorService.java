package com.foogaro.data.example.services;

import com.foogaro.data.example.models.Actor;
import com.foogaro.data.example.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    @Autowired
    private ActorRepository repository;

    public List<Actor> byFirstname(String firstname) {
        return repository.byFirstname(firstname);
    }

    public List<Actor> byLastname(String lastname) {
        return repository.byLastname(lastname);
    }

    public List<Actor> byYearOfBirth(int yearOfBirth) {
        return repository.byYearOfBirth(yearOfBirth);
    }

}

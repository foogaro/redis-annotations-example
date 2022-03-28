package com.foogaro.data.example.models;

import com.foogaro.data.redisframework.annotations.json.RedisJSON;
import com.foogaro.data.redisframework.annotations.search.Index;
import com.foogaro.data.redisframework.annotations.search.Numeric;
import com.foogaro.data.redisframework.annotations.search.Text;
import com.foogaro.data.redisframework.model.FTSIndexStrategy;
import com.foogaro.data.redisframework.model.KeyValueModel;

@RedisJSON(index = @Index(name = "ix-actors", indexStrategy = FTSIndexStrategy.NONE, prefix = "actors:"))
public class Actor implements KeyValueModel {

    private long id;
    @Text
    private String firstname;
    @Text
    private String lastname;
    @Numeric(sortable = true)
    private int yearOfBirth;

    public Actor() {
    }

    public Actor(String firstname, String lastname, int yearOfBirth) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.yearOfBirth = yearOfBirth;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }
}

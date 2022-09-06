package com.example.Test.repositories;

import com.example.Test.models.Games;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GamesRepository extends CrudRepository<Games,Long> {

    public List<Games> findByName(String name);
    public List<Games> findByNameContains(String name);
}

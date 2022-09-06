package com.example.Test.repositories;

import com.example.Test.models.CarsMarket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarsMarketRepository extends CrudRepository<CarsMarket, Long> {

    public List<CarsMarket> findByName(String name);
    public List<CarsMarket> findByNameContains(String name);
}

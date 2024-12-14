package com.example.restaurant.demo.Repos;

import com.example.restaurant.demo.models.Burger;
import com.example.restaurant.demo.models.Pizza;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PizzaRepo extends JpaRepository<Pizza,Integer> {
    Optional<Pizza> findByName(@NonNull String name);

}

package com.example.restaurant.demo.Repos;

import com.example.restaurant.demo.models.Burger;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BurgerRepo extends JpaRepository<Burger, Integer> {

    Optional<Burger> findByName(@NonNull String name);
}

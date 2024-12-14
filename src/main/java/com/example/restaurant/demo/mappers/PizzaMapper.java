package com.example.restaurant.demo.mappers;

import com.example.restaurant.demo.Repos.PizzaRepo;
import com.example.restaurant.demo.dtos.requestDtos.PizzaRequestDTO;
import com.example.restaurant.demo.dtos.responseDtos.PizzaResponseDTO;
import com.example.restaurant.demo.models.Pizza;

public class PizzaMapper {
    public static PizzaResponseDTO toResponseDTO(Pizza pizza) {
        return new PizzaResponseDTO(pizza.getName(), pizza.getDescription(), pizza.getPrice(), pizza.getSize());
    }

    public static Pizza toEntity(PizzaRequestDTO pizzaRequestDTO) {
        return new Pizza(pizzaRequestDTO.getName(), pizzaRequestDTO.getDescription(), pizzaRequestDTO.getPrice(), pizzaRequestDTO.getSize());
    }
}

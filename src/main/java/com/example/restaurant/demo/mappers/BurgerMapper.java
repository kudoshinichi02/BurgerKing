package com.example.restaurant.demo.mappers;

import com.example.restaurant.demo.dtos.requestDtos.BurgerRequestDTO;
import com.example.restaurant.demo.dtos.responseDtos.BurgerResponseDTO;
import com.example.restaurant.demo.models.Burger;

public class BurgerMapper {
    public static BurgerResponseDTO toDTO(Burger burger){
        return new BurgerResponseDTO(burger.getId(),burger.getName(),burger.getPrice());
    }
    public static Burger toEntity(BurgerRequestDTO burgerRequestDTO){
        return new Burger(burgerRequestDTO.getName(),burgerRequestDTO.getPrice(),burgerRequestDTO.getDescription());
    }
}

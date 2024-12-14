package com.example.restaurant.demo.dtos.responseDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BurgerResponseDTO {
    private Integer id;
    private String name;
    private Double price;
}

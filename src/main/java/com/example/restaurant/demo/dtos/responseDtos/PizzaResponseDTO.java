package com.example.restaurant.demo.dtos.responseDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class PizzaResponseDTO {
    private String name;
    private String description;
    private Integer price;
    private Integer size;
}

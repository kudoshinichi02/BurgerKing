package com.example.restaurant.demo.dtos.requestDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BurgerRequestDTO {
    private String name;
    private Double price;
    private String description;
}

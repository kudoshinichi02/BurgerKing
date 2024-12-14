package com.example.restaurant.demo.dtos.requestDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PizzaRequestDTO {
    private String name;
    private String description;
    private Integer price;
    private Integer size;
}

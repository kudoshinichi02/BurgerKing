package com.example.restaurant.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PIZZA")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private Integer price;
    @NonNull
    private Integer size;
}

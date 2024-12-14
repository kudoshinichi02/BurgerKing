package com.example.restaurant.demo.Controllers;

import com.example.restaurant.demo.Services.PizzaService;
import com.example.restaurant.demo.dtos.requestDtos.PizzaRequestDTO;
import com.example.restaurant.demo.dtos.responseDtos.PizzaResponseDTO;
import com.example.restaurant.demo.models.Pizza;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizza")
public class PizzaController {
    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PizzaResponseDTO>> getAllPizza() {
        return new ResponseEntity<>(pizzaService.getAll() , HttpStatus.OK);
    }

    @PostMapping("/add-pizza")
    public ResponseEntity<PizzaResponseDTO> addPizza(@RequestBody PizzaRequestDTO pizzaRequestDTO) {
        return new ResponseEntity<>(pizzaService.addPizza(pizzaRequestDTO),HttpStatus.CREATED);
    }

    @PutMapping("/update-pizza")
    public ResponseEntity<PizzaResponseDTO> updatePizza(@RequestBody PizzaRequestDTO pizzaRequestDTO) {
        return new ResponseEntity<>(pizzaService.updatePizza(pizzaRequestDTO) , HttpStatus.OK);
    }

    @DeleteMapping("/delete-pizza/{id}")
    public ResponseEntity<PizzaResponseDTO> deletePizza(@PathVariable Integer id) {
        pizzaService.deletePizza(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.example.restaurant.demo.Controllers;

import com.example.restaurant.demo.Services.BurgerService;
import com.example.restaurant.demo.dtos.requestDtos.BurgerRequestDTO;
import com.example.restaurant.demo.dtos.responseDtos.BurgerResponseDTO;
import com.example.restaurant.demo.models.Burger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/burger")
public class BurgerController {
    private final BurgerService burgerService;

    public BurgerController(BurgerService burgerService) {
        this.burgerService = burgerService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<BurgerResponseDTO>> getAllBurgers() {
        return new ResponseEntity<>(burgerService.getAll() , HttpStatus.OK);
    }

    @PostMapping("/addBurger")
    public ResponseEntity<BurgerResponseDTO> addBurger(@RequestBody BurgerRequestDTO burgerRequestDTO) {
        return new ResponseEntity<>(burgerService.addBurger(burgerRequestDTO) , HttpStatus.CREATED);
    }

    @PutMapping("/update burger")
    public ResponseEntity<BurgerResponseDTO> updateBurger(@RequestBody BurgerRequestDTO burgerRequestDTO) {
        return new ResponseEntity<>(burgerService.updateBurger(burgerRequestDTO) , HttpStatus.OK);
    }

    @DeleteMapping("/delete-burger/{id}")
    public ResponseEntity<Burger> deleteBurger(@PathVariable Integer id) {
        burgerService.deleteBurger(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.example.restaurant.demo.Services;

import com.example.restaurant.demo.Repos.PizzaRepo;
import com.example.restaurant.demo.dtos.requestDtos.PizzaRequestDTO;
import com.example.restaurant.demo.dtos.responseDtos.PizzaResponseDTO;
import com.example.restaurant.demo.mappers.PizzaMapper;
import com.example.restaurant.demo.models.Pizza;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {
    private final PizzaRepo pizzaRepo;

    public PizzaService(PizzaRepo pizzaRepo) {
        this.pizzaRepo = pizzaRepo;
    }

    public List<PizzaResponseDTO> getAll(){
        return pizzaRepo.findAll().stream().map(PizzaMapper::toResponseDTO).toList();
    }

    public PizzaResponseDTO addPizza(PizzaRequestDTO pizzaRequestDTO) {
        return PizzaMapper.toResponseDTO(pizzaRepo.save(PizzaMapper.toEntity(pizzaRequestDTO)));
    }

    public PizzaResponseDTO updatePizza(PizzaRequestDTO pizzaRequestDTO) {
        Optional<Pizza> pizzaToUpdateOptional = pizzaRepo.findByName(PizzaMapper.toEntity(pizzaRequestDTO).getName());

        if(pizzaToUpdateOptional.isEmpty())
            return null;
        Pizza pizzaToUpdate = pizzaToUpdateOptional.get();

        pizzaToUpdate.setName(pizzaRequestDTO.getName());
        pizzaToUpdate.setDescription(pizzaRequestDTO.getDescription());
        pizzaToUpdate.setPrice(pizzaRequestDTO.getPrice());
        pizzaToUpdate.setSize(pizzaRequestDTO.getSize());

        return PizzaMapper.toResponseDTO(pizzaRepo.save(pizzaToUpdate));
    }

    public void deletePizza(Integer id) {
        Optional<Pizza> pizzaToDeleteOptional = pizzaRepo.findById(id);

        if (pizzaToDeleteOptional.isPresent())
            pizzaRepo.deleteById(id);

    }
}

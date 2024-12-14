package com.example.restaurant.demo.Services;

import com.example.restaurant.demo.Repos.BurgerRepo;
import com.example.restaurant.demo.dtos.requestDtos.BurgerRequestDTO;
import com.example.restaurant.demo.dtos.responseDtos.BurgerResponseDTO;
import com.example.restaurant.demo.mappers.BurgerMapper;
import com.example.restaurant.demo.models.Burger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BurgerService {
    private final BurgerRepo burgerRepo;

    public BurgerService(BurgerRepo burgerRepo) {
        this.burgerRepo = burgerRepo;
    }

    public List<BurgerResponseDTO> getAll() {
        return burgerRepo.findAll().stream()
                .map(BurgerMapper::toDTO).toList();
    }

    public BurgerResponseDTO addBurger(BurgerRequestDTO burgerRequestDTO) {
        return BurgerMapper.toDTO(burgerRepo.save(BurgerMapper.toEntity(burgerRequestDTO)));
    }

    public BurgerResponseDTO updateBurger(BurgerRequestDTO burgerRequestDTO) {
       Optional<Burger> burgerToUpdateOptional = burgerRepo.findByName(BurgerMapper.toEntity(burgerRequestDTO).getName());

       if (burgerToUpdateOptional.isEmpty()) {
           return null;
       }

       Burger burgerToUpdate = burgerToUpdateOptional.get();

       burgerToUpdate.setName(burgerRequestDTO.getName());
       burgerToUpdate.setPrice(burgerRequestDTO.getPrice());
       burgerToUpdate.setDescription(burgerRequestDTO.getDescription());

       return BurgerMapper.toDTO(burgerRepo.save(burgerToUpdate));
    }

    public void deleteBurger(Integer id) {
        Optional<Burger> burgerToDeleteOptional = burgerRepo.findById(id);

        if (burgerToDeleteOptional.isPresent()) {
            burgerRepo.deleteById(id);
        }
    }
}

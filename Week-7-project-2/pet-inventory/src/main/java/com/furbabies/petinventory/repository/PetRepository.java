package com.furbabies.petinventory.repository;

import com.furbabies.petinventory.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetReository extends JpaRepository<String, Pet> {
}

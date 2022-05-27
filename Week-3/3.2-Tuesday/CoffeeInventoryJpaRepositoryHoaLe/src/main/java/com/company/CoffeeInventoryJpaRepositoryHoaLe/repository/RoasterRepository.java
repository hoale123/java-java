package com.company.CoffeeInventoryJpaRepositoryHoaLe.repository;

import com.company.CoffeeInventoryJpaRepositoryHoaLe.dto.Roaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoasterRepository extends JpaRepository<Roaster,Integer> {
}

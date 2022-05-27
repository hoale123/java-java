package com.company.CoffeeInventoryJpaRepositoryHoaLe.repository;

import com.company.CoffeeInventoryJpaRepositoryHoaLe.dto.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoffeeRepository extends JpaRepository<Coffee,Integer> {

    List<Coffee> findByType(String type);

    List<Coffee> findByRoasterId(Integer roasterId);

    List<Coffee> findByTypeAndRoasterId(String type, Integer roasterId);
}

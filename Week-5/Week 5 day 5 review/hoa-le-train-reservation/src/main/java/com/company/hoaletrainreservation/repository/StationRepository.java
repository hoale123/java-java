package com.company.hoaletrainreservation.repository;

import com.company.hoaletrainreservation.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station,Integer> {
}

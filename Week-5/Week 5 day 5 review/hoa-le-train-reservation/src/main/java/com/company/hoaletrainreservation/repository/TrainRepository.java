package com.company.hoaletrainreservation.repository;

import com.company.hoaletrainreservation.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train,Integer> {
}

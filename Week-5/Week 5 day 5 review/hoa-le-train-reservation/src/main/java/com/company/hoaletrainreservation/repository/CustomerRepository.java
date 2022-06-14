package com.company.hoaletrainreservation.repository;

import com.company.hoaletrainreservation.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}

package com.company.simplecrmapi.repository;

import com.company.simplecrmapi.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository// when spring start up, make something with this type.
                                        // the primary key is integer ,
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findByCompany(String company);

    List<Customer> findByLastName(String lastName);


    List<Customer> findByCompanyAndLastName(String company, String lastName);
}

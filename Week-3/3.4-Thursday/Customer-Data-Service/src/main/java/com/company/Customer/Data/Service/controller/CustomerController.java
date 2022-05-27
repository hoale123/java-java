package com.company.Customer.Data.Service.controller;

import com.company.Customer.Data.Service.dto.Customer;
import com.company.Customer.Data.Service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomer(@RequestParam(required = false) String state,@RequestParam(required = false) String level){
        if (state != null){
            return customerRepository.findByState(state);
        }
        if (level == "Gold" || level == "Silver" || level == "Bronze" ){
            return customerRepository.findByLevel(level);
        }
        return customerRepository.findAll();
    }

    @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Optional<Customer> getCustomerById(@PathVariable int customerId ){
        return customerRepository.findById(customerId);
    }
    @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  updateCustomerById(@PathVariable int customerId, @RequestBody Customer customer){
        if (customer.getId() == null){
            customer.setId(customerId);
        }
        if (customerId != customer.getId()){
            throw new DataIntegrityViolationException("Id don't match");
        }
        customerRepository.save(customer);

    }
    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }
    @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int customerId){
        customerRepository.deleteById(customerId);
    }

}

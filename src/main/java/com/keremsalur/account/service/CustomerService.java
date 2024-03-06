package com.keremsalur.account.service;

import com.keremsalur.account.dto.CustomerDto;
import com.keremsalur.account.dto.CustomerDtoConverter;
import com.keremsalur.account.exception.CustomerNotFoundException;
import com.keremsalur.account.model.Customer;
import com.keremsalur.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter converter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter converter) {
        this.customerRepository = customerRepository;
        this.converter = converter;
    }

    protected Customer findCustomerById(String id){
        return customerRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("Customer could not found by id : " + id));
    }

    public CustomerDto getCustomerById(String customerId) {
        return converter.convertToCustomerDto(findCustomerById(customerId));
    }
}

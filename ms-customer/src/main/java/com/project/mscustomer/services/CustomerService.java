package com.project.mscustomer.services;

import com.project.mscustomer.entities.Customer;
import com.project.mscustomer.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional(readOnly = true)
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer newCustomer(Customer customerRequest) {
        Customer customer = Customer.builder()
                .fullName(customerRequest.getFullName())
                .age(customerRequest.getAge())
                .phoneNumber(customerRequest.getPhoneNumber())
                .address(customerRequest.getAddress())
                .build();

        return customerRepository.save(customer);
    }

    @Transactional(readOnly = true)
    public Customer findCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).get();
        return customer;
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Transactional
    public Customer updateCustomer(Long id, Customer object) {
        Customer entity = customerRepository.findById(id).get();
        copyObjectToEntity(object, entity);
        return customerRepository.save(entity);
    }

    private void copyObjectToEntity(Customer object, Customer entity) {
        entity.setFullName(object.getFullName());
        entity.setAge(object.getAge());
        entity.setPhoneNumber(object.getPhoneNumber());
        entity.setAddress(object.getAddress());
    }
}

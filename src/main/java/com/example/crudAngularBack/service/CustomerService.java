package com.example.crudAngularBack.service;

import com.example.crudAngularBack.interfaceService.ICustomerService;
import com.example.crudAngularBack.interfaces.CustomerRepository;
import com.example.crudAngularBack.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository data;

    @Override
    public List<Customer> listar() {
        return (List<Customer>) data.findAll();
    }

    @Override
    public Customer listarId(int id) {

        Optional<Customer> customerRes= data.findById(id);
        Customer customer = null;

        if(customerRes.isPresent()) {
            customer = customerRes.get();
        }else {
            throw new RuntimeException("No existe el : "+id);
        }
        return customer;
    }

    @Override
    public Customer save(Customer customer) {
        return data.save(customer);
    }

    @Override
    public void delete(int id) {

            data.deleteById(id);

    }
}

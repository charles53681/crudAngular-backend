package com.example.crudAngularBack.interfaceService;


import com.example.crudAngularBack.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> listar();
    Customer listarId(int id);
    Customer save(Customer c);
    void delete(int id);
}

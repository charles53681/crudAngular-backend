package com.example.crudAngularBack.interfaces;

import com.example.crudAngularBack.model.Customer;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer,Integer> {

}

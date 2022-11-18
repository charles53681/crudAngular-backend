package com.example.crudAngularBack.controler;

import com.example.crudAngularBack.model.Customer;
import com.example.crudAngularBack.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
@CrossOrigin(origins = "http://localhost:4200")
public class Controlador {


    @Autowired
    private CustomerService service;
    @GetMapping(value = "/all")
    public List<Customer>listar(){
        return service.listar();
    }

    @PostMapping(value = "/add")
    public Customer saveCustomer(@RequestBody Customer customer){
        return service.save(customer);
    }

    @GetMapping(value = "/byId/{id}")
    public Customer listarById(@PathVariable Integer id){

        return service.listarId(id);
    }

    @PutMapping(value = "/update/{id}")
    public Customer updateCustomer(@PathVariable Integer id, @RequestBody Customer detallesCustomer){
        Customer editCustomer =service.listarId(id);

        editCustomer.setCompanyName(detallesCustomer.getCompanyName());
        editCustomer.setContactName(detallesCustomer.getContactName());
        editCustomer.setContactTitle(detallesCustomer.getContactTitle());
        editCustomer.setAddress(detallesCustomer.getAddress());
        editCustomer.setCity(detallesCustomer.getCity());
        editCustomer.setRegion(detallesCustomer.getRegion());
        editCustomer.setPostalCode(detallesCustomer.getPostalCode());
        editCustomer.setCountry(detallesCustomer.getCountry());
        editCustomer.setPhone(detallesCustomer.getPhone());
        editCustomer.setFax(detallesCustomer.getFax());

        Customer customerUpdate= service.save(editCustomer);
        return customerUpdate;
    }

    @DeleteMapping(value="/delete/{id}")
    public void deteleCustomer(@PathVariable Integer id){
        service.delete(id);
    }



}

package com.example.demo.controller;


import com.example.demo.dto.CustomerDTO;
import com.example.demo.service.CustomerService;
import com.example.demo.service.Impl.CustomerServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin

public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.addCustomer(customerDTO);
        return "saved";

    }
    @PutMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerDTO customerDTO) {
        String udpated = customerService.updateCustomer(customerDTO);
        return udpated;
    }

    @GetMapping(
            path = "/get-by-id",
            params = "id" )
            public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId) {
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return customerDTO;
    }

    @GetMapping(path = "/get-all-customers")
    public List<CustomerDTO> getAllCustomers() {
            List<CustomerDTO> allCustomers = customerService.getAllCustomers();
            return allCustomers;
        }

    @DeleteMapping(path = "/delete-customer/{id}")
    public String deleteCustomer(@PathVariable("id") int customerId) {
        String deleted = customerService.deleteCustomer(customerId);
        return deleted;
    }

}

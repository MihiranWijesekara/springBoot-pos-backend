package com.example.demo.service.Impl;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {

  @Autowired
  private CustomerRepo customerRepo;

  @Autowired
   private ModelMapper modelMapper;

  @Override
  public void addCustomer(CustomerDTO customerDTO) {
    Customer customer = new Customer(
            CustomerDTO.getCustomerId(),
            customerDTO.getCustomerName(),
            customerDTO.getCustomerAddress(),
            customerDTO.getCustomerSalary(),
            customerDTO.getContactNumbers(),
            customerDTO.getNic(),
            customerDTO.isActiveState()
    );

    if(!customerRepo.existsById(customer.getCustomerId())) {
      customerRepo.save(customer);
    } else {
      System.out.println("Customer with ID " + customer.getCustomerId() + " already exists.");
    }

  }

  @Override
  public String updateCustomer(CustomerDTO customerDTO) {
    if(customerRepo.existsById(CustomerDTO.getCustomerId())) {
      Customer customer = customerRepo.getById(CustomerDTO.getCustomerId());

        customer.setCustomerName(customerDTO.getCustomerName());
        customer.setCustomerAddress(customerDTO.getCustomerAddress());
        customer.setCustomerSalary(customerDTO.getCustomerSalary());

        customerRepo.save(customer);
        return "Updated";

    } else {
        System.out.println("No Customer Found for that id");
        return "No Customer Found for that id";
    }

  }

  @Override
  public CustomerDTO getCustomerById(int customerId) {
    Customer customer = customerRepo.getById(customerId);
    CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
    return customerDTO;
//    if(customer != null){
//      CustomerDTO customerDTO = new CustomerDTO(
//              customer.getCustomerId(),
//              customer.getCustomerName(),
//              customer.getCustomerAddress(),
//              customer.getCustomerSalary(),
//              customer.getContactNumbers(),
//              customer.getNic(),
//              customer.isActiveState()
//
//      );
//      return  customerDTO;
//    } else {
//      return  null;
//    }

//    Optional<Customer> customer = customerRepo.findById(customerId);
//    if(customer.isPresent()){
//      CustomerDTO customerDTO = new CustomerDTO(
//              customer.get().getCustomerId(),
//              customer.get().getCustomerName(),
//              customer.get().getCustomerAddress(),
//              customer.get().getCustomerSalary(),
//              customer.get().getContactNumbers(),
//              customer.get().getNic(),
//              customer.get().isActiveState()
//
//      );
//      return  customerDTO;
//    } else {
//      return  null;
//    }
  }

  @Override
  public List<CustomerDTO> getAllCustomers() {
    List<Customer> getCustomers = customerRepo.findAll();
    List <CustomerDTO> customerDTOList = new ArrayList<>();

    if(getCustomers != null) {
            customerDTOList = modelMapper.map(getCustomers,new TypeToken<List<CustomerDTO>>() {
    }.getType());
      return customerDTOList;
    } else {
      return null;
    }

  }

  @Override
  public String deleteCustomer(int customerId) {
    if(customerRepo.existsById(customerId)) {
      customerRepo.deleteById(customerId);
      return "Deleted";
    } else {
      return "No Customer Found for that id";
    }
  }
}


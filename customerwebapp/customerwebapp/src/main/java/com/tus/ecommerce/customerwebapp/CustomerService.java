package com.tus.ecommerce.customerwebapp;

import java.net.URI;
import java.util.List;
import java.util.Optional;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tus.ecommerce.customerwebapp.dao.CustomerRepository;
import com.tus.ecommerce.customerwebapp.entity.Customer;


@RestController
@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepo;
	
	@GetMapping(value="/customers")
	List<Customer> getCustomerForCategory() {
		return customerRepo.findAll();
	}
	
	@GetMapping("/customer/{id}")
	Optional<Customer> getCustomer(@PathVariable("id") Long id) {
		return customerRepo.findById(id);
	}
	
	@PostMapping(value = "/customer")
	ResponseEntity<Customer> insertCustomer(@RequestBody Customer customer) {
		Customer savedCustomer = customerRepo.save(customer);
		return new ResponseEntity<Customer>(savedCustomer, HttpStatus.OK);
	}
	
	
	@DeleteMapping(value="/customer/{id}")
	ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id) {
		
		// First fetch an existing product and then delete it. 
		Optional<Customer> optionalCustomer = customerRepo.findById(id); 
		Customer existingCustomer=optionalCustomer.get();
		// Return the deleted product 
		customerRepo.delete(existingCustomer);
		return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT) ;		
	}
	
	@PutMapping(value="/customer/{id}")
	ResponseEntity updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
		
		// First fetch an existing customer and then modify it. 
		Optional<Customer> optionalCustomer = customerRepo.findById(id); 
		Customer existingCustomer=optionalCustomer.get();
		// Now update it back 

		existingCustomer.setFirstName(customer.getFirstName());
		existingCustomer.setLastName(customer.getLastName());
		existingCustomer.setEmail(customer.getEmail());
		existingCustomer.setPhone(customer.getPhone());
		Customer savedCustomer = customerRepo.save(existingCustomer) ;
		// Return the updated product  
		return new ResponseEntity<Customer>(savedCustomer, HttpStatus.OK) ;		
	}
	

}

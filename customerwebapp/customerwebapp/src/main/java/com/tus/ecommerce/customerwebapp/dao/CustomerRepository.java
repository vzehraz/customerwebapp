package com.tus.ecommerce.customerwebapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tus.ecommerce.customerwebapp.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}

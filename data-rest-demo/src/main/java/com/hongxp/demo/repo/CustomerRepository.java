package com.hongxp.demo.repo;

import com.hongxp.demo.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "customer")
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);

    Customer findById(Long id);
}

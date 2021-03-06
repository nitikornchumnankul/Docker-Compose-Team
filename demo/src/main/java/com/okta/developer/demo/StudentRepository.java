package com.okta.developer.demo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://192.168.99.100:4200")
public 
interface StudentRepository extends  JpaRepository<Student, Long>{    
    Student findById(long number);
  
}

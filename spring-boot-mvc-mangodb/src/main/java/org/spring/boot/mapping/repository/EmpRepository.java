package org.spring.boot.mapping.repository;

import org.spring.boot.mapping.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends MongoRepository<Employee, String>{

}

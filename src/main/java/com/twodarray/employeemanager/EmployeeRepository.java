package com.twodarray.employeemanager;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>
{
	Optional<Employee> findByName(String employeeName);
}

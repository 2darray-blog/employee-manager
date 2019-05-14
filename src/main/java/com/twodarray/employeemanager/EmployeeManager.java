package com.twodarray.employeemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Component
public class EmployeeManager
{
	@Autowired
	private EmployeeRepository employeeRepository;

	@PostConstruct
	public void init()
	{
		Employee employee1 = new Employee();
		employee1.setName("John");
		employee1.setTitle("Manager");
		employeeRepository.save(employee1);

		Employee employee2 = new Employee();
		employee2.setName("Alex");
		employee2.setTitle("Developer");
		employeeRepository.save(employee2);
	}

	public Employee getByName(String name)
	{
		Optional<Employee> employee = employeeRepository.findByName(name);
		if(employee.isPresent())
		{
			return employee.get();
		}
		else
		{
			System.out.println("Employee could not be found with name "+name);
			return null;
		}
	}
}

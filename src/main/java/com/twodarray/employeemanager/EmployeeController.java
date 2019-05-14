package com.twodarray.employeemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeController
{
	@Autowired
	private EmployeeManager employeeManager;

	@GetMapping(
			value = "/employees/{name}",
			produces = {
					MediaType.APPLICATION_JSON_VALUE
			})
	public ResponseEntity<Employee> getEmployeeByName(
			@PathVariable(name = "name") String name
	)
	{
		Employee employee = employeeManager.getByName(name);
		if(employee == null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<>(employee,HttpStatus.OK);
		}
	}
}

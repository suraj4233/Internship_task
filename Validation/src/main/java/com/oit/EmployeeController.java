package com.oit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	
	 private final EmployeeService employeeService;

	    @Autowired
	    public EmployeeController(EmployeeService employeeService) {
	        this.employeeService = employeeService;
	    }

	    @GetMapping
	    public List<Employee> getAllEmployees() {
	        return employeeService.getAllEmployees();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
	        Employee employee = employeeService.getEmployeeById(id);
	        if (employee == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(employee);
	    }

	    @PostMapping
	    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
	        return ResponseEntity.ok(employeeService.createEmployee(employee));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Employee> updateEmployee(
	            @PathVariable Long id,
	            @Valid @RequestBody Employee updatedEmployee
	    ) {
	        Employee employee = employeeService.getEmployeeById(id);
	        if (employee == null) {
	            return ResponseEntity.notFound().build();
	        }
	        updatedEmployee.setId(id);
	        return ResponseEntity.ok(employeeService.updateEmployee(updatedEmployee));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
	        employeeService.deleteEmployee(id);
	        return ResponseEntity.noContent().build();
	    }

}

package com.oit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EmployeeServiceTest {
	
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void testGetAllEmployees() {
        Employee employee1 = new Employee();
        employee1.setId(1L);
        employee1.setName("John");
        employee1.setEmail("john@example.com");
        employee1.setSalary(50000.0);

        Employee employee2 = new Employee();
        employee2.setId(2L);
        employee2.setName("Jane");
        employee2.setEmail("jane@example.com");
        employee2.setSalary(60000.0);

        List<Employee> employeeList = Arrays.asList(employee1, employee2);

        when(employeeRepository.findAll()).thenReturn(employeeList);

        List<Employee> result = employeeService.getAllEmployees();

        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getName());
        assertEquals("Jane", result.get(1).getName());
    }

    @Test
    public void testGetEmployeeById() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("John");
        employee.setEmail("john@example.com");
        employee.setSalary(50000.0);

        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        when(employeeRepository.findById(2L)).thenReturn(Optional.empty());

        Employee resultFound = employeeService.getEmployeeById(1L);
        Employee resultNotFound = employeeService.getEmployeeById(2L);

        assertNotNull(resultFound);
        assertEquals("John", resultFound.getName());

        assertNull(resultNotFound);
    }

    @Test
    public void testSaveEmployee() {
        Employee employee = new Employee();
        employee.setName("John");
        employee.setEmail("john@example.com");
        employee.setSalary(50000.0);

        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        Employee savedEmployee = employeeService.saveEmployee(employee);

        assertNotNull(savedEmployee);
        assertEquals("John", savedEmployee.getName());
    }

    @Test
    public void testDeleteEmployee() {
        Long employeeId = 1L;

        doNothing().when(employeeRepository).deleteById(employeeId);

        employeeService.deleteEmployee(employeeId);

        verify(employeeRepository, times(1)).deleteById(employeeId);
    }
}

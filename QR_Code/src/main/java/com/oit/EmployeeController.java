package com.oit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.imageio.ImageIO;
import javax.management.AttributeNotFoundException;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) throws AttributeNotFoundException {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Employee not found with id: " + id));
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) throws AttributeNotFoundException {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Employee not found with id: " + id));

        employee.setName(employeeDetails.getName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setSalary(employeeDetails.getSalary());

        return employeeRepository.save(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) throws AttributeNotFoundException {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Employee not found with id: " + id));

        employeeRepository.delete(employee);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/qr-code")
    public ResponseEntity<ByteArrayResource> generateQRCode(@PathVariable Long id) throws Exception {
        Employee employee = getEmployee(id);
        String employeeDetails = "ID: " + employee.getId() +
                                "\nName: " + employee.getName() +
                                "\nEmail: " + employee.getEmail() +
                                "\nSalary: " + employee.getSalary();

        BufferedImage qrCodeImage = QRCodeGenerator.generateQRCodeImage(employeeDetails, 200, 200);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(qrCodeImage, "png", outputStream);

        ByteArrayResource resource = new ByteArrayResource(outputStream.toByteArray());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=employee_qr.png")
                .contentType(MediaType.IMAGE_PNG)
                .contentLength(outputStream.size())
                .body(resource);
    }
}

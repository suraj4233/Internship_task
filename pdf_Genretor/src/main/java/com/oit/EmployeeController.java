package com.oit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping("/pdf")
    public ResponseEntity<byte[]> generatePDF() throws DocumentException, IOException {
        List<Employee> employees = getEmployeeData();

        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);

        document.open();
        document.add(new Paragraph("Employee Data Report"));

        PdfPTable table = new PdfPTable(4);
        table.addCell("ID");
        table.addCell("Name");
        table.addCell("Email");
        table.addCell("Salary");

        for (Employee employee : employees) {
            table.addCell(employee.getId().toString());
            table.addCell(employee.getName());
            table.addCell(employee.getEmail());
            table.addCell(String.valueOf(employee.getSalary()));
        }

        document.add(table);
        document.close();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "employee_report.pdf");
        
        return new ResponseEntity<>(baos.toByteArray(), headers, HttpStatus.OK);
    }
    private List<Employee> getEmployeeData() {
        // Replace this method with your actual data retrieval logic
        // For simplicity, I'm creating sample data here
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1L, "John Doe", "john@example.com", 50000));
        employees.add(new Employee(2L, "Jane Smith", "jane@example.com", 60000));
        return employees;
    }

    
}


//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import com.itextpdf.text.*;
//import com.itextpdf.text.pdf.PdfWriter;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//@RequestMapping("/employees")
//public class EmployeeController {
//
//    @GetMapping("/pdf")
//    public ResponseEntity<String> generatePDF() throws DocumentException, IOException {
//        List<Employee> employees = getEmployeeData();
//        String filePath = "path/to/your/directory/employee_report.pdf"; // Provide the correct file path
//
//        Document document = new Document();
//        PdfWriter.getInstance(document, new FileOutputStream(new File(filePath)));
//
//        document.open();
//        document.add(new Paragraph("Employee Data Report"));
//
//        PdfPTable table = new PdfPTable(4);
//        table.addCell("ID");
//        table.addCell("Name");
//        table.addCell("Email");
//        table.addCell("Salary");
//
//        for (Employee employee : employees) {
//            table.addCell(employee.getId().toString());
//            table.addCell(employee.getName());
//            table.addCell(employee.getEmail());
//            table.addCell(String.valueOf(employee.getSalary()));
//        }
//
//        document.add(table);
//        document.close();
//
//        return ResponseEntity.ok("PDF saved at: " + filePath);
//    }
//
//    // getEmployeeData() method and Employee class remain the same
//}















package com.oit;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.google.zxing.WriterException;

import java.io.IOException;

@RestController
public class QRCodeController {

    @PostMapping("/generate-qr-code")
    public ResponseEntity<String> generateQRCode(@RequestBody EmployeeDetails employee) throws WriterException {
        try {
            String sanitizedEmployeeName = employee.getName().replaceAll("\\s+", "_").toLowerCase();
            String qrCodeFileName = sanitizedEmployeeName + ".png"; // Unique file name
            String qrCodeFilePath = "E:\\Qr Code\\" + qrCodeFileName; // Specify the directory to save the QR Code images
            QRCodeGenerator.generateQRCodeImage(employee.toString(), 200, 200, qrCodeFilePath);
            return ResponseEntity.ok("QR Code generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating QR Code.");
        }
    }
}

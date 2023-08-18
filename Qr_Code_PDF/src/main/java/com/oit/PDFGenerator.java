package com.oit;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class PDFGenerator {

    public static void generatePDFWithQRCode(EmployeeDetails employee, String qrCodeFilePath, String pdfFilePath)
            throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(pdfFilePath));

        document.open();
        Image qrCodeImage = Image.getInstance(qrCodeFilePath);
        qrCodeImage.scaleAbsolute(100, 100);
        document.add(qrCodeImage);
        document.add(new Paragraph("Employee Details", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16)));
        document.add(employeeToPDFTable(employee));
        document.close();
    }

    private static PdfPTable employeeToPDFTable(EmployeeDetails employee) {
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        PdfPCell cell1 = new PdfPCell(new Phrase("Field", font));
        PdfPCell cell2 = new PdfPCell(new Phrase("Value", font));
        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);

        table.addCell(cell1);
        table.addCell(cell2);

        table.addCell("ID");
        table.addCell(String.valueOf(employee.getId()));
        table.addCell("Name");
        table.addCell(employee.getName());
        table.addCell("Email");
        table.addCell(employee.getEmail());
        table.addCell("Salary");
        table.addCell(String.valueOf(employee.getSalary()));

        return table;
    }
}

package com.example.to_do_app.service.impl;

import com.example.to_do_app.model.ToDoItem;
import com.example.to_do_app.repository.ToDoItemRepository;
import com.example.to_do_app.service.CreatePdfFileService;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

@Service
public class CreatePdfFileServiceImpl implements CreatePdfFileService {

    private final ToDoItemRepository toDoItemRepository;

    public CreatePdfFileServiceImpl(ToDoItemRepository toDoItemRepository) {
        this.toDoItemRepository = toDoItemRepository;
    }


    @Override
    public void createPdf() {

        //please change the path file(location)!
        String filePdfPath = "/Users/stoiandelev/Desktop/ToDo_PDF.pdf";
        try {

            List<ToDoItem> all = (List<ToDoItem>) toDoItemRepository.findAll();

            PdfWriter writer = new PdfWriter(filePdfPath);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);
            Paragraph p1 = new Paragraph("Welcome to AppFire TODO LIST!");
            float[] columnWidth = {0.5f, 0.5f, 0.5f};
            Table table = new Table(columnWidth);
            table.addCell(new Cell().add("ID")).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add("TITLE")).setTextAlignment(TextAlignment.CENTER);
            ;
            table.addCell(new Cell().add("DESCRIPTION")).setTextAlignment(TextAlignment.CENTER);
            ;


            for (ToDoItem item : all) {
                table.addCell(new Cell().add(String.valueOf(item.getId())));
                table.addCell(new Cell().add(String.valueOf(item.getTitle())));
                table.addCell(new Cell().add(String.valueOf(item.getDescription())));

            }

            document.add(p1);
            document.add(table);

            document.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}

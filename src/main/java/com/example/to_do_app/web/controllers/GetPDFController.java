package com.example.to_do_app.web.controllers;

import com.example.to_do_app.service.CreatePdfFileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetPDFController {

    private  final CreatePdfFileService createPdfFileService;

    public GetPDFController(CreatePdfFileService createPdfFileService) {
        this.createPdfFileService = createPdfFileService;
    }

    @GetMapping("/pdfFile")
    public String getPdf() {
        return "index";
    }

    @GetMapping("/createPdf")
    public String pdfFile() {
        createPdfFileService.createPdf();
        return "redirect:/";


    }
}

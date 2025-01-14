package com.nyc.sbpharmacy.controllers;

import com.nyc.sbpharmacy.service.FileService;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class FileController {
    @Autowired
    FileService fileService;

@GetMapping(value = "/exportpdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> exportPdf() {
    ByteArrayOutputStream alluserspdf = fileService.createAllUsersPdfFile();
    return new ResponseEntity<>(alluserspdf.toByteArray(), HttpStatus.OK);
}
}

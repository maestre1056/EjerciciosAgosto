package com.bosonit.block13uploaddownloadfile.files.infraestructure.controller;

import com.bosonit.block13uploaddownloadfile.files.application.FileDBService;
import com.bosonit.block13uploaddownloadfile.files.application.FileService;
import com.bosonit.block13uploaddownloadfile.files.domain.File;
import com.bosonit.block13uploaddownloadfile.files.exception.FileMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin("*")
public class FileController {
    @Autowired
    FileService fileService;
/*
    @Autowired
    FileDBService fileDBService;

*/

    @PostMapping("/upload/{type}")
    public ResponseEntity uploadFiles(@RequestParam("file")MultipartFile file,@PathVariable String type){
        String message= "";

        try {
            return ResponseEntity.status(HttpStatus.OK).body(fileService.save(file,type));
        }catch (Exception e){
            message = "Fallo al subir";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new FileMessage(message));
        }


    }

    }

    /*

    @GetMapping("files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename){
       // Resource file = fileService.load(filename);

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\""+ file.getFilename()+"\"").body(file);
    }

     */




package com.bosonit.block13uploaddownloadfile.files.infraestructure.controller;

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



    @PostMapping("/upload")
    public ResponseEntity<FileMessage> uploadFiles(@RequestParam("files")MultipartFile[] files){
        String message= "";

        try {
            List<String> fileNames= new ArrayList<>();

            Arrays.asList(files).stream().forEach(file -> {
                fileService.save(file);
                fileNames.add(file.getOriginalFilename());
            });

            message = "Se subieron los archivos" + fileNames;

            return ResponseEntity.status(HttpStatus.OK).body(new FileMessage(message));
        }catch (Exception e){
            message = "Fallo al subir";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new FileMessage(message));
        }

    }

    @GetMapping("/files")
    public ResponseEntity<List<File>> getFiles(){
        List<File> fileInfo = fileService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder.fromMethodName(FileController.class,"getFile",
                    path.getFileName().toString()).build().toString();
            return new File(filename,url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfo);

    }

    @GetMapping("files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename){
        Resource file = fileService.load(filename);

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\""+ file.getFilename()+"\"").body(file);
    }
}

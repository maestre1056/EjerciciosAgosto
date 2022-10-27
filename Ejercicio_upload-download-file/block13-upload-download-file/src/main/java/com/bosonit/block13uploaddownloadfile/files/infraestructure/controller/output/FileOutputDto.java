package com.bosonit.block13uploaddownloadfile.files.infraestructure.controller.output;

import com.bosonit.block13uploaddownloadfile.files.domain.File;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FileOutputDto {

    private Long id;
    private String name;
    private String metadata;
    private LocalDateTime uploadDate;

    public FileOutputDto(File file){
        setId(file.getId());
        setName(file.getName());
        setMetadata(file.getMetadata());
        setUploadDate(file.getUploadDate());
    }
}

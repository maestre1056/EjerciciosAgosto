package com.bosonit.block13uploaddownloadfile.files.application;

import com.bosonit.block13uploaddownloadfile.files.domain.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileServiceImp implements FileService{
   private final Path root = Paths.get("storage");

   @Autowired
   FileDBService fileDBService;

    @Override
    public void init()  {
        try {
            Files.createDirectory(root);
        } catch (IOException e) {
            throw new RuntimeException("No se puede iniciar el storage");
        }

    }

    @Override
    public File save(MultipartFile file, String type) {
        String name = StringUtils.cleanPath(file.getContentType());
        String[] strings = name.split("/");
        String extension = strings[1];
        if(extension.equals(type)) {
            try {
                Files.copy(file.getInputStream(),
                        this.root.resolve(file.getOriginalFilename()));
                return fileDBService.store(file,root);
            } catch (Exception e) {
                throw new RuntimeException("Could not store the file.Error" +e.getMessage());

            }
        }

        throw new RuntimeException("Category file not matches");
    }

    @Override
    public Resource loadByName(String filename) {

        try {
            Path file = root.resolve(filename);
           Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()){
                return resource;
            }else {
                throw new RuntimeException("No se puede leer");
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException("Error" + e.getMessage());
        }


    }

    @Override
    public Resource loadById(Long id) {
        try {
            String filename = fileDBService.getFileById(id).getName();
            Path file = root.resolve(filename);

            Resource resource = new UrlResource(file.toUri());

            if(resource.exists() || resource.isReadable()){
                return resource;
            }else {
                throw new RuntimeException("No se puede leer" );
            }
        }catch (MalformedURLException e){
            throw new RuntimeException("Error: "+ e.getMessage());

        }


    }


    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());

    }




}

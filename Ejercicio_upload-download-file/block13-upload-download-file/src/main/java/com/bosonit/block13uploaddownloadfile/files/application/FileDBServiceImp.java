package com.bosonit.block13uploaddownloadfile.files.application;

import com.bosonit.block13uploaddownloadfile.files.domain.File;
import com.bosonit.block13uploaddownloadfile.files.infraestructure.repository.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class FileDBServiceImp implements FileDBService{

    @Autowired
    FilesRepository filesRepository;


    @Override
    public File store(MultipartFile file, Path root) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        File fileDb = new File(fileName,file.getContentType(),root.toString());

        return filesRepository.save(fileDb);
    }

    @Override
    public File getFileById(Long id) {
        return filesRepository.getReferenceById(id);
    }



    @Override
    public Stream<File> getAllFiles() {
        return filesRepository.findAll().stream();
    }

    @Override
    public String deleteFile(Long id) {
        File fileDb = filesRepository.getReferenceById(id);
        filesRepository.delete(fileDb);

        return "Archivo borrado con éxito";
    }
}

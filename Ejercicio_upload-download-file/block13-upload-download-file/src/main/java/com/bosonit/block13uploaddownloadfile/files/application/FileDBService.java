package com.bosonit.block13uploaddownloadfile.files.application;

import com.bosonit.block13uploaddownloadfile.files.domain.File;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileDBService {

    File store(MultipartFile file, Path root) throws IOException;

    File getFileById(Long id);

    Stream<File> getAllFiles();

    String deleteFile(Long id);
}

package com.bosonit.block13uploaddownloadfile.files.application;

import com.bosonit.block13uploaddownloadfile.files.domain.File;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    public void init() ;

    public File save(MultipartFile file, String type) throws Exception;

    public Resource loadByName(String filename);

    public Resource loadById(Long id);

    public void deleteAll();


}

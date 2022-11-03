package com.bosonit.block13uploaddownloadfile;

import com.bosonit.block13uploaddownloadfile.files.application.FileService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class Block13UploadDownloadFileApplication implements CommandLineRunner {

	@Resource
	FileService fileService;
	public static void main(String[] args) {
		SpringApplication.run(Block13UploadDownloadFileApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		fileService.deleteAll();
		fileService.init();

	}
}

package com.bosonit.block13uploaddownloadfile.files.infraestructure.repository;

import com.bosonit.block13uploaddownloadfile.files.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepository extends JpaRepository<File ,Long> {
}

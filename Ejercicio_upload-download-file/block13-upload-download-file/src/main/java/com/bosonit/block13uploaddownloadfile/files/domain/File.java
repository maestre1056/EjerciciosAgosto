package com.bosonit.block13uploaddownloadfile.files.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;



@Entity
@Data
@NoArgsConstructor
public class File {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String metadata;

    @Column
    private String name;

    @Column
    LocalDateTime uploadDate;


    public File(String metadata, String name, LocalDateTime uploadDate) {
        this.metadata = metadata;
        this.name = name;
        this.uploadDate = uploadDate;
    }

    public File(String filename, String url) {
    }
}

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
    private String category;

    @Column
    private String name;

    @Column
    private String root;

    @Column
    LocalDateTime uploadDate;


    public File(String name, String category, String root) {
        setName(name);
        setCategory(category);
        setRoot(root);
        setUploadDate(LocalDateTime.now());
    }


}

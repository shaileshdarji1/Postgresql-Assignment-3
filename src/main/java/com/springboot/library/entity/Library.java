package com.springboot.library.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.crypto.Mac;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "library")
    @JsonManagedReference("library")
    private List<Book> books;
}

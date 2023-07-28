package com.springboot.library.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime borrowedDate;
    private LocalDateTime dueDate;
    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonBackReference("book")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("user")
    private User user;
}

package com.springboot.library.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Immutable;

import java.time.LocalDateTime;

@Entity
@Immutable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserView {

    @Id
    private Integer id;

    private String name;

    private String title;

    private String libraryName;

    private LocalDateTime borrowedDate;

    private LocalDateTime dueDate;
}

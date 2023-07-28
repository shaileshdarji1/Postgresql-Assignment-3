package com.springboot.library.service;

import com.springboot.library.entity.Borrowing;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface BorrowingService {

    public Borrowing saveBorrowing(Borrowing borrowing);

    public Borrowing updateBorrowing(Long id, Borrowing borrowing);

    public Borrowing getBorrowing(Long id);

    public List<Borrowing> getALlBorrowing();

    public String deleteBorrowing(Long id);


    public List<Borrowing> getBorrowingByDueDate(String dueDate);

}

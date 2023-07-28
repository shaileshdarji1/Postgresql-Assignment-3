package com.springboot.library.controller;

import com.springboot.library.entity.Borrowing;
import com.springboot.library.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/borrowing")
public class BorrowingController {

    @Autowired
    BorrowingService borrowingService;

    @PostMapping
    public Borrowing saveBorrowing(@RequestBody Borrowing borrowing) {
        return borrowingService.saveBorrowing(borrowing);
    }

    @GetMapping
    public List<Borrowing> getAllBorrowing() {
        return borrowingService.getALlBorrowing();
    }

    @GetMapping("/{id}")
    public Borrowing getBorrowing(@PathVariable Long id) {
        return borrowingService.getBorrowing(id);
    }

    @PutMapping("/{id}")
    public Borrowing updateBorrowing(@PathVariable Long id, @RequestBody Borrowing borrowing) {
        return borrowingService.updateBorrowing(id, borrowing);
    }

    @DeleteMapping("/{id}")
    public String deleteBorrowing(@PathVariable Long id) {
        return borrowingService.deleteBorrowing(id);
    }

    @GetMapping("/due-date-time/{dueDate}")
    public List<Borrowing> getBorrowingByDueDate(@PathVariable String dueDate) {
        return borrowingService.getBorrowingByDueDate(dueDate);
    }
}

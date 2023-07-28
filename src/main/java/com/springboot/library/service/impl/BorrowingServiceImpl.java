package com.springboot.library.service.impl;

import com.springboot.library.entity.Borrowing;
import com.springboot.library.exception.BorrowingNotFoundException;
import com.springboot.library.repository.BorrowingRepository;
import com.springboot.library.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BorrowingServiceImpl implements BorrowingService {

    @Autowired
    BorrowingRepository borrowingRepository;

    @Override
    public Borrowing saveBorrowing(Borrowing borrowing) {
        return borrowingRepository.save(borrowing);
    }

    @Override
    public Borrowing updateBorrowing(Long id, Borrowing borrowing) {
        if (borrowingRepository.existsById(id)) {
            borrowing.setId(id);
            return borrowingRepository.save(borrowing);
        } else {
            throw new BorrowingNotFoundException("Borrower Not Found !");
        }

    }

    @Override
    public Borrowing getBorrowing(Long id) {
        return borrowingRepository.findById(id).orElseThrow(() -> new BorrowingNotFoundException("Borrower Not Found !"));
    }

    @Override
    public List<Borrowing> getALlBorrowing() {
        return borrowingRepository.findAll();
    }

    @Override
    public String deleteBorrowing(Long id) {
        if (borrowingRepository.existsById(id)) {
            borrowingRepository.deleteById(id);
            return "Borrower Delete Successfully";
        } else {
            throw new BorrowingNotFoundException("Borrower Not Found !");
        }
    }

    @Override
    public List<Borrowing> getBorrowingByDueDate(String dueDate) {
        return borrowingRepository.findByDueDateContaining(dueDate);
    }
}

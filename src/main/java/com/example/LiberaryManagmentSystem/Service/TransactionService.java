package com.example.LiberaryManagmentSystem.Service;

import com.example.LiberaryManagmentSystem.DTOs.IssueBookRequestDTO;
import com.example.LiberaryManagmentSystem.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public String issueBook(IssueBookRequestDTO issueBook){

        // Home work
        return "Transaction completed.";
    }

}

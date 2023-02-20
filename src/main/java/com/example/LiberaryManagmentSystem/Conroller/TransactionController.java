package com.example.LiberaryManagmentSystem.Conroller;

import com.example.LiberaryManagmentSystem.DTOs.IssueBookRequestDTO;
import com.example.LiberaryManagmentSystem.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issueBook")
    public String issueBook(@RequestBody IssueBookRequestDTO issueBook){
        try {
            return transactionService.issueBook(issueBook);
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}

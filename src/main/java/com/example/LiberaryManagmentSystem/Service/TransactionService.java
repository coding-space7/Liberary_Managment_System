package com.example.LiberaryManagmentSystem.Service;

import com.example.LiberaryManagmentSystem.DTOs.IssueBookRequestDTO;
import com.example.LiberaryManagmentSystem.Enums.CardStatus;
import com.example.LiberaryManagmentSystem.Enums.TransactionStatus;
import com.example.LiberaryManagmentSystem.Models.Book;
import com.example.LiberaryManagmentSystem.Models.Card;
import com.example.LiberaryManagmentSystem.Models.Transaction;
import com.example.LiberaryManagmentSystem.Repository.BookRepository;
import com.example.LiberaryManagmentSystem.Repository.CardRepository;
import com.example.LiberaryManagmentSystem.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CardRepository cardRepository;

    public String issueBook(IssueBookRequestDTO issueBook) throws Exception{

        int bookId = issueBook.getBookId();
        int cardId = issueBook.getCardId();

        Transaction transaction = new Transaction();

        //set attributes
        transaction.setTransactionStatus(TransactionStatus.PENDING);

        Book book = bookRepository.findById(bookId).get();
        Card card = cardRepository.findById(cardId).get();
        transaction.setBook(book);
        transaction.setCard(card);

        //Do some validation
        if(book == null || book.isIssue() == true){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is not available.");
        }

        if(card == null || card.getCardStatus() != CardStatus.ACTIVATED){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card is not Active.");
        }

        // Setting foreign keys and bidirectional settings
        // for book
        book.getTransactionList().add(transaction);
        book.setIssue(true);

        // for card
        card.getTransactionList().add(transaction);
        card.getBooks().add(book);

        // Save the Parents
        transaction.setIssue(true);
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        cardRepository.save(card);

        return "Transaction completed.";
    }

}

package com.example.LiberaryManagmentSystem.Service;

import com.example.LiberaryManagmentSystem.Models.Author;
import com.example.LiberaryManagmentSystem.Models.Book;
import com.example.LiberaryManagmentSystem.Repository.AuthorRepository;
import com.example.LiberaryManagmentSystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;

    public String addBook(Book book) throws Exception{

        int authorId = book.getAuthor().getId();
        Author author = authorRepository.findById(authorId).get();

        author.getBooks().add(book);
        book.setAuthor(author);
        authorRepository.save(author);

        return "book added successfully";
    }
}

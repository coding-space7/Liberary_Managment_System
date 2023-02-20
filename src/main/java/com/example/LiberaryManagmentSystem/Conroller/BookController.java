package com.example.LiberaryManagmentSystem.Conroller;

import com.example.LiberaryManagmentSystem.Models.Book;
import com.example.LiberaryManagmentSystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/addBook")
    public String addBook(@RequestBody Book book) throws Exception{
        return bookService.addBook(book);
    }

//    @GetMapping("/getBook")
//    public Book getBook(@RequestParam("id") int id){
//        return bookService.getBook(id);
//    }
}

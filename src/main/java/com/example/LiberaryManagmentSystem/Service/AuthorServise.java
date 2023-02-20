package com.example.LiberaryManagmentSystem.Service;

import com.example.LiberaryManagmentSystem.Models.Author;
import com.example.LiberaryManagmentSystem.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthorServise {

    @Autowired
    AuthorRepository authorRepository;

    public String addAuthor(Author author){

        authorRepository.save(author);
        return "Author added successfully";
    }

    public Author getAuthor(int id){
        return authorRepository.getById(id);
    }

}

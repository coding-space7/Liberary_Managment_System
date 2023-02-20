package com.example.LiberaryManagmentSystem.Conroller;

import com.example.LiberaryManagmentSystem.Models.Author;
import com.example.LiberaryManagmentSystem.Service.AuthorServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorServise authorServise;

    @PostMapping("/addAuthor")
    public String addAuthor(@RequestBody Author author){
        return authorServise.addAuthor(author);
    }

    @GetMapping("/getAuthor")
    public Author getAuthor(@RequestParam("id") int id){
        return authorServise.getAuthor(id);
    }

}

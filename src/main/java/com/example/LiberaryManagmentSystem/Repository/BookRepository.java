package com.example.LiberaryManagmentSystem.Repository;

import com.example.LiberaryManagmentSystem.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}

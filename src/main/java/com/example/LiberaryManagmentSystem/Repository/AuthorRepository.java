package com.example.LiberaryManagmentSystem.Repository;

import com.example.LiberaryManagmentSystem.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

}

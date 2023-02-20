package com.example.LiberaryManagmentSystem.Repository;

import com.example.LiberaryManagmentSystem.Models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {
}

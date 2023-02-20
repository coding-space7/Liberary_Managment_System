package com.example.LiberaryManagmentSystem.Service;


import com.example.LiberaryManagmentSystem.Repository.StudentRepository;
import com.example.LiberaryManagmentSystem.Enums.CardStatus;
import com.example.LiberaryManagmentSystem.Models.Card;
import com.example.LiberaryManagmentSystem.Models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent( Student student){

        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudent(student);
        student.setCard(card);

        studentRepository.save(student);

        return "Student added successfully.";
    }


}

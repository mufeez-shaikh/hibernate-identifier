package com.mufizco.hibernateapp.rest;

import com.mufizco.hibernateapp.entities.Account;
import com.mufizco.hibernateapp.entities.Student;
import com.mufizco.hibernateapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> post(@RequestBody Student student){
        Random random = new Random();
        int randomInt = random.nextInt(1000);
        String email = student.getEmail()+randomInt;
        String firstName = student.getFirstName()+randomInt;
        String lastName = student.getFirstName()+randomInt;
        Student studentToSave = student.toBuilder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .build();

        Student studentSaved = studentService.save(studentToSave);


        return ResponseEntity.ok(studentSaved);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAll(){
        return ResponseEntity.ok(studentService.getAll());
    }
}

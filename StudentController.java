package com.praktike.praktike.controller;

import com.praktike.praktike.entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.praktike.praktike.repository.StudentRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;



    @RestController
    @RequestMapping("/students")
    public class StudentController {

        private StudentRepository studentRepository;

        // Отримання списку всіх студентів
        @GetMapping
        public List<Student> getAllStudents() {
            return studentRepository.findAll();
        }

        // Додавання нового студента
        @PostMapping
        public Student addStudent(@RequestBody Student student) {
            return studentRepository.save(student);
        }

        // Оновлення існуючого студента
        @PutMapping("/{id}")
        public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
            Student student = studentRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Student not found with id " + id));

            student.setFirstName(studentDetails.getFirstName());
            student.setLastName(studentDetails.getLastName());

            Student updatedStudent = studentRepository.save(student);
            return ResponseEntity.ok(updatedStudent);
        }

        // Видалення студента
        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
            Student student = studentRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Student not found with id " + id));

            studentRepository.delete(student);
            return ResponseEntity.ok("Student deleted successfully");
        }
    }


    



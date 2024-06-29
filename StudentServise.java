package com.praktike.praktike.service;
import com.praktike.praktike.entity.Student;
import com.praktike.praktike.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudentServise {

        @Autowired
        private StudentRepository studentRepository;

        public List<Student> getAllStudents() {
            return studentRepository.findAll();
        }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void updateStudent(Student student) {
        studentRepository.save(student);
    }


    public void deleteStudentById(Long id) {
    }
}

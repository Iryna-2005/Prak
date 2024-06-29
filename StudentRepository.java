package com.praktike.praktike.repository;

import com.praktike.praktike.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Тут можна додавати спеціалізовані методи для роботи зі студентами, якщо потрібно
}



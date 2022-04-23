package com.fineline.dao;


import com.fineline.models.Student;
import com.fineline.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * This DAO is to insert/update student entries in database
 * @author Sreeram Maram
 */
@Component
public class StudentDAO{
    @Autowired
    StudentRepo studentRepo;

    public Optional<Student> findById2(@Param("id") Integer id) {
        return studentRepo.findById2(id);
    }

    public List<Student> getStudentsLessThanId(@Param("id") Integer id) {
        return studentRepo.getStudentsLessThanId(id);
    }

    public Student get(Integer id) {
        return studentRepo.findById(id).orElse(null);
    }

    public void insertingStudent(Integer id, String name, String contact) {
        studentRepo.insertingStudent(id, name, contact);
    }

    public List<Student> getAll() {
        return (List<Student>) studentRepo.findAll();
    }
}

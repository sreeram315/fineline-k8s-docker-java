package com.fineline.controllers;

import com.fineline.dao.StudentDAO;
import com.fineline.models.Student;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class StudentController {
    private static final Log LOG = LogFactory.getLog(StudentController.class);

    @Autowired
    StudentDAO studentDAO;

    @GetMapping("/student/add")
    Student add(int id, String name, String contact){
        LOG.info(String.format("Adding student: %s %s %s", id, name, contact));
        Student student = studentDAO.get(id);
        if(student != null)
            throw new RuntimeException(String.format("Student already exists with ID: %s", id));
        studentDAO.insertingStudent(id, name, contact);
        return studentDAO.get(id);
    }

    @GetMapping("/student/get")
    Student get(int id){
        LOG.info(String.format("GET student id: %s", id));
        Student student = studentDAO.get(id);
        if(student == null)
            throw new NoSuchElementException(String.format("Student not found for ID: %s", id));
        return student;
    }

    @GetMapping("/student/all")
    List<Student> getAll(){
        return studentDAO.getAll();
    }
}

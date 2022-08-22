package com.hesh.stumanage.controller;

import com.hesh.stumanage.entity.Student;
import com.hesh.stumanage.service.StudentService;
import com.hesh.stumanage.service.StudentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Students/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    private final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @PostMapping("/save")
    public Student saveDepartment(@RequestBody Student student){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return studentService.saveStudent(student);
    }

    @GetMapping("/retrieve")
    public List<Student> fetchStudentList(){
        return studentService.fetchStudentList();
    }

    @GetMapping("/retrieve/{id}")
    public Student fetchStudentById(@PathVariable("id") Long studentId){
        return studentService.fetchStudentById(studentId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable("id") Long studentId){
        studentService.deleteStudentById(studentId);
        return "Student Deleted Successfully";
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable("id")  Long studentId, @RequestBody Student student){
        return studentService.updateStudent(studentId, student);
    }
/*
    @GetMapping("/retrieveByName/{name}")
    public Student fetchStudentByName(@PathVariable("name") String studentName){
        return studentService.fetchStudentByName(studentName);
    }
*/
}

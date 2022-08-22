package com.hesh.stumanage.service;

import com.hesh.stumanage.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {

    public Student saveStudent(Student student);

    public List<Student> fetchStudentList();

    public Student fetchStudentById(Long studentId);

    public void deleteStudentById(Long studentId);

    public Student updateStudent(Long studentId, Student student);

    //public Student fetchStudentByName(String studentName);
}

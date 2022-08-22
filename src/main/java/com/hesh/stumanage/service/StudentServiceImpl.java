package com.hesh.stumanage.service;

import com.hesh.stumanage.entity.Student;
import com.hesh.stumanage.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> fetchStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public Student fetchStudentById(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        return student.get();
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student updateStudent(Long studentId, Student student) {
        Student studentFromDB = studentRepository.findById(studentId).get();

        if(Objects.nonNull(student.getStudentName()) &&
                !"".equalsIgnoreCase(student.getStudentName())){
            studentFromDB.setStudentName(student.getStudentName());
        }

        if(Objects.nonNull(student.getStudentCode()) &&
                !"".equalsIgnoreCase(student.getStudentCode())){
            studentFromDB.setStudentCode(student.getStudentCode());
        }

        if(Objects.nonNull(student.getStudentAddress()) &&
                !"".equalsIgnoreCase(student.getStudentAddress())){
            studentFromDB.setStudentAddress(student.getStudentAddress());
        }


        return studentRepository.save(studentFromDB);
    }
/*
    @Override
    public Student fetchStudentByName(String studentName) {
        return studentRepository.findByStudentNameIgnoreCase(studentName);
    }

 */
}

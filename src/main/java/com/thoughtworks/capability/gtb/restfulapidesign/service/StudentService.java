package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.expection.StudentExistsException;
import com.thoughtworks.capability.gtb.restfulapidesign.expection.StudentNotFoundException;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    public final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student) {
        if (studentRepository.findById(student.getId()) == null) {
            studentRepository.addStudent(student);
        } else {
            throw new StudentExistsException("This student already exist");
        }
    }

    public void deleteStudent(int id) {
        if (studentRepository.findById(id) != null) {
            studentRepository.deleteStudent(id);
        } else {
            throw new StudentNotFoundException("This student doesn't exist");
        }
    }

    public List<Student> findByGender(Gender gender) {
        List<Student> students = studentRepository.findByGender(gender);
        if (students.size() == 0) {
            return studentRepository.getStudents();
        }
        return students;
    }

    public Student findById(int id) {
        Student student = studentRepository.findById(id);
        if (student == null) {
            throw new StudentNotFoundException("This student doesn't exist");
        }
        return student;
    }

    public void updateStudent(Student student) {
        if (studentRepository.findById(student.getId()) != null) {
            studentRepository.updateStudent(student);
        } else {
            throw new StudentNotFoundException("This student doesn't exist");
        }
    }

    public List<Student> findAllStudents() {
        return studentRepository.getStudents();
    }
}

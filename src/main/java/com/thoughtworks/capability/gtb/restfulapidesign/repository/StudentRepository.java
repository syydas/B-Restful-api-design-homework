package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.dataservice.DataService;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Data
public class StudentRepository {

    private final List<Student> students = DataService.students;

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student findById(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void deleteStudent(int id) {
        students.remove(findById(id));
    }

    public List<Student> findByGender(Gender gender) {
        return students.stream()
                .filter(student -> student.getGender().equals(gender))
                .collect(Collectors.toList());
    }

    public void updateStudent(Student student) {
        students.removeIf(stu -> stu.getId() == student.getId());
        students.add(student);
    }
}

package com.project.student.controller;

import com.project.student.entity.Student;
import com.project.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents() {
        return ResponseEntity.ok(studentService.findAllStudents());
    }

    @GetMapping("/school/schoolId")
    public ResponseEntity<List<Student>> findAllStudentsBySchoolId(@PathVariable("schoolId") Integer schoolId) {
        return ResponseEntity.ok(studentService.findAllStudentsBySchoolId(schoolId));
    }
}

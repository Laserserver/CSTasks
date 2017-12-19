package vsu.kurs3.task3.hibNormal.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsu.kurs3.task3.hibNormal.models.dto.StudentDTO;
import vsu.kurs3.task3.hibNormal.models.services.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        studentService.delete(id);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    ResponseEntity<StudentDTO> get(@PathVariable long id) {
        StudentDTO student = studentService.get(id);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public @ResponseBody Iterable<StudentDTO> getAll() {
        return studentService.getAll();
    }

    @PostMapping
    public @ResponseBody StudentDTO post(@RequestBody StudentDTO student) {
        return studentService.add(student);
    }

    @PutMapping
    public @ResponseBody StudentDTO put(@RequestBody StudentDTO student) {
        return studentService.edit(student);
    }
}

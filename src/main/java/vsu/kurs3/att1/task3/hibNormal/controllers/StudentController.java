package vsu.kurs3.att1.task3.hibNormal.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsu.kurs3.att1.task3.hibNormal.models.Student;
import vsu.kurs3.att1.task3.hibNormal.services.StudentService;

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
    ResponseEntity<Student> get(@PathVariable long id) {
        Student student = studentService.get(id);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public @ResponseBody Iterable<Student> getAll() {
        return studentService.getAll();
    }

    @PostMapping
    public @ResponseBody Student post(@RequestBody Student student) {
        return studentService.add(student);
    }

    @PutMapping
    public @ResponseBody Student put(@RequestBody Student student) {
        return studentService.edit(student);
    }
}

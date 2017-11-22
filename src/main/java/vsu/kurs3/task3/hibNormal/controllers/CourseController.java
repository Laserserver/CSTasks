package vsu.kurs3.task3.hibNormal.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsu.kurs3.task3.hibNormal.models.dto.CourseDTO;
import vsu.kurs3.task3.hibNormal.services.CourseService;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        courseService.delete(id);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<CourseDTO> get(@PathVariable long id) {
        CourseDTO course = courseService.get(id);
        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public @ResponseBody Iterable<CourseDTO> getAll() {
        return courseService.getAll();
    }

    @PostMapping
    public @ResponseBody CourseDTO post(@RequestBody CourseDTO course) {
         return courseService.add(course);
    }

    @PutMapping
    public @ResponseBody CourseDTO put(@RequestBody CourseDTO course) {
         return courseService.edit(course);
    }
}

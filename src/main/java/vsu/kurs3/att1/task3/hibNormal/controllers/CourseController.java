package vsu.kurs3.att1.task3.hibNormal.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsu.kurs3.att1.task3.hibNormal.models.entities.Course;
import vsu.kurs3.att1.task3.hibNormal.services.CourseService;

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
    public @ResponseBody ResponseEntity<Course> get(@PathVariable long id) {
        Course channel = courseService.get(id);
        if (channel != null) {
            return new ResponseEntity<>(channel, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public @ResponseBody Iterable<Course> getAll() {
        return courseService.getAll();
    }

    @PostMapping
    public @ResponseBody Course post(@RequestBody Course channel) {
        return courseService.add(channel);
    }

    @PutMapping
    public @ResponseBody Course put(@RequestBody Course channel) {
        return courseService.edit(channel);
    }
}

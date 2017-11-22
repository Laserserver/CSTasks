package vsu.kurs3.att1.task3.hibNormal.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsu.kurs3.att1.task3.hibNormal.models.entities.Marks;
import vsu.kurs3.att1.task3.hibNormal.services.MarksService;

@RestController
@RequestMapping("/api/marks")
public class MarksController {

    private final MarksService marksService;

    public MarksController(MarksService marksService) {
        this.marksService = marksService;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        marksService.delete(id);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    ResponseEntity<Marks> get(@PathVariable long id) {
        Marks marks = marksService.get(id);
        if (marks != null) {
            return new ResponseEntity<>(marks, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public @ResponseBody Iterable<Marks> getAll() {
        return marksService.getAll();
    }

    @PostMapping
    public @ResponseBody Marks post(@RequestBody Marks marks) {
        return marksService.add(marks);
    }

    @PutMapping
    public @ResponseBody Marks put(@RequestBody Marks marks) {
        return marksService.edit(marks);
    }
}

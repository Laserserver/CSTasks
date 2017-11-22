package vsu.kurs3.task3.hibNormal.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsu.kurs3.task3.hibNormal.models.dto.MarksDTO;
import vsu.kurs3.task3.hibNormal.services.MarksService;

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
    ResponseEntity<MarksDTO> get(@PathVariable long id) {
        MarksDTO marks = marksService.get(id);
        if (marks != null) {
            return new ResponseEntity<>(marks, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public @ResponseBody Iterable<MarksDTO> getAll() {
        return marksService.getAll();
    }

    @PostMapping
    public @ResponseBody MarksDTO post(@RequestBody MarksDTO marks) {
        return marksService.add(marks);
    }

    @PutMapping
    public @ResponseBody MarksDTO put(@RequestBody MarksDTO marks) {
        return marksService.edit(marks);
    }
}

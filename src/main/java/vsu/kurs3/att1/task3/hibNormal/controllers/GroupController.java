package vsu.kurs3.att1.task3.hibNormal.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsu.kurs3.att1.task3.hibNormal.models.Group;
import vsu.kurs3.att1.task3.hibNormal.services.GroupService;

@RestController
@RequestMapping("/api/group")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        groupService.delete(id);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Group> get(@PathVariable long id) {
        Group group = groupService.get(id);
        if (group != null) {
            return new ResponseEntity<>(group, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public @ResponseBody Iterable<Group> getAll() {
        return groupService.getAll();
    }

    @PostMapping
    public @ResponseBody Group post(@RequestBody Group group) {
        return groupService.add(group);
    }

    @PutMapping
    public @ResponseBody Group put(@RequestBody Group group) {
        return groupService.edit(group);
    }
}

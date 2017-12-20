package vsu.kurs3.task3.hibNormal.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vsu.kurs3.task3.hibNormal.models.dto.GroupDTO;
import vsu.kurs3.task3.hibNormal.models.services.GroupService;

@Controller
@RequestMapping("/course/")
public class GroupController {
    String course;
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        groupService.delete(id);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<GroupDTO> get(@PathVariable long id) {
        GroupDTO group = groupService.get(id);
        if (group != null) {
            return new ResponseEntity<>(group, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public @ResponseBody Iterable<GroupDTO> getAll() {
        return groupService.getAll();
    }

    @PostMapping
    public @ResponseBody GroupDTO post(@RequestBody GroupDTO group) {
        return groupService.add(group);
    }

    @PutMapping
    public @ResponseBody GroupDTO put(@RequestBody GroupDTO group) {
        return groupService.edit(group);
    }
}

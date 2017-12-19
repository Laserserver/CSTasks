package vsu.kurs3.task3.hibNormal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vsu.kurs3.task3.hibNormal.models.dto.CourseDTO;
import vsu.kurs3.task3.hibNormal.models.services.CourseService;

@Controller
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{name}")
    public @ResponseBody Iterable<String> get(@PathVariable String name) {
        return courseService.getGroupsNamesByName(name);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String test(@RequestParam(value="name", required=false) String name, Model model) {
        Iterable<String> strs = courseService.getCourses();
        model.addAttribute("messages", strs);
        return "test";
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody ModelAndView post(@RequestParam(value="name", required=false) String name, Model model) {
        courseService.addNewCourse();
        return new ModelAndView(test(name, model));
    }

    @PutMapping
    public @ResponseBody CourseDTO put(@RequestBody CourseDTO course) {
         return courseService.edit(course);
    }
}

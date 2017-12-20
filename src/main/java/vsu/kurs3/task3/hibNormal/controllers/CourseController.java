package vsu.kurs3.task3.hibNormal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vsu.kurs3.task3.hibNormal.models.services.CourseService;
import vsu.kurs3.task3.hibNormal.models.services.GroupService;

@Controller
@RequestMapping("/")
public class CourseController {

    private final CourseService courseService;
    private final GroupService groupService;

    public CourseController(CourseService courseService, GroupService groupService) {
        this.courseService = courseService;
        this.groupService = groupService;
    }

    @GetMapping("/{name}")
    public @ResponseBody ModelAndView get(@PathVariable String name, Model model) {
        Iterable<String> strs = courseService.getGroupsNamesByName(name);
        model.addAttribute("messages", strs);
        return new ModelAndView("groups");
    }

    @RequestMapping(method = RequestMethod.GET)
    public String test(Model model) {
        Iterable<String> strs = courseService.getCourses();
        model.addAttribute("messages", strs);
        return "courses";
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody ModelAndView post(Model model) {
        courseService.addNewCourse();
        return new ModelAndView(test(model));
    }

    @GetMapping("/{course}/{group}")
    public @ResponseBody ModelAndView get(@PathVariable String course, @PathVariable String group, Model model) {

        Iterable<String> strs = groupService.getStudentsByCourseAndGroup(
                courseService.getByName(course), group);
        model.addAttribute("messages", strs);
        return new ModelAndView("students");
    }
}

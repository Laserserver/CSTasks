package vsu.kurs3.task3.hibNormal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vsu.kurs3.task3.hibNormal.models.dto.CourseDTO;
import vsu.kurs3.task3.hibNormal.models.dto.GroupDTO;
import vsu.kurs3.task3.hibNormal.models.dto.StudentDTO;
import vsu.kurs3.task3.hibNormal.models.services.CourseService;
import vsu.kurs3.task3.hibNormal.models.services.GroupService;
import vsu.kurs3.task3.hibNormal.models.services.StudentService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/start/")
public class CourseController {

    private final CourseService courseService;
    private final GroupService groupService;
    private final StudentService studentService;

    public CourseController(CourseService courseService, GroupService groupService, StudentService studentService) {
        this.courseService = courseService;
        this.groupService = groupService;
        this.studentService = studentService;
    }

    @GetMapping("/course/{name}")
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

    @GetMapping("/course/{course}/group/{group}")
    public @ResponseBody ModelAndView get(@PathVariable String course, @PathVariable String group, Model model) {
        Iterable<String> strs;
            CourseDTO crs = courseService.getByName(course);
            strs = groupService.getStudentsByCourseAndGroup(crs, group);
            model.addAttribute("messages", strs);
            return new ModelAndView("students");
    }

    @GetMapping("/course/{course}/group/{group}/student/{std}")
    public @ResponseBody ModelAndView get(@PathVariable String course, @PathVariable String group, @PathVariable String std, Model model) {
        Iterable<String> strs;
        CourseDTO crs = courseService.getByName(course);
        GroupDTO grp = groupService.getByName(group, crs.getId());
        strs = studentService.getMarksByName(grp.getId(), std);
        model.addAttribute("messages", strs);
        return new ModelAndView("marks");
    }

    @GetMapping("/course/{course}/group/{group}/student/{std}/stage/{stage}")
    public @ResponseBody ModelAndView get(@PathVariable String course, @PathVariable String group, @PathVariable String stage, @PathVariable String std, Model model) {
        Iterable<String> strs;
        CourseDTO crs = courseService.getByName(course);
        GroupDTO grp = groupService.getByName(group, crs.getId());
        StudentDTO stud = studentService.getStudentByGroupIdNameSurname(grp.getId(), std);
        studentService.changeStage(stud, stage);
        strs = studentService.getMarksByName(grp.getId(), std);
        model.addAttribute("messages", strs);
        return new ModelAndView("marks");
    }
}

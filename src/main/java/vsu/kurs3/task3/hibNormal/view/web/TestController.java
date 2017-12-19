package vsu.kurs3.task3.hibNormal.view.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vsu.kurs3.task3.hibNormal.models.services.CourseService;


@Controller
public class TestController {

    private final CourseService courseService;

    public TestController(CourseService courseService) {
        this.courseService = courseService;
    }

}
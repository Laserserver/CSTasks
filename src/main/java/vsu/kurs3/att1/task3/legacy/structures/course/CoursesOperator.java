package vsu.kurs3.att1.task3.legacy.structures.course;

import java.util.LinkedList;
import java.util.List;

public class CoursesOperator {
    private List<Course> courses;

    public CoursesOperator(){
        courses = new LinkedList<>();
    }

    public void addNewCourse(){
        courses.add(new Course(courses.size() + 1));
    }

    public List<String> getCoursesListAsText(){
        List<String> str = new LinkedList<>();
        courses.forEach(x -> str.add(x.toString()));
        return str;
    }

    public Course getCourseByName(String name){
        for (Course course : courses) {
            if (course.toString().equals(name))
                return course;
        }
        return null;
    }
}

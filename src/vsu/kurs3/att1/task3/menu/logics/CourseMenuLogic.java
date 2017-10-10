package vsu.kurs3.att1.task3.menu.logics;

import vsu.kurs3.att1.task3.menu.structuralMenus.CourseMenu;
import vsu.kurs3.att1.task3.structures.course.Course;

import java.util.LinkedList;
import java.util.List;

public class CourseMenuLogic {
    private CourseMenu crm;

    public CourseMenuLogic(){
        crm = new CourseMenu();
    }

    public int startCourseMenu(List<Course> crss, ECourseMenus type){
        int option = -1;
        crm.showTitleByEnum(type);
        switch (type){
            case Main:
                while(option < 1 || option > 3)
                    option = crm.showMainCourseMenu();
            case Editor:
                crm.printListedData("Присутствующие курсы: ", "курс", new LinkedList<>(crss));
                while(option < 1 || option > 4)
                    option = crm.showCourseEditorMenuOptions();
            case Creator:
                option = crm.showCourseCreatorMenuQuestion();
            case Selector:
                break;
        }
        return option;
    }
}

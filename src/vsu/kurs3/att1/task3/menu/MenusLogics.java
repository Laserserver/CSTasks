package vsu.kurs3.att1.task3.menu;

import vsu.kurs3.att1.task3.menu.enums.ECourseMenus;
import vsu.kurs3.att1.task3.menu.logics.CourseMenuLogic;
import vsu.kurs3.att1.task3.menu.logics.MainMenuLogic;
import vsu.kurs3.att1.task3.menu.specialMenus.menuCore.ParentMenu;
import vsu.kurs3.att1.task3.menu.structuralMenus.GroupMenu;
import vsu.kurs3.att1.task3.menu.structuralMenus.StudentMenu;
import vsu.kurs3.att1.task3.structures.Course;
import vsu.kurs3.att1.task3.structures.Group;

import java.util.LinkedList;
import java.util.List;

public class MenusLogics {

    private CourseMenuLogic crl;
    private GroupMenu grm;
    private StudentMenu stm;
    private MainMenuLogic mml;
    private List<Course> courses;

    private List<ParentMenu> menus;

    public MenusLogics(List<Course> courses){
        menus = new LinkedList<>();
        this.courses = courses;
        crl = new CourseMenuLogic();
        grm = new GroupMenu();
        stm = new StudentMenu();
        mml = new MainMenuLogic();
    }

    public void startWork(){
        int option = -1;
        while(option != 3){
            option = mml.startMainMenu();
            processMainMenuNumber(option);
        }
        mml.showExitMenu();
    }

    private void processMainMenuNumber(int num){
        if(num == 1)
            processCourseRedactorSelection();
        else
            processMarksRedactorSelection();
    }

    private void processCourseRedactorSelection(){
        int option = -1;
        while(option != 3){
            option = crl.startCourseMenu(courses, ECourseMenus.Main);
            switch (option){
                case 1:
                    crl.startCourseMenu(courses, ECourseMenus.Creator);
                    break;
                case 2:
                    crl.startCourseMenu(courses, ECourseMenus.Editor);
                    break;
                case 3:
                    break;
            }
        }
        mml.showExitMenu();
    }

    private void processMarksRedactorSelection(){

    }

    private Course getCourseByNum(int num){
        return courses.get(num + 1);
    }

    private Group getGroupByNum(Course c, int num){

    }
}

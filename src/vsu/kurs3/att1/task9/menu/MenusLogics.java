package vsu.kurs3.att1.task9.menu;

import vsu.kurs3.att1.task9.menu.enums.ECourseMenus;
import vsu.kurs3.att1.task9.menu.logics.CourseMenuLogic;
import vsu.kurs3.att1.task9.menu.logics.MainMenuLogic;
import vsu.kurs3.att1.task9.menu.structuralMenus.CourseMenu;
import vsu.kurs3.att1.task9.menu.structuralMenus.GroupMenu;
import vsu.kurs3.att1.task9.menu.structuralMenus.IShowable;
import vsu.kurs3.att1.task9.menu.structuralMenus.StudentMenu;
import vsu.kurs3.att1.task9.structures.Course;

import java.util.LinkedList;
import java.util.List;

public class MenusLogics {

    private CourseMenuLogic crl;
    private GroupMenu grm;
    private StudentMenu stm;
    private MainMenuLogic mml;
    private List<Course> courses;

    private List<IShowable> menus;

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

    public void mainMenu(){
        int option = -1;
        while(option != 3) {
            option = mmn.startMainMenu();
            if(option < 1 || option > 3)
                continue;
            switch (option){
                case 1:
                    invokeCourseMenu()
            }
        }
    }

}

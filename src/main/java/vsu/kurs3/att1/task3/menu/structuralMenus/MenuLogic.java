package vsu.kurs3.att1.task3.menu.structuralMenus;

import vsu.kurs3.att1.task3.menu.enums.EMenuCode;
import vsu.kurs3.att1.task3.structures.course.Course;
import vsu.kurs3.att1.task3.structures.course.CoursesOperator;
import vsu.kurs3.att1.task3.menu.specialMenus.menuCore.ParentMenu;
import vsu.kurs3.att1.task3.structures.group.Group;
import vsu.kurs3.att1.task3.structures.group.GroupsOperator;
import vsu.kurs3.att1.task3.structures.student.MarksOperator;
import vsu.kurs3.att1.task3.structures.student.Student;
import vsu.kurs3.att1.task3.structures.student.StudentsOperator;

import java.util.LinkedList;
import java.util.List;

public class MenuLogic {

    private CoursesOperator coursesOperator;
    private List<ParentMenu> menus;
    public MenuLogic(CoursesOperator courseOp, List<ParentMenu> menus){
        coursesOperator = courseOp;
        this.menus = menus;
    }

    public boolean start(){
       int option = (Integer) menus.get(EMenuCode.MenuMain.getValueOfEnum()).showMenu(null);
       switch(option){
           case 1:
               operateMainLeftBranch();
               return true;
           case 2:
               operateMainRightBranch();
               return true;
           case 3:
               return false;
       }
       return true;
    }

    private void operateMainRightBranch(){
        ParentMenu pm = menus.get(EMenuCode.SelectCourseMenu.getValueOfEnum());
        String st = (String) pm.showMenu(new LinkedList<>(coursesOperator.getCoursesListAsText()));
        Course crs = coursesOperator.getCourseByName(st);
        if(crs == null)
            return;
        GroupsOperator gr = crs.getGroupsOperator();
        pm = menus.get(EMenuCode.SelectGroupMenu.getValueOfEnum());
        st = (String) pm.showMenu(new LinkedList<>(gr.getGroupNamesAsText()));
        Group grp = gr.getGroupByName(st);
        if(grp == null)
            return;
        StudentsOperator std = grp.getStudentsOperator();
        pm = menus.get(EMenuCode.SelectStudentMenu.getValueOfEnum());
        st = (String) pm.showMenu(new LinkedList<>(std.getStudentNamesList()));
        Student stdn = std.getStudentByName(st);
        if(stdn == null)
            return;
        MarksOperator mo = stdn.getMarksOperator();
        pm = menus.get(EMenuCode.SelectStageMenu.getValueOfEnum());
        st = (String) pm.showMenu(new LinkedList<>(mo.getMarksAsText()));
        pm = menus.get(EMenuCode.SetStageMenu.getValueOfEnum());
        String str = (String) pm.showMenu(null);
        boolean mark = str.equals("сдано");
        switch(st){
            case "1 этап":
                if(str.equals("сдано"))
                    mo.changeStage(0, mark);
                break;
            case "2 этап":
                if(str.equals("сдано"))
                    mo.changeStage(1, mark);
                break;
            case "3 этап":
                if(str.equals("сдано"))
                    mo.changeStage(2, mark);
                break;
        }
    }

    private void operateMainLeftBranch(){
        int option = -1;
        while(option != 3) {
            option = (Integer) menus.get(EMenuCode.CourseMainMenu.getValueOfEnum()).showMenu(null);
            switch (option) {
                case 1:
                    operateCourseLeftBranch();
                    break;
                case 2:
                    operateCourseRightBranch();
                    break;
            }
        }
    }

    private void operateCourseLeftBranch(){
        menus.get(EMenuCode.CourseCreatorMenu.getValueOfEnum()).
                showMenu(new LinkedList<>(coursesOperator.getCoursesListAsText()));
        int option = (Integer) menus.get(EMenuCode.CourseCreatorChoiceMenu.
                getValueOfEnum()).showMenu(null);
        if(option == 1)
            coursesOperator.addNewCourse();
    }

    private void operateCourseRightBranch(){
        ParentMenu pm = menus.get(EMenuCode.SelectCourseMenu.getValueOfEnum());
        String courseName = (String) pm.showMenu(new LinkedList<>(coursesOperator.getCoursesListAsText()));
        Course crs = coursesOperator.getCourseByName(courseName);
        if(crs == null)
            return;
        GroupsOperator c = crs.getGroupsOperator();
        int option = -1;
        while(option != 4) {
            pm = menus.get(EMenuCode.GroupMainMenu.getValueOfEnum());
            option = (Integer) pm.showMenu(null);
            switch (option) {
                case 1:
                    pm = menus.get(EMenuCode.GroupCreatorMenu.getValueOfEnum());
                    pm.showMenu(new LinkedList<>(c.getGroupNamesAsText()));
                    pm = menus.get(EMenuCode.GroupCreatorChoiceMenu.getValueOfEnum());
                    option = (Integer) pm.showMenu(null);
                    if (option == 1)
                        c.createGroup();
                    break;
                case 2:
                    pm = menus.get(EMenuCode.SelectGroupMenu.getValueOfEnum());
                    String name = (String) pm.showMenu(new LinkedList<>(c.getGroupNamesAsText()));
                    Group gr = c.getGroupByName(name);
                    if (gr != null)
                        operateGroupEditorBranch(gr.getStudentsOperator());
                    break;
                case 3:
                    pm = menus.get(EMenuCode.GroupDeleterMenu.getValueOfEnum());
                    name = (String) pm.showMenu(new LinkedList<>(c.getGroupNamesAsText()));
                    c.deleteGroup(c.getGroupByName(name));
                    break;
            }
        }
    }

    private void operateGroupEditorBranch(StudentsOperator sop){
        ParentMenu pm;
        int option = -1;
        while(option != 3) {
            pm = menus.get(EMenuCode.GroupEditorMenu.getValueOfEnum());
            option = (Integer) pm.showMenu(new LinkedList<>(sop.getStudentNamesList()));
            switch (option) {
                case 1:
                    pm = menus.get(EMenuCode.GroupCreateStudentMenu.getValueOfEnum());
                    LinkedList st = (LinkedList) pm.showMenu(new LinkedList<>(sop.getStudentNamesList()));
                    sop.insertStudent(sop.createStudent(st));
                    break;
                case 2:
                    pm = menus.get(EMenuCode.GroupStudentDeleterMenu.getValueOfEnum());
                    String name = (String) pm.showMenu(null);
                    sop.deleteStudent(sop.getStudentByName(name));
                    break;
            }
        }
    }
}

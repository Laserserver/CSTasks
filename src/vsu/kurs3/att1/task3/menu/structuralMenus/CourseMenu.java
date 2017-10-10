package vsu.kurs3.att1.task3.menu.structuralMenus;

import vsu.kurs3.att1.task3.menu.enums.EMenuCode;
import vsu.kurs3.att1.task3.structures.course.CoursesOperator;
import vsu.kurs3.att1.task3.menu.specialMenus.menuCore.ParentMenu;
import vsu.kurs3.att1.task3.structures.group.GroupsOperator;
import vsu.kurs3.att1.task3.structures.student.MarksOperator;
import vsu.kurs3.att1.task3.structures.student.StudentsOperator;

import java.util.LinkedList;
import java.util.List;

public class CourseMenu {

    private CoursesOperator coursesOperator;
    private List<ParentMenu> menus;
    public CourseMenu(CoursesOperator courseOp, List<ParentMenu> menus){
        coursesOperator = courseOp;
        this.menus = menus;
    }

    public void start(){
       int option = (Integer) menus.get(EMenuCode.MenuMain.getValueOfEnum()).showMenu(null);
       switch(option){
           case 1:
               operateMainLeftBranch();
               break;
           case 2:
               operateMainRightBranch();
               break;
       }
    }

    private void operateMainRightBranch(){
        ParentMenu pm = menus.get(EMenuCode.SelectCourseMenu.getValueOfEnum());
        String st = (String) pm.showMenu(new LinkedList<>(coursesOperator.getCoursesListAsText()));
        GroupsOperator gr = coursesOperator.getCourseByName(st).getGroupsOperator();
        pm = menus.get(EMenuCode.SelectGroupMenu.getValueOfEnum());
        pm.showMenu(new LinkedList<>(gr.getGroupNamesAsText()));
        StudentsOperator std = gr.getGroupByName(st).getStudentsOperator();
        pm = menus.get(EMenuCode.SelectStudentMenu.getValueOfEnum());
        st = (String) pm.showMenu(new LinkedList<>(std.getStudentNamesList()));
        MarksOperator mo = std.getStudentByName(st).getMarksOperator();
        pm = menus.get(EMenuCode.SelectStageMenu.getValueOfEnum());
        st = (String) pm.showMenu(new LinkedList<>(mo.getMarksAsText()));
        pm = menus.get(EMenuCode.SetStageMenu.getValueOfEnum());
        String str = (String) pm.showMenu(null);
        switch(st){
            case "1 этап":
                if(str.equals("сдано"))
                    mo.changeStage(0, true);
                else if(str.equals("не сдано"))
                    mo.changeStage(0, false);
                break;
            case "2 этап":
                if(str.equals("сдано"))
                    mo.changeStage(0, true);
                else if(str.equals("не сдано"))
                    mo.changeStage(0, false);
                break;
            case "3 этап":
                if(str.equals("сдано"))
                    mo.changeStage(0, true);
                else if(str.equals("не сдано"))
                    mo.changeStage(0, false);
                break;
        }
    }

    private void operateMainLeftBranch(){
        int option = (Integer) menus.get(EMenuCode.CourseMainMenu.getValueOfEnum()).showMenu(null);
        switch(option){
            case 1:
                operateCourseLeftBranch();
                break;
            case 2:
                operateCourseRightBranch();
                break;
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
        GroupsOperator c = coursesOperator.getCourseByName(courseName).getGroupsOperator();
        pm = menus.get(EMenuCode.GroupMainMenu.getValueOfEnum());
        int option = (Integer) pm.showMenu(null);

        switch(option){
            case 1:
                pm = menus.get(EMenuCode.GroupCreatorMenu.getValueOfEnum());
                pm.showMenu(new LinkedList<>(c.getGroupNamesAsText()));
                pm = menus.get(EMenuCode.GroupCreatorChoiceMenu.getValueOfEnum());
                option = (Integer) pm.showMenu(null);
                if(option == 1)
                    c.createGroup();
                break;
            case 2:
                pm = menus.get(EMenuCode.SelectGroupMenu.getValueOfEnum());
                String name = (String) pm.showMenu(new LinkedList<>(c.getGroupNamesAsText()));
                operateGroupEditorBranch(c.getGroupByName(name).getStudentsOperator());
                break;
            case 3:
                pm = menus.get(EMenuCode.GroupDeleterMenu.getValueOfEnum());
                name = (String) pm.showMenu(new LinkedList<>(c.getGroupNamesAsText()));
                c.deleteGroup(c.getGroupByName(name));
                break;
        }
    }

    private void operateGroupEditorBranch(StudentsOperator sop){
        ParentMenu pm = menus.get(EMenuCode.GroupEditorMenu.getValueOfEnum());
        int option = (Integer) pm.showMenu(new LinkedList<>(sop.getStudentNamesList()));
        switch(option){
            case 1:
                pm = menus.get(EMenuCode.GroupStudentCreatorMenu.getValueOfEnum());
                option = (int) pm.showMenu(null);
                pm = menus.get(EMenuCode.StudentCreatorMenu.getValueOfEnum());
                if(option == 1){
                    LinkedList st = (LinkedList) pm.showMenu(null);
                    sop.insertStudent(sop.createStudent(st));
                }
                break;
            case 2:
                pm = menus.get(EMenuCode.GroupStudentDeleterMenu.getValueOfEnum());
                String name = (String) pm.showMenu(null);
                sop.deleteStudent(sop.getStudentByName(name));
                break;
        }
    }
}

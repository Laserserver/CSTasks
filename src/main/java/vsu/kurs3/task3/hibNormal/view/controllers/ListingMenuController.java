package vsu.kurs3.task3.hibNormal.view.controllers;

import vsu.kurs3.task3.hibNormal.view.EMenuCodes;
import vsu.kurs3.task3.hibNormal.view.menus.Menu;

import java.util.LinkedList;
import java.util.List;

public class ListingMenuController {
    private List<Menu> menus;

    public ListingMenuController(List<Menu> menus){
        this.menus = menus;
    }

    public Object showMenu(EMenuCodes code, List<String> strings){
        switch (code){
            case CreateCourseMenu:
            case CreateGroupMenu:
            case DeleteGroupMenu:
                menus.get(code.getValueOfEnum()).showMenu(strings);
                return menus.get(code.getValueOfEnum() + 1).showMenu(strings);
            case CreateStudentMenu:
            case DeleteStudentMenu:
                List<Object> tuple = new LinkedList<>();
                tuple.add(menus.get(code.getValueOfEnum()).showMenu(strings));
                tuple.add(menus.get(code.getValueOfEnum() + 1).showMenu(strings));
                return tuple;
            case SelectCourseMenu:
            case SelectGroupMenu:
            case SelectStudentMenu:
            case SelectStageMenu:
                menus.get(code.getValueOfEnum()).showMenu(strings);
                return menus.get(code.getValueOfEnum() + 1).showMenu(strings);
        }
        return null;
    }
}

package vsu.kurs3.task3.hibNormal.view.logics;

import vsu.kurs3.task3.hibNormal.view.EMenuCodes;
import vsu.kurs3.task3.hibNormal.view.menus.*;

import java.util.LinkedList;
import java.util.List;

public class MenuFabric {

    private List<Menu> menus;
    public MenuFabric(){
        menus = new LinkedList<>();
        EMenuCodes[] codes = EMenuCodes.values();

        for(EMenuCodes code: codes){
            menus.add(createMenu(code));
        }
    }

    private Menu createMenu(EMenuCodes code){
        switch (code){

            case MenuMain:
                return new JunctionMenu(code);
            case SelectCourseChoiceMenu:
            case SelectGroupChoiceMenu:
            case SelectStageChoiceMenu:
            case SelectStudentChoiceMenu:
                return new SelectorMenu(code);
            case CreateCourseMenu:
            case CreateGroupMenu:
            case DeleteGroupMenu:
            case SelectCourseMenu:
            case SelectGroupMenu:
            case SelectStageMenu:
            case SelectStudentMenu:
                return new ListingMenu(code);   // Названо так, потому что выводит список
            case CreateStudentMenu:
            case DeleteStudentMenu:
                return new StudentMenu(code);   // У студентских меню логика посложнее
            case CreateCourseChoiceMenu:
            case CreateGroupChoiceMenu:
            case CreateStudentChoiceMenu:
            case DeleteGroupChoiceMenu:
            case DeleteStudentChoiceMenu:
                return new ChoiceMenu(code);    // Эти предоставляют выбор 0 или 1
            case AlterStageMenu:
                return new MarksMenu();         // Это просто число от 1 до 3 должно вернуть
            case JunctionSelectCourseMenu:
            case JunctionSelectGroupMenu:
            case JunctionSelectStudentMenu:
                return new JunctionMenu(code);
        }
        return null;
    }

    public List<Menu> getMenusList(){
        return menus;
    }

    public Menu getMenu(EMenuCodes code){
        return menus.get(code.getValueOfEnum());
    }
}
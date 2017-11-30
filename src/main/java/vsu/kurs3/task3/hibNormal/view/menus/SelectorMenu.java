package vsu.kurs3.task3.hibNormal.view.menus;


import vsu.kurs3.task3.hibNormal.view.EMenuCodes;

import java.util.List;

public class SelectorMenu extends Menu {
    public SelectorMenu(EMenuCodes code){
        header = "";
        switch(code){
            case SelectCourseChoiceMenu:
                text = "Выберите курс: ";
                break;
            case SelectGroupChoiceMenu:
                text = "Выберите группу: ";
                break;
            case SelectStudentChoiceMenu:
                text = "Выберите студента: ";
                break;
            case SelectStageChoiceMenu:
                text = "Выберите этап: ";
                break;
        }
    }

    @Override
    public Object showMenu(List<String> strings){
        System.out.println("===============");
        System.out.println(text);
        return s.nextLine();
    }
}

package vsu.kurs3.att1.task3.menu.specialMenus;

import vsu.kurs3.att1.task3.menu.enums.EMenuCode;
import vsu.kurs3.att1.task3.menu.specialMenus.menuCore.ParentMenu;

import java.util.List;

public class SelectorMenu extends ParentMenu {

    private String text;

    //4 меню-селектора воз
    public SelectorMenu(EMenuCode code){
        switch (code){
            case SelectCourseMenu:
                text = "Выберите курс: ";
                break;
            case SelectGroupMenu:
                text = "Выберите группу: ";
                break;
            case SelectStudentMenu:
                text = "Выберите студента: ";
                break;
            case SelectStageMenu:
                text = "Выберите этап: ";
                break;
        }
    }

    @Override
    public Object showMenu(List<Object> args) {
        System.out.println(text);
        return s.nextLine();
    }
}

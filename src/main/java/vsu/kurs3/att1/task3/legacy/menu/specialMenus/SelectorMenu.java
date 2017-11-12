package vsu.kurs3.att1.task3.legacy.menu.specialMenus;

import vsu.kurs3.att1.task3.legacy.menu.enums.EMenuCode;
import vsu.kurs3.att1.task3.legacy.menu.specialMenus.menuCore.ParentMenu;

import java.util.List;

public class SelectorMenu extends ParentMenu {

    private String text;

    //4 меню-селектора выбора
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
            case SetStageMenu:
                text = "Введите вариант оценки (сдано/не сдано): ";
                break;
        }
    }

    @Override
    public Object showMenu(List<Object> args) {
        System.out.println(text);
        if(args != null)
            args.forEach(x->System.out.println(x.toString()));
        return s.nextLine();
    }
}

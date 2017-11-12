package vsu.kurs3.att1.task3.legacy.menu.specialMenus;

import vsu.kurs3.att1.task3.legacy.menu.enums.EMenuCode;
import vsu.kurs3.att1.task3.legacy.menu.specialMenus.menuCore.ParentMenu;

import java.util.List;

public class StringChoiceMenu extends ParentMenu {
    private String text = "Действительно ли вы хотите ";
    private EMenuCode code;

    public StringChoiceMenu(EMenuCode code) {
        this.code = code;
        switch (code) {
            case CourseCreatorChoiceMenu:
                text += "создать курс?";
                break;
            case GroupCreatorChoiceMenu:
                text += "создать группу?";
                break;
            case MarksChoiceMenu:
                text = "Введите нужный этап: ";
                break;
            case GroupDeleterMenu:
                text = "Введите удаляемую группу: ";
                break;
            case GroupStudentDeleterMenu:
                text = "Введите удаляемого студента: ";
                break;
            case GroupCreateStudentMenu:
                text += "добавить нового студента?";
        }
    }

    @Override
    public Object showMenu(List<Object> args) {
        System.out.println(text);
        switch(code){
            case CourseCreatorChoiceMenu:
            case GroupCreatorChoiceMenu:
            case GroupCreateStudentMenu:
                return super.startAbstractActionQuestionMenu();
            case MarksChoiceMenu:
            case GroupDeleterMenu:
            case GroupStudentDeleterMenu:
                return s.nextLine();
        }
        return -1;
    }
}

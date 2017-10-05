package vsu.kurs3.att1.task3.menu.specialMenus;

import vsu.kurs3.att1.task3.menu.enums.EMenuCode;
import vsu.kurs3.att1.task3.menu.specialMenus.menuCore.ParentMenu;

import java.util.List;

public class StringChoiceMenu extends ParentMenu {
    private String text = "Действительно ли вы хотите ";

    public StringChoiceMenu(EMenuCode code) {
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
        }
    }

    @Override
    public Object showMenu(List<Object> args) {
        System.out.println(text);
        return s.nextLine();
    }

}

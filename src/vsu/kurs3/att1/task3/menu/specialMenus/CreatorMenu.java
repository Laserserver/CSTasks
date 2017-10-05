package vsu.kurs3.att1.task3.menu.specialMenus;

import vsu.kurs3.att1.task3.menu.enums.EMenuCode;
import vsu.kurs3.att1.task3.menu.specialMenus.menuCore.ParentMenu;

import java.util.List;

public class CreatorMenu extends ParentMenu {
    private String title;
    private String addText;

    public CreatorMenu(EMenuCode code){
        switch (code){
            case CourseCreatorMenu:
                title = "СОЗДАНИЕ КУРСА: \n======";
                addText = "курсы:";
                break;
            case GroupCreateStudentMenu:
                title = "СОЗДАНИЕ СТУДЕНТА: \n======";
                addText = "студенты:";
                break;
            case GroupCreatorMenu:
                title = "СОЗДАНИЕ ГРУППЫ: \n======";
                addText = "группы:";
                break;
        }
    }

    @Override
    public Object showMenu(List<Object> args) {
        System.out.println(title);
        printListedData("Присутствующие " + addText, args);
        return 1;
    }
}

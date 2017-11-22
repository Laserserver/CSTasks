package vsu.kurs3.task3.legacy.menu.specialMenus;

import vsu.kurs3.task3.legacy.menu.enums.EMenuCode;
import vsu.kurs3.task3.legacy.menu.specialMenus.menuCore.ParentMenu;

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

package vsu.kurs3.task3.hibNormal.view.menus;


import vsu.kurs3.task3.hibNormal.view.EMenuCodes;

import java.util.List;

public class ListingMenu extends Menu {

    public ListingMenu(EMenuCodes code){
        switch (code){
            case CreateCourseMenu:
                header = "СОЗДАНИЕ КУРСА:";
                text = "Присутствующие курсы:";
                break;
            case CreateGroupMenu:
                header = "СОЗДАНИЕ ГРУППЫ:";
                text = "Присутствующие группы:";
                break;
            case DeleteGroupMenu:
                header = "УДАЛЕНИЕ ГРУППЫ:";
                text = "Присутствующие группы:";
                break;
            case SelectCourseMenu:
                header = "ВЫБОР КУРСА:";
                text = "Присутствующие курсы:";
                break;
            case SelectGroupMenu:
                header = "ВЫБОР ГРУППЫ:";
                text = "Присутствующие группы:";
                break;
            case SelectStageMenu:
                header = "ВЫБОР ЭТАПА:";
                text = "Состояние этапов:";
                break;
            case SelectStudentMenu:
                header = "ВЫБОР СТУДЕНТА:";
                text = "Присутствующие студенты:";
                break;
        }
    }

    @Override
    public Object showMenu(List<String> strings) {
        System.out.println("===============");
        System.out.println(header);
        System.out.println("===============");
        System.out.println(text);
        if(strings != null)
            for(String item: strings)
                System.out.println(item);
        else
            System.out.println("Нет.");
        return -1;
    }
}

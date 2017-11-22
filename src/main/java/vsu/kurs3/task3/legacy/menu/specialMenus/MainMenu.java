package vsu.kurs3.task3.legacy.menu.specialMenus;

import vsu.kurs3.task3.legacy.menu.enums.EMenuCode;
import vsu.kurs3.task3.legacy.menu.specialMenus.menuCore.ParentMenu;

import java.util.LinkedList;
import java.util.List;

public class MainMenu extends ParentMenu {

    String title;
    List<String> lines;
    int optionMax;

    
    public MainMenu(EMenuCode code){
        lines = new LinkedList<>();
        switch (code){
            case MenuMain:
                title = "ИНФОРМАТИКА";
                lines.add("Выберите пункт: ");
                lines.add("     1. Редактор курсов и групп");
                lines.add("     2. Редактор оценок");
                lines.add("     3. Выход");

                optionMax = 3;
                break;
            case MarksMainMenu:
                title = "ИЗМЕНЕНИЕ ОЦЕНОК: ";
                lines.add("Порядок действий: ");
                lines.add("     Выбрать курс.");
                lines.add("     Выбрать группу.");
                lines.add("     Выбрать студента. ");
                lines.add("     Выбрать этап. ");
                optionMax = 0;
                break;
            case CourseMainMenu:
                title = "РЕДАКТОР КУРСОВ: ";
                lines.add("Выберите пункт: ");
                lines.add("     1. Создать курс.");
                lines.add("     2. Изменить курс.");
                lines.add("     3. Выход. ");
                optionMax = 3;
                break;
            case GroupMainMenu:
                title = "РЕДАКТОР ГРУПП: ";
                lines.add("Выберите операцию:");
                lines.add("    1. Создание группы. ");
                lines.add("    2. Изменение группы. ");
                lines.add("    3. Удаление группы. ");
                lines.add("    4. Выход. ");
                optionMax = 4;
                break;
        }
    }

    @Override
    public Object showMenu(List<Object> args){  //args не используется
        System.out.println(title);
        lines.forEach(System.out::println);
        if(optionMax != 0){
            int option = startNumSelectionMenu();
            if(option == optionMax)
                System.out.println("Выходим.");
            return option;
        }
        return -1;
    }
    
}

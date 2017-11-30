package vsu.kurs3.task3.hibNormal.view.menus;

import vsu.kurs3.task3.hibNormal.view.EMenuCodes;

import java.util.LinkedList;
import java.util.List;

public class JunctionMenu extends Menu {

    private List<String> strings;
    public JunctionMenu(EMenuCodes code){
        strings = new LinkedList<>();

        switch(code){
            case MenuMain:
                header = "ИНФОРМАТИКА:";
                text = "Выберите действие:";
                strings.add("1. Создать курс");
                strings.add("2. Выбрать курс");
                strings.add("3. Выход");
                break;
            case JunctionSelectCourseMenu:
                header = "ВЫБРАН КУРС:";
                text = "Выберите действие:";
                strings.add("1. Создать группу");
                strings.add("2. Выбрать группу");
                strings.add("3. Выход");
                break;
            case JunctionSelectGroupMenu:
                header = "ВЫБРАНА ГРУППА:";
                text = "Выберите действие:";
                strings.add("1. Создать студента");
                strings.add("2. Выбрать студента");
                strings.add("3. Удалить группу");
                strings.add("4. Выход");
                break;
            case JunctionSelectStudentMenu:
                header = "ВЫБРАН СТУДЕНТ:";
                text = "Выберите действие:";
                strings.add("1. Выбрать этап");
                strings.add("2. Удалить студента");
                strings.add("3. Выход");
                break;
        }

    }

    @Override
    public Object showMenu(List<String> strings) {
        System.out.println("===============");
        System.out.println(header);
        if(strings != null)
            System.out.println(strings.get(0));
        System.out.println("===============");
        System.out.println(text);
        for(String str: this.strings){
            System.out.println(str);
        }
        return startNumSelectionMenu();
    }
}

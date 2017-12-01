package vsu.kurs3.task3.hibNormal.view.menus;

import vsu.kurs3.task3.hibNormal.view.EMenuCodes;

import java.util.LinkedList;
import java.util.List;

public class StudentMenu extends Menu {

    public StudentMenu(EMenuCodes code){
        text = "Присутствующие студенты:";
        switch (code){
            case DeleteStudentMenu:
                header = "УДАЛЕНИЕ СТУДЕНТА:";
                break;
            case CreateStudentMenu:
                header = "ДОБАВЛЕНИЕ СТУДЕНТА:";
                break;
            case SelectStudentMenu:
                header = "ВЫБОР СТУДЕНТА:";
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
        List<String> tuple = new LinkedList<>();
        System.out.println("Введите имя >> ");
        tuple.add(s.nextLine());
        System.out.println("Введите фамилию >> ");
        tuple.add(s.nextLine());
        return tuple;
    }
}

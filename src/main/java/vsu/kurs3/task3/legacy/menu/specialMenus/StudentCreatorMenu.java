package vsu.kurs3.task3.legacy.menu.specialMenus;

import vsu.kurs3.task3.legacy.menu.specialMenus.menuCore.ParentMenu;

import java.util.LinkedList;
import java.util.List;

public class StudentCreatorMenu extends ParentMenu {

    private List<String> tuple;
    public StudentCreatorMenu(){
        tuple = new LinkedList<>();
    }

    @Override
    public Object showMenu(List<Object> args){
        System.out.println("Введите имя >> ");
        //s.nextLine();
        tuple.add(s.nextLine());
        System.out.println("Введите фамилию >> ");
        tuple.add(s.nextLine());
        return tuple;
    }
}

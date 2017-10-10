package vsu.kurs3.att1.task3.menu.specialMenus;

import javafx.scene.Parent;
import vsu.kurs3.att1.task3.menu.specialMenus.menuCore.ParentMenu;

import java.util.LinkedList;
import java.util.List;

public class StudentCreatorMenu extends ParentMenu {

    private List<String> tuple;
    public StudentCreatorMenu(){
        tuple = new LinkedList<>();
    }

    @Override
    public Object showMenu(List<Object> args){
        System.out.print("Введите имя >> ");
        s.nextLine();
        tuple.add(s.nextLine());
        System.out.print("Введите фамилию >> ");
        tuple.add(s.nextLine());
        return tuple;
    }
}

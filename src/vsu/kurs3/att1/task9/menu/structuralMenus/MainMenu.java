package vsu.kurs3.att1.task9.menu.structuralMenus;

import java.util.List;

public class MainMenu extends ParentMenu {

    @Override
    public int showMenu(List<Object> args){
        System.out.println("ИНФОРМАТИКА \n======");
        System.out.println("Выберите пункт: ");
        System.out.println("     1. Редактор курсов и групп");
        System.out.println("     2. Редактор оценок");
        System.out.println("     3. Выход");
        int option = startNumSelectionMenu();
        if(option == 3)
            System.out.println("Выходим.");
        return option;
    }
}

package vsu.kurs3.task3.hibNormal.view.menus;

import java.util.List;

public class MarksMenu extends Menu {

    public MarksMenu(){
        header = "";
        text = "Выберите этап:";
    }

    @Override
    public Object showMenu(List<String> strings) {
        System.out.println("===============");
        System.out.println(text);  //По идее, должно быть 1 - 3
        return startNumSelectionMenu();
    }

}

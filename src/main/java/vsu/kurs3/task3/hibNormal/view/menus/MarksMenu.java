package vsu.kurs3.task3.hibNormal.view.menus;

import java.util.List;

public class MarksMenu extends Menu {

    public MarksMenu(){
        header = "";
        text = "Выберите изменяемый этап:";
    }


    public Object showMenu(List<String> strings) {
        System.out.println("===============");
        System.out.println(text);  //По идее, должно быть 1 - 3
        for(int i = 1; i < 4; i++) {
           System.out.println(i + " этап: " + (Boolean.getBoolean(strings.get(i - 1)) ? "Сдан" : "Не сдан"));
        }
        return startNumSelectionMenu();
    }

}

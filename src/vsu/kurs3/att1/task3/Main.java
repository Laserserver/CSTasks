package vsu.kurs3.att1.task3;

import vsu.kurs3.att1.task3.menu.enums.EMenuCode;
import vsu.kurs3.att1.task3.menu.logics.MenuFabric;
import vsu.kurs3.att1.task3.menu.specialMenus.menuCore.ParentMenu;
import vsu.kurs3.att1.task3.structures.course.Course;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Menu();
    }

    private static void Menu() {
        List<ParentMenu> menus = new LinkedList<>();
        MenuFabric mf = new MenuFabric();
        EMenuCode[] codes = EMenuCode.values();
        List<Course> courses = new LinkedList<>();

        for (EMenuCode code : codes) menus.add(mf.createMenu(code));

        ParentMenu current = menus.get(EMenuCode.MenuMain.getValueOfEnum());

        while (true)
        {
            int option = (Integer)current.showMenu(new LinkedList<>(courses));
            switch(option){
                case 1:
                    //current =
                    break;
                case 2:

                    break;
                case 3:

                    break;
            }
        }
    }
}

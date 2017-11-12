package vsu.kurs3.att1.task3;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import vsu.kurs3.att1.task3.legacy.menu.structuralMenus.MenuLogic;
import vsu.kurs3.att1.task3.legacy.structures.course.CoursesOperator;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
	    Menu();
    }

    private static void Menu() {

        MenuLogic menuLogic = new MenuLogic(new CoursesOperator());

        boolean flag = true;
        while(flag){
            flag = menuLogic.start();
        }
    }
}

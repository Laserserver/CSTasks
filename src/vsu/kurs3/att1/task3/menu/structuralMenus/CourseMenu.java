package vsu.kurs3.att1.task3.menu.structuralMenus;

import vsu.kurs3.att1.task3.menu.enums.ECourseMenus;
import vsu.kurs3.att1.task3.menu.specialMenus.menuCore.ParentMenu;

public class CourseMenu extends ParentMenu {

    public CourseMenu(){
        super();
    }

    public void showTitleByEnum(ECourseMenus type){
        switch (type){
            case Creator:
                System.out.println("СОЗДАНИЕ КУРСА: \n======");
                break;
            case Editor:
                System.out.println("ИЗМЕНЕНИЕ КУРСА: \n======");
                break;
            case Main:
                System.out.println("МЕНЮ КУРСОВ: \n======");
                break;
            case Selector:
                System.out.println("ВЫБОР КУРСА: \n======");
        }
    }

    public int showMainCourseMenu(){
        System.out.println("Выберите пункт: ");
        System.out.println("     1. Создать курс.");
        System.out.println("     2. Изменить курс.");
        System.out.println("     3. Выход. ");
        return startNumSelectionMenu();
    }

    public int showCourseCreatorMenuQuestion(){
        return startAbstractActionQuestionMenu("создать", "новый курс");
    }

    public int selectCourse(){
        return startNumSelectionMenu();
    }

    public int showCourseEditorMenuOptions(){
        System.out.println("Выберите операцию:");
        System.out.println("    1. Создать группу. ");
        System.out.println("    2. Изменить группу. ");
        System.out.println("    3. Удалить группу. ");
        System.out.println("    4. Выход. ");
        return startNumSelectionMenu();
    }
}

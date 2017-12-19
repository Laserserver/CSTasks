package vsu.kurs3.task3.hibNormal.view.console.menus;

import vsu.kurs3.task3.hibNormal.view.console.EMenuCodes;

import java.util.List;

public class ChoiceMenu extends Menu {

    public ChoiceMenu(EMenuCodes code){
        header = "";
        switch(code){
            case CreateCourseChoiceMenu:
                text = "Подтвердите создание курса:";
                break;
            case CreateGroupChoiceMenu:
                text = "Подтвердите создание группы:";
                break;
            case CreateStudentChoiceMenu:
                text = "Подтвердите добавление студента:";
                break;
            case DeleteGroupChoiceMenu:
                text = "Подтвердите удаление группы:";
                break;
            case DeleteStudentChoiceMenu:
                text = "Подтвердите удаление студента:";
                break;
            case AddStudentChoiceMenu:
                text = "Добавить ещё одного студента?";
                break;
        }
    }

    @Override
    public Object showMenu(List<String> strings){
        System.out.println("===============");
        System.out.println(text);
        System.out.println("Да  - 1");
        System.out.println("Нет - 2");
        return startNumSelectionMenu();
    }
}

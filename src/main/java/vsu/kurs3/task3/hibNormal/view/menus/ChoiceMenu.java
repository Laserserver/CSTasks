package vsu.kurs3.task3.hibNormal.view.menus;

import vsu.kurs3.task3.hibNormal.view.EMenuCodes;

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
            case AddGroupChoiceMenu:
                text = "Добавить ещё одну группу?";
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
        System.out.println("Да  - 0");
        System.out.println("Нет - 1");
        return startNumSelectionMenu();
    }
}

package vsu.kurs3.att1.task9.menu.structuralMenus;

import java.util.List;

public class GroupMenu extends ParentMenu {

    public GroupMenu(){
        super();
    }

    private List<String> studentNames;
    public void initStudentList(List<String> sts){
        studentNames = sts;
    }

    public void showGroupStudentsList(){
        System.out.println("Список студентов: ");
        studentNames.forEach(System.out::println);           //<< предложила идея
    }

    public int showGroupCreatorMenu(){
        System.out.println("Создание группы: ");
        return startAbstractActionQuestionMenu("создать", "новую группу");
    }

    public void showGroupEditorMenu(){
        System.out.println("Изменение группы: ");
        System.out.println("    Выберите операцию: ");
        System.out.println("        1. Добавить студента.");
        System.out.println("        2. Удалить студента.");
        System.out.println("        3. Выход.");
    }

    public void showGroupDeleterMenu(){
        System.out.println("Удаление группы");
        System.out.print("  Вы действительно хотите удалить эту группу? Y\\N >> ");
    }
}

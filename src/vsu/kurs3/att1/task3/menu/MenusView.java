package vsu.kurs3.att1.task3.menu;

import vsu.kurs3.att1.task3.structures.course.Course;
import vsu.kurs3.att1.task3.structures.student.Student;

import java.util.List;
import java.util.Scanner;

public class MenusView {

    private Scanner s = new Scanner(System.in);

    public int startMainMenu(){
        int option;
        while(true){
            System.out.println("ИНФОРМАТИКА \n======");
            System.out.println("Выберите пункт: ");
            System.out.println("     1. Редактор курсов и групп");
            System.out.println("     2. Редактор оценок");
            System.out.println("     3. Выход");
            option = invokeNumSelection();
            if(option < 1 || option > 3)
                continue;
            return option;
        }
    }

    public int startMainCourseRedactorMenu(){
        int option;
        while(true){
            System.out.println("РЕДАКТОР КУРСОВ: \n======");
            System.out.println("Выберите пункт: ");
            System.out.println("     1. Создать курс.");
            System.out.println("     2. Изменить курс.");
            System.out.println("     3. Выход. ");
            option = invokeNumSelection();
            if(option < 1 || option > 3)
                continue;
            return option;
        }
    }

    private boolean startAbstractCreatorMenu(String action, String object)   //Опа какая абстракция
    {
        System.out.print(String.format("Вы действительно хотите %s %s? Y\\N >> ", action, object));
        return s.next().toLowerCase().equals("y");
    }

    public int startCourseEditorMenu(Course crs) {
        int option;
        List<Integer> grs = crs.getGroupsAsStrings();
        while(true) {
            System.out.println("ИЗМЕНЕНИЕ КУРСА: \n======");
            System.out.println("    Присутствующие группы: ");
            grs.forEach(x -> System.out.println(x + " группа."));
            System.out.println("Выберите операцию:");
            System.out.println("    1. Создать группу. ");
            System.out.println("    2. Изменить группу. ");
            System.out.println("    3. Удалить группу. ");
            System.out.println("    4. Выход. ");
            option = invokeNumSelection();
            if(option < 1 || option > 4)
                continue;
            return option;
        }
    }

    public boolean startGroupCreatorMenu(Course crs){
        System.out.println("Создание группы для курса " + crs.getCourseNum() + ':');
        return startAbstractCreatorMenu("создать","группу");
    }

    public int startGroupDeleterMenu()
    {
        int option;
        System.out.println("Удаление группы: ");
        System.out.println("Выберите номер группы: ");
        while(true)
        {
            option = invokeNumSelection();
            if(option < 1 || option > 3){
                System.out.println("Неверный номер. Еще раз.");
                continue;
            }
            return option;
        }
    }

    public int startGroupEditorMenu(List<String> sts){
        System.out.println("Изменение группы: ");
        System.out.println("Список студентов: ");
        sts.forEach(System.out::println);           //<< предложила идея
        int option;
        while (true) {
            System.out.println("    Выберите операцию: ");
            System.out.println("        1. Добавить студента.");
            System.out.println("        2. Удалить студента.");
            System.out.println("        3. Выход.");
            option = invokeNumSelection();
            if(option < 1 || option > 3){
                System.out.println("Неверный номер. Еще раз.");
                continue;
            }
            return option;
        }
    }

    public boolean startGroupInsertStudentMenu() {
        System.out.println("Добавление студента: ");
        return startAbstractCreatorMenu("добавить", "студента");
    }

    public boolean startGroupDeleteStudentMenu() {
        System.out.println("Удаление студента: ");
        return startAbstractCreatorMenu("удалить", "студента");
    }

    public boolean startCourseCreatorMenu(List<Course> lst){
        System.out.println("СОЗДАНИЕ КУРСА: \n======");
        System.out.println("    Присутствующие курсы: ");
        lst.forEach(x -> System.out.println(x.getCourseNum() + " курс."));
        return startAbstractCreatorMenu("добавить", "новый курс");
    }

    public int startStudentMenu(Student st){

        return 0;
    }

    private int invokeNumSelection()
    {
        if(!s.hasNextInt())
        {
            System.out.println("Еще раз, не введено число.");
            s.nextLine();
            return -1;
        }
        return s.nextInt();
    }
}

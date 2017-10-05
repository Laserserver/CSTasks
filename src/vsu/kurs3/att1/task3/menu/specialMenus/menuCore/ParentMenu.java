package vsu.kurs3.att1.task3.menu.specialMenus.menuCore;

import java.util.List;
import java.util.Scanner;

public class ParentMenu {

    protected Scanner s;

    public ParentMenu(){
        s = new Scanner(System.in);
    }
    public void printListedData(String mainText, List<Object> lst)
    {
        System.out.println(mainText);
        lst.forEach(x -> System.out.println(x.toString()));
    }

    protected int startAbstractActionQuestionMenu(String action, String object)   //Опа какая абстракция
    {
        System.out.print(String.format("Вы действительно хотите %s %s? Y\\N >> ", action, object));
        return s.next().toLowerCase().equals("y") ? 1 : 0;
    }

    protected int startNumSelectionMenu()
    {
        if(!s.hasNextInt())
        {
            System.out.println("Еще раз, не введено число.");
            s.nextLine();
            return -1;
        }
        return s.nextInt();
    }

    public Object showMenu(List<Object> args) {
        return 0;
    }
}

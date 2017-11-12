package vsu.kurs3.att1.task3.legacy.menu.specialMenus.menuCore;

import java.util.List;
import java.util.Scanner;

public class ParentMenu {

    protected Scanner s;

    protected ParentMenu(){

        s = new Scanner(System.in);
    }
    protected void printListedData(String mainText, List<Object> lst)
    {
        System.out.println(mainText);
        lst.forEach(x -> System.out.println(x.toString()));
    }

    protected int startAbstractActionQuestionMenu()   //Опа какая абстракция
    {
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
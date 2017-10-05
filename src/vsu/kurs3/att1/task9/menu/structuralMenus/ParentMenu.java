package vsu.kurs3.att1.task9.menu.structuralMenus;

import java.util.List;
import java.util.Scanner;

public class ParentMenu implements IShowable {

    Scanner s;

    ParentMenu(){
        s = new Scanner(System.in);
    }
    public void printListedData(String mainText, String addText, List<Object> lst)
    {
        System.out.println(mainText);
        lst.forEach(x -> System.out.println(String.format("%s %s.", x.toString(), addText)));
    }

    int startAbstractActionQuestionMenu(String action, String object)   //Опа какая абстракция
    {
        System.out.print(String.format("Вы действительно хотите %s %s? Y\\N >> ", action, object));
        return s.next().toLowerCase().equals("y") ? 1 : 0;
    }

    int startNumSelectionMenu()
    {
        if(!s.hasNextInt())
        {
            System.out.println("Еще раз, не введено число.");
            s.nextLine();
            return -1;
        }
        return s.nextInt();
    }

    @Override
    public int showMenu(List<Object> args) {
        return 0;
    }
}

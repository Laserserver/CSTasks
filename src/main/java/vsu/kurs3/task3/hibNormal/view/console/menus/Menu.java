package vsu.kurs3.task3.hibNormal.view.console.menus;

import java.util.List;
import java.util.Scanner;

public class Menu {

    Scanner s;
    String header;
    String text;

    protected Menu(){
        s = new Scanner(System.in);
    }

    public Object showMenu(List<String> strings){
        return null;
    }

    int startNumSelectionMenu()
    {
        System.out.print(">> ");
        if(!s.hasNextInt())
        {
            System.out.println("Еще раз, не введено число.");
            s.nextLine();
            return -1;
        }
        return s.nextInt();
    }
}
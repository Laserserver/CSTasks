package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Menu();
    }

    private static void Menu()
    {
        Scanner s = new Scanner(System.in);
        while (true)
        {
            System.out.println("ИНФОРМАТИКА");

            System.out.println("Выберите пункт: ");
            System.out.println("     1. Редактор списка групп");
            System.out.println("     2. Редактор оценок");
            System.out.println("     3. Выход");
            if(!s.hasNextInt())
            {
                System.out.println("Еще раз, не введено число.");
                s.nextLine();
                continue;
            }
            int option = s.nextInt();
            switch (option)
            {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Выходим.");
                    break;
                default:
                    System.out.println("Еще раз, неверное число: " + option);
                    continue;
            }
            break;
        }
    }
}

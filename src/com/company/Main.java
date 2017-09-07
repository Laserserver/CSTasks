package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Menu();
    }

    private static void Menu()
    {
        Scanner s = new Scanner(System.in);
        Operator op = new Operator();
        GroupRedactor gr = new GroupRedactor(op);
        StudentRedactor sr = new StudentRedactor(op);

        while (true)
        {
            System.out.println("ИНФОРМАТИКА");

            System.out.println("Выберите пункт: ");
            System.out.println("     1. Редактор курсов и групп");
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
                    gr.Start();
                    continue;
                case 2:
                    sr.Start();
                    continue;
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

package com.company;

import java.util.Scanner;

public class Redactor {

    protected Operator op;
    protected Scanner s;

    public Redactor(Operator operator)
    {
        op = operator;
        s = new Scanner(System.in);
    }

    protected int invokeSelection()
    {
        if(!s.hasNextInt())
        {
            System.out.println("Еще раз, не введено число.");
            s.nextLine();
            return -1;
        }
        return s.nextInt();
    }

    protected boolean selectCourse()
    {
        System.out.println("Выберите курс: ");
        op.getCourses();
        int option = invokeSelection();
        return option >= 1 && op.selectCourse(option);
    }

    protected boolean selectGroup()                        //Если не выбран курс, то сюда пускать не должно.
    {
        System.out.println("Выберите группу: ");
        op.getCourseGroups();
        int option = invokeSelection();
        return option >= 1 && op.selectGroup(option);
    }
}

package com.company;

import java.util.Scanner;

public class Redactor {

    protected Operator _op;
    protected Scanner s;
    public Redactor(Operator operator)
    {
        _op = operator;
        s = new Scanner(System.in);
    }

    protected int _Selection()
    {
        if(!s.hasNextInt())
        {
            System.out.println("Еще раз, не введено число.");
            s.nextLine();
            return -1;
        }
        return s.nextInt();
    }

    protected Boolean _SelectCourse()
    {
        System.out.println("Выберите курс: ");
        _op.GetCourses();
        int option = _Selection();
        if(option < 1)
            return false;                                   //Тут нафиг шлем, если вообще не инт введен.
        else
            return _op.SelectCourse(option);                //Метод разберется, если больше, чем курсов
    }

    protected Boolean _SelectGroup()                        //Если не выбран курс, то сюда пускать не должно.
    {
        System.out.println("Выберите группу: ");
        _op.GetCourseGroups();
        int option = _Selection();
        if(option < 1)
            return false;
        else
            return _op.SelectGroup(option);
    }
}

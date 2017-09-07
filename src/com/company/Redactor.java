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
}

package com.company;

import java.util.stream.IntStream;

public class Student {

    public final String Name;
    public final String Surname;
    private boolean[] _marks;

    public Student(String name, String surname)
    {
        Name = name;
        Surname = surname;
        _marks = new boolean[3];
    }

    public void SetMark(int num, boolean state)
    {
        _marks[num - 1] = state;
    }

    public void GetMarks()
    {
        IntStream.range(1, 4).forEach(
                nbr -> System.out.println(nbr + ". " + (_marks[nbr-1] ? "Сдано" : "Не сдано"))
        );
    }

    public boolean GetMark(int num)
    {
        return _marks[num - 1];
    }
}

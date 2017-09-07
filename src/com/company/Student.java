package com.company;

import java.util.stream.IntStream;

public class Student {

    public final String Name;
    public final String Surname;
    private Boolean[] _marks;

    public Student(String name, String surname)
    {
        Name = name;
        Surname = surname;
        _marks = new Boolean[3];
    }

    public void SetMark(int num)
    {
        _marks[num - 1] = true;
    }

    public void GetMarks()
    {
        IntStream.range(1, 4).forEach(
                nbr -> System.out.println(nbr + ". " + (_marks[nbr-1] ? "Сдал" : "Не сдал"))
        );
    }
}

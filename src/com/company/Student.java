package com.company;

import java.util.stream.IntStream;

public class Student {

    private final String name;
    private final String surname;
    private boolean[] marks;

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public Student(String name, String surname)
    {
        this.name = name;
        this.surname = surname;
        marks = new boolean[3];
    }

    public void setMark(int num, boolean state)
    {
        marks[num - 1] = state;
    }

    public void getMarks()
    {
        IntStream.range(1, 4).forEach(
                nbr -> System.out.println(nbr + ". " + (marks[nbr-1] ? "Сдано" : "Не сдано"))
        );
    }

    public boolean getMark(int num)
    {
        return marks[num - 1];
    }
}

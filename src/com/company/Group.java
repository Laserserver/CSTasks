package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Group {

    private final List<Student> students;
    private final int number;
    private final int course;   //<-- неизвестно, зачем, но из-за задания сделано.

    public Group(int num, int course)
    {
        number = num;
        students = new LinkedList<>();
        this.course = course;
    }

    public int getNumber(){
        return number;
    }

    public int getStudentCount(){
        return students.size();
    }

    public void insertStudent(String name, String surname)
    {
        students.add(new Student(name, surname));
    }

    public void getList()
    {
        IntStream.range(1, students.size() + 1).forEach(
                num -> System.out.println("        " + num + ". " + students.get(num-1).getName() + ' ' + students.get(num-1).getSurname())
        );
    }

    public Student selectStudent(int number)
    {
        return students.get(number - 1);
    }

    public void deleteStudent(int number)
    {
        if(students.size() < 1)
            System.out.println("Студентов уже нет.");
        else {
            students.remove(number - 1);
        }
    }
}

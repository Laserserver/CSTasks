package com.company;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Group {

    private final List<Student> _students;
    public final int Number;
    public final int Course;
    public int StudentCount;

    public Group(int num, int course)
    {
        Number = num;
        Course = course;
        _students = new LinkedList<>();
    }

    public void InsertStudent(String name, String surname)
    {
        _students.add(new Student(name, surname));
        StudentCount++;
    }

    public void GetList()
    {
        IntStream.range(1, _students.size()).forEach(
                num -> System.out.println("        " + num + ". " + _students.get(num-1).Name + ' ' + _students.get(num-1).Surname)
        );
    }

    public Student SelectStudent(int number)
    {
        return _students.get(number - 1);
    }

    public void DeleteStudent(int number)
    {
        _students.remove(number - 1);
        StudentCount--;
    }
}

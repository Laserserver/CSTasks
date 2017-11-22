package vsu.kurs3.task3.legacy.structures.group;

import vsu.kurs3.task3.legacy.structures.student.StudentsOperator;


public class Group {

    private final int number;
    private int course;   //<-- неизвестно, зачем, но из-за задания сделано.
    private StudentsOperator studentsOperator;

    Group(int num, int course) {
        number = num;
        this.course = course;
        studentsOperator = new StudentsOperator(num);
    }

    public StudentsOperator getStudentsOperator() {
        return studentsOperator;
    }

    @Override
    public String toString() {
        return String.format("%d группа", number);
    }
}

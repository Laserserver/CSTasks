package vsu.kurs3.task3.legacy.structures.student;

public class Student {

    private final String name;
    private final String surname;
    private MarksOperator marksOperator;

    @Override
    public String toString() {return name + ' ' + surname; }

    Student(String name, String surname){
        this.name = name;
        this.surname = surname;
        marksOperator = new MarksOperator();
    }

    public MarksOperator getMarksOperator() {
        return marksOperator;
    }
}

package vsu.kurs3.att1.task9.structures;

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

    public Student(String name, String surname){
        this.name = name;
        this.surname = surname;
        marks = new boolean[3];
    }

    public boolean[] getMarks(){
        return marks;
    }
}

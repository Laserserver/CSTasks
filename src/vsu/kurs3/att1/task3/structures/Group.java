package vsu.kurs3.att1.task3.structures;

import java.util.LinkedList;
import java.util.List;

public class Group {

    private final List<Student> students;
    private final int number;
    private int course;   //<-- неизвестно, зачем, но из-за задания сделано.

    Group(int num, int course) {
        number = num;
        students = new LinkedList<>();
        this.course = course;
    }

    public List<String> getStudentNamesList()   //Лень делать возвращение строки, список тож сойдет.
    {
        final List<String> rows = new LinkedList<>();
        students.forEach(x -> rows.add(x.toString()));
        return rows;
    }

    public void insertStudent(Student st) {  //Вставляем ЭКЗЕМПЛЯР студента
        students.add(st);
    }

    public Student getStudentByName(String fullName) {
        Student st;
        for (Student student : students) {
            st = student;
            if (st.toString().equals(fullName))
                return st;
        }
        return null;
    }

    public int deleteStudent(Student st) {   //-1 писос, 1 удалено, 0 нет такого
        if(students.size() < 1)
            return -1;
        else {
            return students.remove(st) ? 1 : 0;
        }
    }

    @Override
    public String toString() {
        return String.format("%d группа", number);
    }
}

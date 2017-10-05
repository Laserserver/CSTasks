package vsu.kurs3.att1.task9.structures;

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

    int getGroupNumber(){
        return number;
    }

    public int getStudentCount(){
        return students.size();
    }

    public List<String> getStudentNamesList()   //Лень делать возвращение строки, список тож сойдет.
    {
        final List<String> rows = new LinkedList<>();
        students.forEach(x -> rows.add(x.getFullName()));
        return rows;
    }

    public void insertStudent(Student st) {  //Вставляем ЭКЗЕМПЛЯР студента
        students.add(st);
    }

    public Student takeStudentByName(String fullName) {
        Student st;
        for (Student student : students) {
            st = student;
            if (st.getFullName().equals(fullName))
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
}

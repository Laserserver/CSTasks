package vsu.kurs3.att1.task3.structures.student;

import java.util.LinkedList;
import java.util.List;

public class StudentsOperator {

    private final List<Student> students;

    public StudentsOperator(){
        students = new LinkedList<>();
    }

    public List<String> getStudentNamesList()   //Лень делать возвращение строки, список тож сойдет.
    {
        final List<String> rows = new LinkedList<>();
        students.forEach(x -> rows.add(x.toString()));
        return rows;
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

    public void insertStudent(Student st) {  //Вставляем ЭКЗЕМПЛЯР студента
        students.add(st);
    }

    public Student createStudent(List<String> names){
        return new Student(names.get(0), names.get(1));
    }

}

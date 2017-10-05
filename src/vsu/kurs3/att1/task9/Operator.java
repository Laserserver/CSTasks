package vsu.kurs3.att1.task9;
import vsu.kurs3.att1.task9.structures.Course;
import vsu.kurs3.att1.task9.structures.Group;
import vsu.kurs3.att1.task9.structures.Student;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Operator {

    private List<Course> courses;
    private Course selectedCourse;
    private Group selectedGroup;
    private Scanner s;

    public Operator()
    {
        courses = new LinkedList<>();
        s = new Scanner(System.in);
    }

    public void getCourses()
    {
        IntStream.range(1, courses.size() + 1).forEach(
                num -> System.out.println(courses.get(num - 1).getCourseNum() + " курс.")
        );
    }

    public int getCourseGroupsSize()
    {
        return selectedCourse.getCourseSize();
    }

    public boolean selectCourse(int num)
    {
        if(num <= courses.size())
        {
            selectedCourse = courses.get(num - 1);
            return true;
        }
        System.out.println("Ошибка при выборе курса.");
        return false;
    }

    public void createCourse()
    {
        courses.add(new Course(courses.size() + 1));
    }

    public void getCourseGroups()
    {
        selectedCourse.getGroupsNumsList();
    }

    public boolean selectGroup(int num)
    {
        if(num > 0 && num <= selectedCourse.getGroupCount())    //Если номер выбираемой группы меньше или равен максимальному номеру группы
        {
            selectedGroup = selectedCourse.takeGroupByNum(num);
            if(selectedGroup != null)
                return true;                //Специально так, чтобы если получили null, то написать об ошибке.
        }
        System.out.println("Ошибка при выборе группы.");
        return false;
    }

    public void getGroupStudents()
    {
        selectedGroup.getStudentListAsText();
    }

    public Student selectStudent(int num)
    {
        if(num > 0 && num <= selectedGroup.getStudentCount())
            return selectedGroup.takeStudentByName(num);
        System.out.println("Неверный выбор.");
        return null;
    }



    //===================

    public void createGroup()
    {
        selectedCourse.createGroup();
    }

    public void deleteGroup(int num)
    {
        selectedCourse.deleteGroup(num);
    }

    public void insertStudent(String name, String surname)
    {
        selectedGroup.insertStudent(name, surname);
    }

    public void deleteStudent(int num)
    {
        selectedGroup.deleteStudentByName(num);
    }
}

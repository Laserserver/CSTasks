package com.company;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Operator {

    private List<Course> _courses;
    private Course _selectedCourse;
    private Group _selectedGroup;
    private Student _selectedStudent;
    private Scanner s;
    public Operator()
    {
        _courses = new LinkedList<>();
        s = new Scanner(System.in);
    }

    public void GetCourses()
    {
        IntStream.range(1, _courses.size()).forEach(
                num -> System.out.println(_courses.get(num - 1).CourseNum + " курс.")
        );
    }

    public void SelectCourse(int num)
    {
        _selectedCourse = _courses.get(num - 1);
    }

    public void GetCourseGroups()
    {
        _selectedCourse.GetGroupsList();
    }

    public void SelectGroup(int num)
    {
        _selectedGroup = _selectedCourse.SelectGroup(num);
    }

    public void GetGroupStudents()
    {
        _selectedGroup.GetList();
    }

    public void SelectStudent(int num)
    {
        _selectedStudent = _selectedGroup.SelectStudent(num);
    }

    public void GetStudentMarks()
    {
        _selectedStudent.GetMarks();
    }

    //===================

    public void CreateGroup()
    {
        _selectedCourse.CreateGroup();
    }

    public void DeleteGroup(int num)
    {
        System.out.print("Введите номер удаляемой группы: ");
        if(!s.hasNextInt())
        {
            System.out.println("Еще раз, неверные символы.");
            s.nextLine();
            return;
        }
        _selectedCourse.DeleteGroup(s.nextInt());
    }

    public void InsertStudent(String name, String surname)
    {
        _selectedGroup.InsertStudent(name, surname);
    }

    public void DeleteStudent(int num)
    {
        _selectedGroup.DeleteStudent(num);
    }

    public void SetStudentMark(int task)
    {
        _selectedStudent.SetMark(task);
    }
}

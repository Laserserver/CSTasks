package com.company;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Operator {

    private List<Course> _courses;
    private Course _selectedCourse;
    private Group _selectedGroup;
    private Scanner s;
    public Operator()
    {
        _courses = new LinkedList<>();
        s = new Scanner(System.in);
    }

    public void GetCourses()
    {
        System.out.println(_courses.size());
        IntStream.range(1, _courses.size() + 1).forEach(
                num -> System.out.println(_courses.get(num - 1).CourseNum + " курс.")
        );
    }

    public Boolean SelectCourse(int num)
    {
        if(num <= _courses.size())
        {
            _selectedCourse = _courses.get(num - 1);
            return true;
        }
        return false;
    }

    public void CreateCourse()
    {
        _courses.add(new Course(_courses.size()+1));
    }

    public void GetCourseGroups()
    {
        _selectedCourse.GetGroupsList();
    }

    public Boolean SelectGroup(int num)
    {
        if(num <= _selectedCourse.GroupCount)
        {
            _selectedGroup = _selectedCourse.SelectGroup(num);
            return true;
        }
        return false;
    }

    public void GetGroupStudents()
    {
        _selectedGroup.GetList();
    }

    public Student SelectStudent(int num)
    {
        if(num > 0 && num <= _selectedGroup.StudentCount)
            return _selectedGroup.SelectStudent(num);
        System.out.println("Неверный выбор.");
        return null;
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
}

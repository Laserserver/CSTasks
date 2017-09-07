package com.company;

public class GroupRedactor extends Redactor {

    public GroupRedactor(Operator operator)
    {
        super(operator);
    }

    public void GetCourseList()
    {
        _op.GetCourses();
    }

    public void CourseSelection()
    {
        System.out.println("Выберите курс: ");
        int option = _Selection();                  //Даже если -1, все равно передаем в SelectCourse
        _op.SelectCourse(option);                   //Там метод разберется
    }

    public void GroupSelection()
    {
        System.out.println("Выберите группу: ");
        int option = _Selection();                  //Даже если -1, все равно передаем в SelectGroup
        _op.SelectGroup(option);                    //Там метод разберется
    }
}

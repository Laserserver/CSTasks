package com.company;

public class StudentRedactor extends Redactor {

    public StudentRedactor(Operator operator)
    {
        super(operator);
    }

    public void Start()
    {
        if(_SelectCourse())
        {

        }
        else
            System.out.println("Ошибка при выборе курса. Попробуйте ещё раз.");

    }

    public void SelectStudent()
    {
        System.out.println("Выберите студента: ");
        int option = _Selection();                      //Даже если -1, все равно передаем в SelectCourse
        _op.SelectStudent(option);                      //Там метод разберется
    }

    private void _ShowInfo()
    {

    }
}

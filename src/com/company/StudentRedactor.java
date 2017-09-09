package com.company;

public class StudentRedactor extends Redactor {

    private Student _student;

    public StudentRedactor(Operator operator)
    {
        super(operator);
    }

    public void Start()
    {
        if(_SelectCourse() && _SelectGroup())
            _SelectStudent();
    }

    private void _SelectStudent()
    {
        System.out.println("Выберите студента: ");
        _op.GetGroupStudents();
        int option = _Selection();                      //Даже если -1, все равно передаем в SelectCourse
        _student = _op.SelectStudent(option);           //Там метод разберется
           if(_student != null)
               _ShowInfo();

    }

    private void _ShowInfo()
    {
        System.out.println("Студент: " + _student.Name + ' ' + _student.Surname);
        System.out.println("Оценки: ");
        _student.GetMarks();
        System.out.print("Выберите этап >> ");
        int option = _Selection();
        while(option < 1)
        {
            System.out.println("Неверный выбор этапа.");
        }
        System.out.println("Этап " + option + ". Текущее состояние: " + (_student.GetMark(option) ? "Сдано" : "Не сдано"));
        System.out.println("Как изменить?");
        System.out.println("    1. Сдано");
        System.out.println("    2. Не сдано");
        int secoption = _Selection();
        while(secoption < 1)
        {
            System.out.println("Неверный выбор состояния.");
        }
        _student.SetMark(option, secoption == 1 ? true : false);
    }
}

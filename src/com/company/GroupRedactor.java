package com.company;

public class GroupRedactor extends Redactor {

    public GroupRedactor(Operator operator)
    {
        super(operator);
    }

    public void Start()
    {
        System.out.println("РЕДАКТОР КУРСОВ И ГРУПП: ");
        System.out.println("Выберите пункт: ");
        System.out.println("     1. Создать курс.");
        System.out.println("     2. Изменить курс.");
        System.out.println("     3. Выход. ");
        int option = _Selection();
        switch (option)
        {
            case 1:
                _CourseCreate();
                break;
            case 2:
                _CourseChange();
                break;
            case 3:
                break;
            default:
                System.out.println("Введен неверный символ.");
                break;
        }
    }

    private void _CourseCreate()
    {
        System.out.println("СОЗДАНИЕ КУРСА: ");
        System.out.println("    Присутствующие курсы: ");
        _op.GetCourses();
        System.out.print("Создать новый? Y\\N >> ");
        String flag = s.next();
        if(flag.toLowerCase().equals("y")){
            _op.CreateCourse();
            System.out.println("Добавлен новый курс.");
        }
        else
            System.out.println("Отмена добавления нового курса.");
    }

    private void _CourseChange()
    {
        System.out.println("ИЗМЕНЕНИЕ КУРСА: ");
        if(!_SelectCourse())
            return;
        else
            _GroupMenu();
    }

    private void _GroupMenu()
    {
        System.out.println("Изменение курса: ");
        System.out.println("    Присутствующие группы: ");
        _op.GetCourseGroups();
        System.out.println("Выберите операцию:");
        System.out.println("    1. Создание группы. ");
        System.out.println("    2. Изменение группы. ");
        System.out.println("    3. Удаление группы. ");
        System.out.println("    4. Выход. ");

        int option = _Selection();
        switch (option)
        {
            case 1:
                _GroupCreate();
                break;
            case 2:
                _GroupChange();
                break;
            case 3:
                _GroupDelete();
                break;
            case 4:
                break;
            default:
                System.out.println("Введен неверный символ.");
                break;
        }
    }

    private void _GroupCreate()
    {
        System.out.println("Создание группы для этого курса: ");
        System.out.print("Вы действительно хотите создать группу? Y\\N >> ");
        String flag = s.next();
        if(flag.toLowerCase().equals("y")){
            _op.CreateGroup();
            System.out.println("Добавлена новая группа.");
        }
        else
            System.out.println("Отмена добавления новой группы.");
    }

    private void _GroupChange()
    {
        System.out.println("Изменение группы: ");
        System.out.println("Выберите группу: ");
        if(!_SelectGroup())
            return;
        System.out.println("Список студентов: ");
        _op.GetGroupStudents();
        System.out.println("    Выберите операцию: ");
        System.out.println("        1. Добавить студента.");
        System.out.println("        2. Удалить студента.");
        System.out.println("        3. Выход.");
        int option = _Selection();
        switch (option)
        {
            case 1:
                _StudentNew();
                break;
            case 2:
                _StudentDelete();
                break;
            case 3:
                break;
            default:
                System.out.println("Введен неверный символ.");
                break;
        }
    }

    private void _StudentNew()
    {
        System.out.println("Добавление студента: ");
        System.out.print("Введите имя >> ");
        String name = s.nextLine();
        if(s.hasNext())
        {
            System.out.print("Введите фамилию >> ");
            String surname = s.nextLine();
            _op.InsertStudent(name, surname);
        }
    }

    private void _StudentDelete()
    {
        System.out.println("Удаление студента: ");
        System.out.println("Выберите номер студента: ");
        int option = _Selection();
        if(option < 1)
        {
            System.out.println("Неверный номер");
        }
        else
            _op.DeleteStudent(option);
    }

    private void _GroupDelete()
    {
        System.out.println("Удаление группы: ");
        System.out.println("Выберите номер группы: ");
        int option = _Selection();
        if(option < 1)
        {
            System.out.println("Неверный номер");
        }
        else
            _op.DeleteGroup(option);
    }
}

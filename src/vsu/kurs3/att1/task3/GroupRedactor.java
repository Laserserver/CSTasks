package vsu.kurs3.att1.task3;

public class GroupRedactor extends Redactor {

    public GroupRedactor(Operator operator)
    {
        super(operator);
    }

    public void start()
    {
        System.out.println("РЕДАКТОР КУРСОВ И ГРУПП: ");
        System.out.println("Выберите пункт: ");
        System.out.println("     1. Создать курс.");
        System.out.println("     2. Изменить курс.");
        System.out.println("     3. Выход. ");
        int option = invokeSelection();
        switch (option)
        {
            case 1:
                courseCreate();
                break;
            case 2:
                courseChange();
                break;
            case 3:
                break;
            default:
                System.out.println("Введен неверный символ.");
                break;
        }
    }

    private void courseCreate()
    {
        System.out.println("СОЗДАНИЕ КУРСА: ");
        System.out.println("    Присутствующие курсы: ");
        op.getCourses();
        System.out.print("Создать новый? Y\\N >> ");
        String flag = s.next();
        if(flag.toLowerCase().equals("y")){
            op.createCourse();
            System.out.println("Добавлен новый курс.");
        }
        else
            System.out.println("Отмена добавления нового курса.");
    }

    private void courseChange()
    {
        System.out.println("ИЗМЕНЕНИЕ КУРСА: ");
        if(selectCourse())
            groupMenu();
    }

    private void groupMenu()
    {
        boolean flag = true;
        System.out.println("Изменение курса: ");
        while(flag) {
            System.out.println("    Присутствующие группы: ");
            op.getCourseGroups();
            System.out.println("Выберите операцию:");
            System.out.println("    1. Создание группы. ");
            System.out.println("    2. Изменение группы. ");
            System.out.println("    3. Удаление группы. ");
            System.out.println("    4. Выход. ");

            int option = invokeSelection();
            switch (option) {
                case 1:
                    groupCreate();
                    break;
                case 2:
                    groupChange();
                    break;
                case 3:
                    groupDelete();
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("Введен неверный символ.");
                    break;
            }
        }
    }

    private void groupCreate()
    {
        System.out.println("Создание группы для этого курса: ");
        System.out.print("Вы действительно хотите создать группу? Y\\N >> ");
        String flag = s.next();
        if(flag.toLowerCase().equals("y")){
            op.createGroup();
            System.out.println("Добавлена новая группа.");
        }
        else
            System.out.println("Отмена добавления новой группы.");
    }

    private void groupChange()
    {
        System.out.println("Изменение группы: ");
        if(!selectGroup())
            return;
        System.out.println("Список студентов: ");
        op.getGroupStudents();
        System.out.println("    Выберите операцию: ");
        System.out.println("        1. Добавить студента.");
        System.out.println("        2. Удалить студента.");
        System.out.println("        3. Выход.");
        int option = invokeSelection();
        switch (option)
        {
            case 1:
                studentNew();
                break;
            case 2:
                studentDelete();
                break;
            case 3:
                break;
            default:
                System.out.println("Введен неверный символ.");
                break;
        }
    }

    private void studentNew()
    {
        System.out.println("Добавление студента: ");
        System.out.print("Введите имя >> ");
        s.nextLine();
        String name = s.nextLine();
        System.out.print("Введите фамилию >> ");
        String surname = s.nextLine();
        op.insertStudent(name, surname);
    }

    private void studentDelete()
    {
        System.out.println("Удаление студента: ");
        System.out.println("Выберите номер студента: ");
        int option = invokeSelection();
        if(option < 1)
            System.out.println("Неверный номер");
        else
            op.deleteStudent(option);
    }

    private void groupDelete() {
        System.out.println("Удаление группы: ");
        if (op.getCourseGroupsSize() < 1)
            System.out.println("Групп нет");
        else {
            System.out.println("Выберите номер группы: ");
            int option = invokeSelection();
            if (option < 1)
                System.out.println("Неверный номер");
            else
                op.deleteGroup(option);
        }
    }
}

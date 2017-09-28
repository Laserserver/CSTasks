package vsu.kurs3.att1.task9;

public class StudentRedactor extends Redactor {

    private Student student;

    public StudentRedactor(Operator operator)
    {
        super(operator);
    }

    public void start()
    {
        if(selectCourse() && selectGroup())
            selectStudent();
    }

    private void selectStudent()
    {
        System.out.println("Выберите студента: ");
        op.getGroupStudents();
        int option = invokeSelection();                      //Даже если -1, все равно передаем в SelectCourse
        student = op.selectStudent(option);           //Там метод разберется
           if(student != null)
               showInfo();

    }

    private void showInfo()
    {
        System.out.println("Студент: " + student.getName() + ' ' + student.getSurname());
        System.out.println("Оценки: ");
        student.getMarks();
        System.out.print("Выберите этап >> ");
        int option = invokeSelection();
        while(option < 1)
        {
            System.out.println("Неверный выбор этапа.");
        }
        System.out.println("Этап " + option + ". Текущее состояние: " + (student.getMark(option) ? "Сдано" : "Не сдано"));
        System.out.println("Как изменить?");
        System.out.println("    1. Сдано");
        System.out.println("    2. Не сдано");
        int secondaryOption = invokeSelection();
        while(secondaryOption < 1)
        {
            System.out.println("Неверный выбор состояния.");
        }
        student.setMark(option, secondaryOption == 1);
    }
}

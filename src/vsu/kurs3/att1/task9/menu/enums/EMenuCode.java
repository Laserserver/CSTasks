package vsu.kurs3.att1.task9.menu.enums;

public enum EMenuCode {
    MenuMain(0),
    CourseMainMenu(1),
    MarksMainMenu(2),
    SelectCourseMenu(3),
    SelectGroupMenu(4);



    private final int value;
    EMenuCode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}

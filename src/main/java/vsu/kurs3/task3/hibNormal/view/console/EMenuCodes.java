package vsu.kurs3.task3.hibNormal.view.console;

public enum EMenuCodes {

    MenuMain(0),

    CreateCourseMenu(1),
    CreateCourseChoiceMenu(2),


    SelectCourseMenu(3),
    SelectCourseChoiceMenu(4),

    CreateGroupMenu(5),
    CreateGroupChoiceMenu(6),


    SelectGroupMenu(7),
    SelectGroupChoiceMenu(8),

    DeleteGroupMenu(9),
    DeleteGroupChoiceMenu(10),

    CreateStudentMenu(11),
    CreateStudentChoiceMenu(12),

    DeleteStudentMenu(13),
    DeleteStudentChoiceMenu(14),

    SelectStudentMenu(15),
    SelectStudentChoiceMenu(16),

    SelectStageMenu(17),
    SelectStageChoiceMenu(18),

    AlterStageMenu(19),

    JunctionSelectCourseMenu(20),
    JunctionSelectGroupMenu(21),
    JunctionSelectStudentMenu(22),

    AddStudentChoiceMenu(23);

    private final int value;
    private static final EMenuCodes[] enums = EMenuCodes.values();

    EMenuCodes(int value) {
        this.value = value;
    }

    public int getValueOfEnum() {
        return value;
    }

    public static EMenuCodes getEnumByValue(int x) {
        return enums[x];
    }
}

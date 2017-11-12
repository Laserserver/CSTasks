package vsu.kurs3.att1.task3.legacy.menu.enums;

public enum EMenuCode {
    MenuMain(0),
    CourseMainMenu(1),
    MarksMainMenu(2),
    SelectCourseMenu(3),
    SelectGroupMenu(4),
    SelectStudentMenu(5),

    CourseCreatorMenu(6),
    CourseCreatorChoiceMenu(7),
    GroupMainMenu(8),
    GroupCreatorMenu(9),
    GroupCreatorChoiceMenu(10),
    GroupEditorMenu(11),
    GroupDeleterMenu(12),
    GroupCreateStudentMenu(13),
    GroupStudentDeleterMenu(14),

    SelectStageMenu(15),
    MarksChoiceMenu(16),

    //StudentCreatorMenu(17),
    SetStageMenu(17);


    private final int value;
    private static final EMenuCode[] enums = EMenuCode.values();

    EMenuCode(int value) {
        this.value = value;
    }

    public int getValueOfEnum() {
        return value;
    }

    public static EMenuCode getEnumByValue(int x) {
        return enums[x];
    }
}

package vsu.kurs3.att1.task3.menu.enums;

public enum EMenuCode {
    MenuMain(0),
    CourseMainMenu(1),
    MarksMainMenu(2),
    SelectCourseMenu(3),
    SelectGroupMenu(4),
    SelectStudentMenu(5),

    CourseCreatorMenu(6),
    CourseCreatorChoiceMenu(7),
    CourseEditorMenu(8),

    GroupMainMenu(9),
    GroupCreatorMenu(10),
    GroupCreatorChoiceMenu(11),
    GroupEditorMenu(12),
    GroupDeleterMenu(13),
    GroupCreateStudentMenu(14),
    GroupStudentDeleterMenu(15),

    SelectStageMenu(16),
    MarksChoiceMenu(17);

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

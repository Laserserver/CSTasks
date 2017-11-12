package vsu.kurs3.att1.task3.legacy.menu.specialMenus;

import vsu.kurs3.att1.task3.legacy.menu.enums.EMenuCode;

public class EditorMenu extends MainMenu {

    public EditorMenu(EMenuCode code){
        super(code);
        switch (code){
            case GroupEditorMenu:

                title = "Изменение группы: ";
                lines.add("    Выберите операцию: ");
                lines.add("        1. Добавить студента.");
                lines.add("        2. Удалить студента.");
                lines.add("        3. Выход.");
                optionMax = 3;
                break;
        }
    }
}

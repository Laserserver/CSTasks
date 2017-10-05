package vsu.kurs3.att1.task3.menu.logics;

import vsu.kurs3.att1.task3.menu.enums.EMenuCode;
import vsu.kurs3.att1.task3.menu.specialMenus.MainMenu;
import vsu.kurs3.att1.task3.menu.specialMenus.StringChoiceMenu;
import vsu.kurs3.att1.task3.menu.specialMenus.CreatorMenu;
import vsu.kurs3.att1.task3.menu.specialMenus.EditorMenu;
import vsu.kurs3.att1.task3.menu.specialMenus.SelectorMenu;
import vsu.kurs3.att1.task3.menu.specialMenus.menuCore.ParentMenu;

public class MenuFabric {

    public ParentMenu createMenu(EMenuCode code)
    {                                                   //Один метод, чтоб править всеми,
        switch (code) {                                 //Он главнее всех,
            case MenuMain:                              //Он сберёт всех вместе
            case CourseMainMenu:                         //И заключит в листе.
            case MarksMainMenu:
            case GroupMainMenu:
                return new MainMenu(code);
            case SelectStageMenu:
            case SelectCourseMenu:
            case SelectGroupMenu:
            case SelectStudentMenu:
                return new SelectorMenu(code);
            case CourseCreatorMenu:
            case GroupCreatorMenu:
            case GroupCreateStudentMenu:
                return new CreatorMenu(code);
            case GroupStudentDeleterMenu:
            case GroupDeleterMenu:
            case CourseCreatorChoiceMenu:
            case GroupCreatorChoiceMenu:
            case MarksChoiceMenu:
                return new StringChoiceMenu(code);
            case GroupEditorMenu:
            case CourseEditorMenu:
                return new EditorMenu(code);
            default:
                return null;
        }
    }
}

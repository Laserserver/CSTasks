package vsu.kurs3.att1.task3.legacy.menu.logics;

import vsu.kurs3.att1.task3.legacy.menu.enums.EMenuCode;
import vsu.kurs3.att1.task3.legacy.menu.specialMenus.*;
import vsu.kurs3.att1.task3.legacy.menu.specialMenus.menuCore.ParentMenu;

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
            case SetStageMenu:
                return new SelectorMenu(code);
            case CourseCreatorMenu:
            case GroupCreatorMenu:
                return new CreatorMenu(code);
            case GroupStudentDeleterMenu:
            case GroupDeleterMenu:
            case CourseCreatorChoiceMenu:
            case GroupCreatorChoiceMenu:
            //case StudentCreatorMenu:
            case MarksChoiceMenu:
                return new StringChoiceMenu(code);
            case GroupEditorMenu:
                return new EditorMenu(code);
            case GroupCreateStudentMenu:
                return new StudentCreatorMenu();
            default:
                return null;
        }
    }
}

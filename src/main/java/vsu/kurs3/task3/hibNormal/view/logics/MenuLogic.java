package vsu.kurs3.task3.hibNormal.view.logics;

import vsu.kurs3.task3.hibNormal.view.EMenuCodes;
import vsu.kurs3.task3.hibNormal.view.menus.Menu;

import java.util.LinkedList;
import java.util.List;

public class MenuLogic {

    private EMenuCodes[] codes = EMenuCodes.values();
    private MenuFabric mf = new MenuFabric();
    private List<Menu> menus = new LinkedList<>();

    public MenuLogic(){
       // for (EMenuCodes code: codes)
           // menus.add(mf.createMenu(code));
    }

    public void start(){
        boolean flag = true;
        while(flag){
            int option = (Integer) menus.get(EMenuCodes.MenuMain.getValueOfEnum()).showMenu(null);

            switch(option){
                case 1:
                    operateCreateBranch();
                    break;
                case 2:
                    operateSelectBranch();
                    break;
                case 3:
                    flag = false;
                    break;
            }
        }
    }

    private void operateCreateBranch(){
        //menus.get(EMenuCodes.CreateCourseMenu.getValueOfEnum()).showMenu();
    }

    private void operateSelectBranch(){

    }
}

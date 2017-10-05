package vsu.kurs3.att1.task3.menu.logics;

public class MainMenuLogic {

    private MainMenu mmn;

    public MainMenuLogic(){
        //mmn = new MainMenu();
    }

    public int startMainMenu(){
        int option = -1;
        while(option < 1 || option > 3) {       //Крутим цикл, пока не увидим внятного ответа
            option = mmn.startMainMenu();
        }
        return option;
    }

    public void showExitMenu(){
        mmn.showExitMenu();
    }
}

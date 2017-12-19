package vsu.kurs3.task3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
	    //Menu();
        SpringApplication.run(Main.class, args);
        return;
    }

   /* private static void Menu() {

        MenuLogic menuLogic = new MenuLogic(new CoursesOperator());

        boolean flag = true;
        while(flag){
            flag = menuLogic.start();
        }
    }*/
}

package vsu.kurs3.task3.hibNormal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import vsu.kurs3.task3.hibNormal.models.dto.CourseDTO;
import vsu.kurs3.task3.hibNormal.repositories.CourseRepository;
import vsu.kurs3.task3.hibNormal.services.CourseService;

import javax.transaction.Transactional;
import java.util.Scanner;
import java.util.Set;

@Transactional
@Component
public class ConsoleController implements CommandLineRunner {
    @Autowired
    public CourseRepository courseRep;
    @Autowired
    public CourseService courseSrv;
    private Scanner in = new Scanner(System.in);

    @Override
    public void run(String... args){

        for (int i = 0; i < 4; i++)
            insertCourse(i+1);
        char key='c';

        while(key!='q') {
            printCourses();

            String s = in.nextLine();
            if(s.length() == 1){
                key = s.charAt(0);
            }
        }
    }

    private void insertCourse(int num){
        CourseDTO crs = new CourseDTO();
        crs.setNumber(num);
        courseSrv.add(crs);
        System.out.println("Insert " + num + " course.");
    }

    private void printCourses(){
        Iterable<CourseDTO> crss = courseSrv.getAll();
        System.out.println(crss.iterator().hasNext());
        for (CourseDTO ab: crss) {
            System.out.printf("%s курс.", ab.getNumber());
            System.out.println();
        }
    }
}

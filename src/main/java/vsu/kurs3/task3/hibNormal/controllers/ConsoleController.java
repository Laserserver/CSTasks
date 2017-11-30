package vsu.kurs3.task3.hibNormal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import vsu.kurs3.task3.hibNormal.models.converters.CourseConverter;
import vsu.kurs3.task3.hibNormal.models.dto.CourseDTO;
import vsu.kurs3.task3.hibNormal.models.dto.GroupDTO;
import vsu.kurs3.task3.hibNormal.models.dto.StudentDTO;
import vsu.kurs3.task3.hibNormal.models.entities.Group;
import vsu.kurs3.task3.hibNormal.services.CourseService;
import vsu.kurs3.task3.hibNormal.services.GroupService;
import vsu.kurs3.task3.hibNormal.services.StudentService;
import vsu.kurs3.task3.hibNormal.view.EMenuCodes;
import vsu.kurs3.task3.hibNormal.view.controllers.ListingMenuController;
import vsu.kurs3.task3.hibNormal.view.logics.MenuFabric;
import vsu.kurs3.task3.hibNormal.view.menus.Menu;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Transactional
@Component
public class ConsoleController implements CommandLineRunner {
    @Autowired
    public CourseService courseSrv;
    @Autowired
    public GroupService groupSrv;
    @Autowired
    public StudentService studSrv;


    private Scanner in = new Scanner(System.in);

    private ListingMenuController lmc;
    private MenuFabric mf;

    public ConsoleController(){
        mf = new MenuFabric();
        lmc = new ListingMenuController(mf.getMenusList());

    }


    @Override
    public void run(String... args){
        Menu main = mf.getMenu(EMenuCodes.MenuMain);

        int option;
        while(true){
            option = (Integer) main.showMenu(null);
            if(option == 3)
                break;
            if(option == 1){
                startCourseCreation();
            }
            if(option == 2){
                startCourseSelection();
            }
        }
    }

    private void startCourseCreation(){
        while(true){
            int option = (Integer) lmc.showMenu(EMenuCodes.CreateCourseMenu,
                    getCourses());
            if(option == 1)
                break;
            int num = courseSrv.getCount() + 1;
            CourseDTO crs = new CourseDTO();
            crs.setNumber(num);
            courseSrv.add(crs);
            System.out.printf("Добавлен %s курс.\n", num);
        }
    }

    private void startCourseSelection(){
        String text = (String) lmc.showMenu(EMenuCodes.SelectCourseMenu,
                getCourses());
        int option = Integer.parseInt(text.replaceAll("[\\D]", ""));
        if(option <= courseSrv.getCount() && option > 0){
            CourseDTO selected = courseSrv.getByNum(option);

            List<String> lst;
            List<String> lst2 = new LinkedList<>();
            lst2.add(selected.getNumber() + " курс.");
            boolean flag = true;
            while(flag) {
                option = (Integer) mf.getMenu(EMenuCodes.JunctionSelectCourseMenu).showMenu(lst2);
                switch (option) {
                    case 1:
                        while (true) {
                            lst = getGroups(selected);
                            option = (Integer) lmc.showMenu(EMenuCodes.CreateGroupMenu,
                                    lst);
                            if (option == 1)
                                break;
                            int num = lst.size() + 1;
                            GroupDTO grp = new GroupDTO();
                            grp.setNumber(num);
                            grp.setCourse(selected);

                            selected.addGroup(grp);
                            selected = courseSrv.edit(selected);
                        }
                        break;
                    case 2:
                        startGroupSelection(selected);
                        break;
                    case 3:
                        flag = false;
                        break;
                }
            }
        }
        else
            System.out.println("Неправильный выбор");
    }





    private void startGroupSelection(CourseDTO course){
        List<String> lst = getGroups(course);
        String groupText = (String) lmc.showMenu(EMenuCodes.SelectGroupMenu,
                lst);
        int option = Integer.parseInt(groupText.replaceAll("[\\D]", ""));
        if(option <= groupSrv.getCount() && option > 0) {
            boolean flag = true;
            long courseId = courseSrv.getId(course);
            List<String> lst2 = new LinkedList<>();
            GroupDTO selected = groupSrv.getFromCourseByNum(courseId, option);
            lst2.add(selected.getNumber() + " курс.");
            while(flag){
                option = (Integer) mf.getMenu(EMenuCodes.JunctionSelectGroupMenu).showMenu(lst2);
                switch (option){
                    case 1:
                        while(true){
                            lst = getStudents(courseId, selected);
                            List<Object> tuple = (List<Object>) lmc.showMenu(EMenuCodes.CreateStudentMenu,
                                    lst);
                            List<String> names = (List<String>) tuple.get(0);
                            option = (Integer) tuple.get(1);
                            if(option == 1)
                                break;
                            StudentDTO std = new StudentDTO();
                            std.setName(names.get(0));
                            std.setSurname(names.get(1));
                            std.setGroup(selected);

                            selected.addStudent(std);
                            selected = groupSrv.edit(courseSrv.getId(course), selected);
                        }
                        break;
                    case 2:
                        startStudentSelection(courseId, selected);
                        break;
                    case 3:
                        int grnum = (int)selected.getNumber();
                        option = (Integer) mf.getMenu(EMenuCodes.DeleteGroupChoiceMenu).showMenu(null);
                        if(option == 0) {
                            groupSrv.delete(courseId, selected);
                            course.deleteGroup(grnum);
                            course = courseSrv.edit(course);
                            selected = null;
                        }
                        flag = false;
                        break;
                    case 4:
                        flag = false;
                        break;

                }
            }
        }
        else
            System.out.println("Неправильный выбор");
    }

    private void startStudentSelection(long courseId, GroupDTO group){

    }


    private void printCourses(){
        Iterable<CourseDTO> crss = courseSrv.getAll();
        System.out.println(crss.iterator().hasNext());
        for (CourseDTO ab: crss) {
            System.out.printf("%s курс.", ab.getNumber());
            System.out.println();
        }
    }

    private List<String> getCourses(){
        Iterable<CourseDTO> crss = courseSrv.getAll();
        List<String> courses = new LinkedList<>();
        for (CourseDTO ab: crss) {
            courses.add(ab.getNumber() + " курс.");
        }
        return courses;
    }

    private List<String> getGroups(CourseDTO course){
        List<String> lst = new LinkedList<>();

        Iterable<GroupDTO> groups = groupSrv.getAllGroupsFromCourseById(courseSrv.getId(course));
        if(groups != null)
            for(GroupDTO gr: groups)
                lst.add(gr.getNumber() + " группа.");
        return lst;
    }

    private List<String> getStudents(long courseId, GroupDTO group){
        List<String> lst = new LinkedList<>();

        Iterable<StudentDTO> studs =
                studSrv.getAllStudentsFromGroup(groupSrv.getGroupId(courseId, group));
        if(studs != null){
            for(StudentDTO st: studs)
                lst.add(st.getName() + " " + st.getSurname());
        }

        return lst;
    }
}

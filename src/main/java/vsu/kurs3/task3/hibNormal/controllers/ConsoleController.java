package vsu.kurs3.task3.hibNormal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import vsu.kurs3.task3.hibNormal.models.dto.CourseDTO;
import vsu.kurs3.task3.hibNormal.models.dto.GroupDTO;
import vsu.kurs3.task3.hibNormal.models.dto.StudentDTO;
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
            if(option == 2)
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
                            if (option == 2)
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
                        if(selected.getGroups().size() == 0)
                            System.out.println("Нет групп.");
                        else
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
            lst2.add(selected.getNumber() + " группа.");
            while(flag){
                option = (Integer) mf.getMenu(EMenuCodes.JunctionSelectGroupMenu).showMenu(lst2);
                switch (option){
                    case 1:
                        while(true){
                            lst = getStudents(selected);
                            List<Object> tuple = (List<Object>) lmc.showMenu(EMenuCodes.CreateStudentMenu,
                                    lst);
                            List<String> names = (List<String>) tuple.get(0);
                            option = (Integer) tuple.get(1);
                            if(option == 2)
                                break;
                            StudentDTO std = new StudentDTO();
                            std.setName(names.get(0));
                            std.setSurname(names.get(1));
                            std.setGroup(selected);
                            std.setMarkOne(false);
                            std.setMarkTwo(false);
                            std.setMarkThree(false);

                            selected.addStudent(std);
                            selected = groupSrv.edit(selected);
                            if (!mf.getMenu(EMenuCodes.AddStudentChoiceMenu).showMenu(null).equals(1))
                                break;
                        }
                        break;
                    case 2:
                        if(selected.getStudents().size() == 0)
                            System.out.println("Студентов нет.");
                        else
                            startStudentSelection(selected);
                        break;
                    case 3:
                        option = (Integer) mf.getMenu(EMenuCodes.DeleteGroupChoiceMenu).showMenu(null);
                        if(option == 1) {
                            course.deleteGroup(selected);
                            for(StudentDTO std : selected.getStudents())
                                studSrv.delete(std);
                            groupSrv.delete(selected);
                            course = courseSrv.edit(course);
                            selected = null;
                            flag = false;
                        }
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

    private void startStudentSelection(GroupDTO group){
        List<String> lst = getStudents(group);
        List<String> lst2 = new LinkedList<>();
        List<String> tuple = (List<String>) mf.getMenu(EMenuCodes.SelectStudentMenu).showMenu(
                lst);

        StudentDTO stud = studSrv.getStudentByGroupIdNameSurname(group.getId(),
                tuple.get(0), tuple.get(1));
        lst2.add(tuple.get(0) + " " + tuple.get(1));
        if(stud != null) {
            boolean flag = true;
            while (flag){
                int option = (Integer) mf.getMenu(EMenuCodes.JunctionSelectStudentMenu).showMenu(lst2);
                switch (option) {
                    case 1:
                        while(true)
                        {
                            lst = new LinkedList<>();
                            lst.add(stud.getMarkOne().toString());
                            lst.add(stud.getMarkTwo().toString());
                            lst.add(stud.getMarkThree().toString());
                            int stage = (Integer) mf.getMenu(EMenuCodes.AlterStageMenu).showMenu(lst);
                            if(stage == 0)
                                break;
                            stud.changeStage(stage);
                            stud = studSrv.edit(stud);
                        }
                        break;
                    case 2:
                        option = (Integer) mf.getMenu(EMenuCodes.DeleteStudentChoiceMenu).showMenu(null);
                        if(option == 1) {
                            group.deleteStudent(stud);
                            studSrv.delete(stud);
                            group = groupSrv.edit(group);
                        stud = null;
                        }
                        flag = false;
                    break;
                    case 3:
                        flag = false;
                    break;
                }
            }
        }
        else
            System.out.println("Неправильный выбор студента.");
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

    private List<String> getStudents(GroupDTO group){
        List<String> lst = new LinkedList<>();

        Iterable<StudentDTO> studs =
                studSrv.getAllStudentsFromGroup(group.getId());
        if(studs != null){
            for(StudentDTO st: studs)
                lst.add(st.getName() + " " + st.getSurname());
        }

        return lst;
    }
}

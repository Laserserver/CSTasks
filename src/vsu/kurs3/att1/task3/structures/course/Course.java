package vsu.kurs3.att1.task3.structures.course;

import vsu.kurs3.att1.task3.structures.group.Group;
import vsu.kurs3.att1.task3.structures.group.GroupsOperator;

import java.util.LinkedList;
import java.util.List;

public class Course extends Object {

    private int courseNum;
    private GroupsOperator groupsOperator;

    public Course(int num) {
        courseNum = num;
        groupsOperator = new GroupsOperator(courseNum);
    }

    public GroupsOperator getGroupsOperator() {
        return groupsOperator;
    }

    @Override
    public String toString() {
        return String.format("%d курс", courseNum);
    }
}

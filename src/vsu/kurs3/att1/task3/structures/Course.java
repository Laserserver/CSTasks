package vsu.kurs3.att1.task3.structures;

import java.util.LinkedList;
import java.util.List;

public class Course extends Object {

    private List<Group> groups;
    private int courseNum;
    private int groupCount;

    public Course(int num) {
        groups = new LinkedList<>();
        courseNum = num;
    }

    public void createGroup() {
        groups.add(new Group(++groupCount, courseNum));
    }

    public List<String> getGroupsAsStrings() {
        final List<String> rows = new LinkedList<>();
        groups.forEach(x -> rows.add(x.toString()));
        return rows;
    }

    public Group getGroupByName(String name){
        int ptr = 0;
        while (ptr < groups.size() && !groups.get(ptr).toString().equals(name))       //Пока указатель меньше фактического количества
            ptr++;
        if(ptr == groups.size())        //Если прошлись, но не нашли - бросаем null, метод увидит
            return null;
        return groups.get(ptr);
    }

    public int deleteGroup(Group gr) {  //-1 писос, 1 удалено, 0 нет такого
        if(groups.size() < 1)
            return -1;
        else {
            return groups.remove(gr) ? 1 : 0;
        }
    }

    @Override
    public String toString() {
        return String.format("%d курс", courseNum);
    }
}

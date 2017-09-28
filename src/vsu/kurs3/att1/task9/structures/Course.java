package vsu.kurs3.att1.task9.structures;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Course {

    private List<Group> groups;
    private int courseNum;
    private int groupCount;

    public int getCourseNum(){
        return courseNum;
    }

    public int getCourseSize() {      //Возвращает фактическое количество групп
        return groups.size();
    }

    public Course(int num) {
        groups = new LinkedList<>();
        courseNum = num;
    }

    public void createGroup() {
        groups.add(new Group(++groupCount, courseNum));
    }

    public List<Integer> getGroupsNumsList() {
        final List<Integer> rows = new LinkedList<>();
        groups.forEach(x -> rows.add(x.getGroupNumber()));
        return rows;
    }

    public Group getGroupByNum(int num) {
        int ptr = 0;
        while (ptr < groups.size() && groups.get(ptr).getGroupNumber() != num)       //Пока указатель меньше фактического количества
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
}

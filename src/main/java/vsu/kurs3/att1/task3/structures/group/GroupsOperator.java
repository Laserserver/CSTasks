package vsu.kurs3.att1.task3.structures.group;


import java.util.LinkedList;
import java.util.List;

public class GroupsOperator {

    private List<Group> groups;
    private int courseNum;

    public GroupsOperator(int courseNum){
        groups = new LinkedList<>();
        this.courseNum = courseNum;
    }

    public void createGroup(){
        groups.add(new Group(groups.size() + 1, courseNum));
    }

    public Group getGroupByName(String name){
        int ptr = 0;
        while (ptr < groups.size() && !groups.get(ptr).toString().equals(name))       //Пока указатель меньше фактического количества
            ptr++;
        if(ptr == groups.size())        //Если прошлись, но не нашли - бросаем null, метод увидит
            return null;
        return groups.get(ptr);
    }

    public void deleteGroup(Group gr) {  //-1 писос, 1 удалено, 0 нет такого
        if(groups.size() > 0)
            groups.remove(gr);
    }

    public List<String> getGroupNamesAsText(){
        List<String> str = new LinkedList<>();
        groups.forEach(x -> str.add(x.toString()));
        return str;
    }
}

package vsu.kurs3.att1.task9;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Course {

    private List<Group> groups;
    private final int courseNum;
    private int groupCount;

    public int getCourseNum(){
        return courseNum;
    }

    public int getGroupSize(){      //Возвращает фактическое количество групп
        return groups.size();
    }

    public int getGroupCount(){     //Возвращает последний номер группы
        return groupCount;
    }

    public Course(int num)
    {
        groups = new LinkedList<>();
        courseNum = num;
    }

    public void createGroup()
    {
        groups.add(new Group(++groupCount, courseNum));
    }

    public void getGroupsList()
    {
        IntStream.range(1, groups.size() + 1).forEach(
                num -> System.out.println("    " + groups.get(num - 1).getNumber() + " группа.")
        );
    }

    public Group selectGroup(int num) {
        int ptr = 0;
        while (ptr < groups.size() && groups.get(ptr).getNumber() != num)       //Пока указатель меньше фактического количества
            ptr++;
        if(ptr == groups.size())        //Если прошлись, но не нашли - бросаем null, метод увидит
            return null;
        return groups.get(ptr);
    }

    public void deleteGroup(int num)
    {
        if(groups.size() < 1)
            System.out.println("Групп уже нет");
        else {
            int ptr = 0;
            while (ptr < groups.size() && groups.get(ptr).getNumber() != num)
                ptr++;
            if(ptr != groups.size()) {
                groups.remove(ptr);
                groupCount--;
            }
            else
                System.out.println("Такой группы нет.");
        }
    }
}

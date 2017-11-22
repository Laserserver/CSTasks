package vsu.kurs3.task3.legacy.structures.student;

import java.util.LinkedList;
import java.util.List;

public class MarksOperator {
    private boolean[] marks;

    MarksOperator(){
        marks = new boolean[3];
    }

    public List<String> getMarksAsText(){
        List<String> str = new LinkedList<>();

        str.add("1 этап: " + (marks[0] ? "сдано" : "не сдано"));
        str.add("2 этап: " + (marks[1] ? "сдано" : "не сдано"));
        str.add("3 этап: " + (marks[2] ? "сдано" : "не сдано"));

        return str;
    }

    public void changeStage(int stage, boolean mark){
        marks[stage] = mark;
    }
}

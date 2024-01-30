package main.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
        List<Student> list = List.of(new Student(1, "김유신"),
                new Student(3, "김유진"),
                new Student(5, "김유친"));
        List<Student> listAl = new ArrayList<>(list);
        Collections.sort(listAl);
        System.out.println(listAl);

    }
}


class Student implements Comparable<Student> {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);
    }

    public String toString() {
        return this.id + " " + this.name;
    }
}

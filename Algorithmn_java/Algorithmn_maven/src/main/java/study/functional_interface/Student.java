package study.functional_interface;

import study.generic.Person;

public class Student extends Person {

    private String sex;
    private int score;
    public Student(String name, String sex, int score) {
        super(name);
        this.sex = sex;
        this.score = score;
    }
    public String getSex() {
        return sex;
    }

    public int getScore() {
        return score;
    }
}

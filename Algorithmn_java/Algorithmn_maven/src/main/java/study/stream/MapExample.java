package study.stream;

import java.util.Arrays;
import java.util.List;
import study.functional_interface.Student;

public class MapExample {
    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(
                new Student("김순희", "여자", 90),
                new Student("김자바", "남자", 95),
                new Student("박한나", "여자", 92)
        );

        studentList.stream()
                .mapToInt(Student::getScore)
                .forEach(score -> System.out.println(score));
    }
}

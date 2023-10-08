package study.functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FunctionExample1 {
    private static List<Student> list = Arrays.asList(
            new Student("홍길동", "남자", 90),
            new Student("신용권", "남자", 93)
    );

    public static void printString(Function<Student, String> function) {
        for(Student student : list) {
            System.out.println(function.apply(student) + " ");
        }
        System.out.println();
    }

    public static void printInt(ToIntFunction<Student> function) {
        for(Student student : list) {
            System.out.println(function.applyAsInt(student) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("[학생 이름]");
        printString(t -> t.getName());

        System.out.println("[학생 성적]");
        printInt(t -> t.getScore());
    }
}

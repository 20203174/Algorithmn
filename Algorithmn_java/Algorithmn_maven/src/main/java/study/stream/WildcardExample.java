package study.stream;

import java.util.List;

public class WildcardExample {
    // 와일드카드를 사용하여 리스트의 요소를 출력하는 메서드 작성
    public static void printListElements(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }


    public static void main(String[] args) {
        // 정수 리스트 생성
        List<Integer> integerList = List.of(1, 2, 3, 4, 5);

        // 문자열 리스트 생성
        List<String> stringList = List.of("A", "B", "C", "D", "E");

        // printListElements 메서드를 사용하여 각각의 리스트 출력
        System.out.println("Integer List:");
        printListElements(integerList);

        System.out.println("\nString List:");
        printListElements(stringList);
    }
}

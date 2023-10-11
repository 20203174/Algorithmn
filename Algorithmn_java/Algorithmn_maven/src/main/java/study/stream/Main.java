package study.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

    public class Main {
        public static void main(String[] args) {
            // Book 객체 생성
            List<Book> books = new ArrayList<>();
            books.add(new Book("Book1", 19));
            books.add(new Book("Book2", 12));
            books.add(new Book("Book3", 24));

            // 가격에 따라 도서 리스트 정렬
            Collections.sort(books);

            // 정렬된 도서 리스트 출력
            for (Book book : books) {
                System.out.println(book.price);
            }
            MyInterface<Integer> myInterface = List::size;
            System.out.println(myInterface.quokka(books));
        }
    }
package study.stream;

public class Book implements Comparable<Book> {
    String name;
    int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }


    @Override
    public int compareTo(Book o) {
        return Integer.compare(this.price, o.price);
    }
}

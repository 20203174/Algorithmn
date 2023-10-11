package study.stream;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    List<T> itemList;

    public Box() {
        itemList = new ArrayList<>();
    }
    public void addItem(T t) {
        itemList.add(t);
    }
    public T getItem(int index) {
        return itemList.get(index);
    }
}

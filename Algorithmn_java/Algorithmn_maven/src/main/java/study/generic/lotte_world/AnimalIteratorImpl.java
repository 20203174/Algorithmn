package study.generic.lotte_world;

import java.util.Iterator;
import java.util.List;

public class AnimalIteratorImpl<E extends Animal> {
    Iterator<E> iterator;

    public AnimalIteratorImpl(List<E> list) {
        this.iterator = list.iterator();
    }

    public void iterateAnimal() {
        while(iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }
    }
}

package study.generic.lotte_world;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface AnimalIterator<E> {
    boolean hasNext();
    E next();
}

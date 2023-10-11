package study.stream;

import java.util.List;

@FunctionalInterface
public interface MyInterface<T> {
    T quokka(List<?> list);
}

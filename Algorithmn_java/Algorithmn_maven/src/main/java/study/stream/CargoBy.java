package study.stream;

public interface CargoBy<T> {

    void load(T o);

    T unload(int index);
}

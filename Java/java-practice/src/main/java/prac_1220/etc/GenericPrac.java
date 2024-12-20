package prac_1220.etc;

public class GenericPrac<T, V> {
    private T value;
    private V value2;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

package vn.duy.java.lamdaIntro.custom;

@FunctionalInterface
public interface Operation<T> {
    T operate(T o1, T o2);
}

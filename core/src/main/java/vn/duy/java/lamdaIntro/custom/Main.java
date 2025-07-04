package vn.duy.java.lamdaIntro.custom;

public class Main {
    public static void main(String[] args) {
//        calculate(new Operation<Integer>() {
//            @Override
//            public Integer operate(Integer o1, Integer o2) {
//                return o1 + o2;
//            }
//        }, 5, 10);
        calculate((o1, o2) -> o1 + o2, 1, 2);
        calculate((var o1, var o2) -> o1 + o2, 1, 2);
        calculate((var o1, var o2) -> {
           return o1 + o2;
        }, 1, 2);
    }
    public static <T> T calculate(Operation<T> operation, T o1, T o2) {
        T result = operation.operate(o1, o2);
        System.out.println("Result: " + result);
        return result;
    }
}

package buoi9;

public interface ToStringUtils<T> {
    default void print (T obj, Class<?> clazz){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(clazz.getSimpleName());
        System.out.println(stringBuilder.toString());
    }
}

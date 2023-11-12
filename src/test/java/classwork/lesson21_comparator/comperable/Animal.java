package classwork.lesson21_comparator.comperable;

public interface Animal {
    String move();

    default String sleep(){
        return ("sleep");

    }
}

package classwork.lesson21_comparator.generics;

public class MyDataSimple<T> {
    T t;

    public MyDataSimple(T t){
        this.t = t;
    }

    public T getT(){
        return t;
    }

    public void setT(T t){
        this.t = t;
    }
}

package homework.stream_api;

public enum Manager {
    Y("Manager"),
    N("Not manager");

    public String value;

    Manager(String value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

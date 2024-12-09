package L5.model;

public class Patient extends Human {
    String note;


    public Patient(int age, String name, String note) {
        super(age, name);
        this.note = note;
    }
}

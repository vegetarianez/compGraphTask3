package L5.model;

public class Delivery {
    String date;
    Patient patient;
    Drug drug;

    public Delivery(String date, Patient patient, Drug drug) {
        this.date = date;
        this.patient = patient;
        this.drug = drug;
    }
}

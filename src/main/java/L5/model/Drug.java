package L5.model;

public class Drug implements Interface{
    String nameOfDrug;
    int milligrames;

    public Drug(String nameOfDrug, int milligrames) {
        this.nameOfDrug = nameOfDrug;
        this.milligrames = milligrames;
    }

    public void say(){
        System.out.println("Препарат " + nameOfDrug + " колво в миллиграммах " + milligrames);
    }
}

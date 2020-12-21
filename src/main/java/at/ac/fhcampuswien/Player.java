package at.ac.fhcampuswien;

public class Player extends GamePerson{

    private double budget;
    private double einsatz = 1;

    public Player(double budget) {
        this.budget = budget;
    }

    public double getEinsatz() {
        return einsatz;
    }

    public void setEinsatz(double einsatz) {
        this.einsatz = einsatz;
    }
}

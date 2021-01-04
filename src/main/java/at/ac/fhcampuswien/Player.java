package at.ac.fhcampuswien;

public class Player extends GamePerson{

    private double budget = 100;
    private double einsatz = 10;

    public Player(double budget) {
        this.budget = budget;
    }

    public double getEinsatz() {
        return einsatz;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setEinsatz(double einsatz) {
        this.einsatz = einsatz;
    }
}

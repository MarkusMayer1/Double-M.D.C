package at.ac.fhcampuswien;

public class Player extends GamePerson {

    private double budget;
    private double bet = 10;

    public Player(double budget) {
        this.budget = budget;
    }

    public double getBet() {
        return bet;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setBet(double bet) {
        this.bet = bet;
    }
}

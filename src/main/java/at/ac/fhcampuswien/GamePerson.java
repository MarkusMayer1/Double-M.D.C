package at.ac.fhcampuswien;

public class GamePerson {

    private double budget;
    public Hand GameHand;

    public GamePerson() {
        GameHand = new Hand();
    }

    public void getCard(Deck deck){
        GameHand.addCard(deck);
    }

    public Hand getGameHand() {
        return GameHand;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}

package at.ac.fhcampuswien;

public class Game {

    private Deck deck;
    private Player p = new Player(100);
    private Dealer d;

    public Game() {

    }

    public void startGame() {
        deck = new Deck();
        p.reset();
        d = new Dealer(deck);
        p.getCard(deck);
        p.getCard(deck);
        d.getCard(deck);
    }

    public void hit() {
        p.getCard(deck);
    }

    // Dealer zieht nach der Methode Karten
    public void dealersTurn() {
        d.drawCards();
    }

    public String checkWin() {
        if (p.getGameHand().handValue() == 21 && p.getGameHand().getHand().size() == 2 && d.getGameHand().handValue() == 21 && d.getGameHand().getHand().size() != 2) {
            p.setBudget(p.getBudget() + p.getBet() * 2.5);
            return "The Player won";
        } else if (p.getGameHand().handValue() == 21 && p.getGameHand().getHand().size() != 2 && d.getGameHand().handValue() == 21 && d.getGameHand().getHand().size() == 2) {
            return "The Dealer won";
        } else if ((p.getGameHand().handValue() > d.getGameHand().handValue() && p.getGameHand().handValue() <= 21) || (d.getGameHand().handValue() > 21 && p.getGameHand().handValue() <= 21)) {
            if (p.getGameHand().handValue() == 21 && p.getGameHand().getHand().size() == 2) {
                p.setBudget(p.getBudget() + p.getBet() * 2.5);
            } else {
                p.setBudget(p.getBudget() + p.getBet() * 2);
            }
            return "The Player won";
        } else if ((p.getGameHand().handValue() < d.getGameHand().handValue() && d.getGameHand().handValue() <= 21) || (p.getGameHand().handValue() > 21 && d.getGameHand().handValue() <= 21)) {
            return "The Dealer won";
        } else if (p.getGameHand().getHand().size() == 7) {
            return "The Player won";
        } else {
            p.setBudget(p.getBudget() + p.getBet());
            return "Draw";
        }
    }

    public Deck getDeck() {
        return deck;
    }

    public Player getP() {
        return p;
    }

    public Dealer getD() {
        return d;
    }
}

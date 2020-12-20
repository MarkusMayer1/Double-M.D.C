package at.ac.fhcampuswien;

public class Game {

    private Deck deck;
    private Player p;
    private Dealer d;

    public Game() {

    }

    public void StartGame() {
        deck = new Deck();
        p = new Player(100);
        d = new Dealer(deck);
        p.getCard(deck);
        p.getCard(deck);
    }

    public void Hit() {
        p.getCard(deck);
    }

    public void Stand() {
        d.drawCards();
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Player getP() {
        return p;
    }

    public void setP(Player p) {
        this.p = p;
    }

    public Dealer getD() {
        return d;
    }

    public void setD(Dealer d) {
        this.d = d;
    }
}

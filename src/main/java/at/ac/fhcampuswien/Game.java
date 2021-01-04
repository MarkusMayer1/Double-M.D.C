package at.ac.fhcampuswien;

public class Game {

    private Deck deck;
    private Player p = new Player(100);
    private Dealer d;


    public Game() {

    }

    public void StartGame(double budget) {
        deck = new Deck();
        p.reset();
        d = new Dealer(deck);
        p.getCard(deck);
        p.getCard(deck);
        d.getCard(deck);
        d.getCard(deck);
    }

    public void Hit() {
        p.getCard(deck);
    }

    public void Stand() {
        d.drawCards();
    }

    public String checkWin(){
        if((p.getGameHand().HandValue() > d.getGameHand().HandValue() && p.getGameHand().HandValue() <= 21) || (d.getGameHand().HandValue() > 21 && p.getGameHand().HandValue() <= 21)){

            p.setBudget(p.getBudget()+ p.getEinsatz()*2);
            return "The Player won";

        }
        else if((p.getGameHand().HandValue() < d.getGameHand().HandValue() && d.getGameHand().HandValue() <= 21) || (p.getGameHand().HandValue() > 21 && d.getGameHand().HandValue() <= 21)){

            return "The Dealer won";
        }
        else {
            p.setBudget(p.getBudget()+ p.getEinsatz());
            return "Draw";
        }
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

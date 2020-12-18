package at.ac.fhcampuswien;

public class GamePerson {



    private Deck deck = new Deck();

    public Deck getDeck() {
        return deck;
    }

    public Hand GameHand = new Hand();


    public void getCard(Deck deck){

        GameHand.addCard(deck);

    }

    public Hand getGameHand() {
        return GameHand;
    }


}

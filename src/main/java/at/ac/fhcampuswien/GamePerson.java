package at.ac.fhcampuswien;

public abstract class GamePerson {


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

    public void reset() {

        GameHand = new Hand();
    }


}

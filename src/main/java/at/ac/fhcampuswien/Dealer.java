package at.ac.fhcampuswien;

public class Dealer extends GamePerson {

    private Deck deck;

    public Dealer(Deck deck) {
        this.deck = deck;
    }

    public void drawCards(){
       while (getGameHand().HandValue() < 17){
           getCard(deck);
       }
   }
}

package at.ac.fhcampuswien;

public class Dealer extends GamePerson {

   private Deck deck = getDeck();



   public void drawCard(){

       while (getGameHand().HandValue() < 17){

           getCard(deck);
       }

   }
}

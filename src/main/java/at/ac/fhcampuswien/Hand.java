package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> hand;

    public Hand() {
        hand = new ArrayList<>();
    }

    public void addCard(Deck deck){
        hand.add(deck.Hit());
    }

    public int HandValue(){
        int aces = 0;
        int summe = 0;

        for (Card card : hand) {
            if (card.rank == Card.Rank.Ass) {
                aces++;
            }
        }
        for (Card card : hand) {
            if (summe > 21 && aces > 0) {
                summe = summe - 10;
                aces--;
            }
            summe = summe + card.value;
        }

        return summe;
    }

    public List<Card> getHand() {
        return hand;
    }
}

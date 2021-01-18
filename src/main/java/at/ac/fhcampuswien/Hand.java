package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> hand;

    public Hand() {
        hand = new ArrayList<>();
    }

    public void addCard(Deck deck){
        hand.add(deck.hit());
    }

    public int handValue(){
        int aces = 0;
        int sum = 0;

        for (Card card : hand) {
            if (card.rank == Card.Rank.Ass) {
                aces++;
            }
        }
        for (Card card : hand) {
            sum = sum + card.value;
            if (sum > 21 && aces > 0) {
                sum = sum - 10;
                aces--;
            }

        }

        return sum;
    }

    public List<Card> getHand() {
        return hand;
    }
}

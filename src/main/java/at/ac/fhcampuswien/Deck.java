package at.ac.fhcampuswien;

import at.ac.fhcampuswien.Card.Suit;
import at.ac.fhcampuswien.Card.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    private List<Card> deck = new ArrayList<>();

    public Deck(){
        createDeck();
        shuffleDeck();
    }

    public void createDeck() {
        for (Suit suit: Suit.values()) {
            for (Rank rank: Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    public void shuffleDeck() {
        Random rand = new Random();
        Card card;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < deck.size(); j++){
                int number = rand.nextInt(deck.size());
                card = deck.get(number);
                deck.set(number, deck.get(j));
                deck.set(j, card);
            }
        }
    }

    public Card Hit(){
        Card card = deck.get(0);
        deck.remove(0);

        return card;
    }
}

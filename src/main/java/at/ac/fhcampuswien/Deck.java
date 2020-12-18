package at.ac.fhcampuswien;

import at.ac.fhcampuswien.Card.Suit;
import at.ac.fhcampuswien.Card.Rank;

import java.util.Random;

public class Deck {

    private Card[] deck = new Card[52];

    public Deck(){

        createDeck();
        shuffleDeck();
    }



    private void createDeck() {

        int i = 0;
        for (Suit suit: Suit.values()) {
            for (Rank rank: Rank.values()) {

                deck[i++] = new Card(suit, rank);
            }
        }
    }
    private void shuffleDeck() {

        Random rand = new Random();
        Card card;
        for(int i = 0; i < 5; i++){

            for(int j = 0; j < deck.length; j++){

                int number = rand.nextInt(deck.length);
                card = deck[number];
                deck[number] = deck[j];
                deck[j] = card;
            }
        }

    }

    public Card Hit(){


        Card card = null;
        int i = 0;
        while (card == null){

            if(deck[i] == null){
                i++;
            }
            else{
                card = deck[i];

            }

        }
        deck[i] = null;

        return card;
    }


}

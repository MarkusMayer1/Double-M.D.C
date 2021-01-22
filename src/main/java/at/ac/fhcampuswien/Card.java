package at.ac.fhcampuswien;

public class Card {

    public Suit suit;
    public Rank rank;
    public int value;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.value = rank.value;
    }

    enum Suit {
        Herz,
        Karo,
        Kreuz,
        Pik
    };

    enum Rank {
        Zwei(2),
        Drei(3),
        Vier(4),
        Fuenf(5),
        Sechs(6),
        Sieben(7),
        Acht(8),
        Neun(9),
        Zehn(10),
        Bube(10),
        Dame(10),
        Koenig(10),
        Ass(11);

        int value;

        Rank(int value) {
            this.value = value;
        }
    };

    @Override
    public String toString() {
        return suit.toString() + "-" + rank.toString() + ".png";
    }
}

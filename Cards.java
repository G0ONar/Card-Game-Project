//This creates card objects
public class Cards {
    private final int rank;
    private final int suit;

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    @Override//overides the parent class
    public String toString() {
        return rankToString(rank) + " of " + suitToString(suit);
    }
//case means switch
    private String rankToString(int r) {
        switch (r) {
            case 11: return "Jack";
            case 12: return "Queen";
            case 13: return "King";
            case 14: return "Ace";
            default: return String.valueOf(r);
        }
    }

    private String suitToString(int s) {
        switch (s) {
            case 0: return "Clubs";
            case 1: return "Diamonds";
            case 2: return "Hearts";
            case 3: return "Spades";
            default: return "Unknown";
        }
    }
}
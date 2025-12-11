//This is how you see and hold your cards
public class Hand {
    import java.util.ArrayList;

public class Hand {

    private ArrayList<Cards> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Cards c) {
        cards.add(c);
    }

    public Cards removeCard(int rank) {
        
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getRank() == rank) {
                return cards.remove(i);
            }
        }
        return null;//null means none
    }

    public boolean hasRank(int rank) { //boolean is a switch type thing
        for (Cards c : cards) {
            if (c.getRank() == rank) return true;
        }
        return false;
    }

    public int countRank(int rank) {
        int count = 0;
        for (Cards c : cards) {
            if (c.getRank() == rank) count++;
        }
        return count;
    }

    public ArrayList<Cards> getCards() {
        return cards;
    }

    @Override //overides parent class
    public String toString() {
        return cards.toString();
    }
}
}
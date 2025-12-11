//This makes the deck of cards and deals them
public class Deck {
    import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Cards> deck;

    public Deck() {
        deck = new ArrayList<>();

        
        for (int suit = 0; suit < 4; suit++) {
            for (int rank = 2; rank <= 14; rank++) {
                deck.add(new Cards(rank, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Cards dealCard() {
        if (deck.isEmpty()) return null;
        return deck.remove(0);
    }

    public int size() {
        return deck.size();
    }
}
}
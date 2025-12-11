//This is how the game actually works.
public class GoFish {

    public static void main(String[] args) {
        ArrayList<String> ranks = new ArrayList<>();
        String[] rankArray = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        for (String r : rankArray) {
            for (int i = 0; i < 4; i++) {
                ranks.add(r);
            }
        }
        Collections.shuffle(ranks);

        ArrayList<String> playerHand = new ArrayList<>();
        ArrayList<String> opponentHand = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            playerHand.add(ranks.remove(ranks.size()-1));
            opponentHand.add(ranks.remove(ranks.size()-1));
        }

        ArrayList<String> playerBooks = new ArrayList<>();
        ArrayList<String> opponentBooks = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);//looks at what the player typed
        Random rand = new Random();

        boolean playerTurn = true;//boolean is a switch type thing

        while (!ranks.isEmpty() || !playerHand.isEmpty() || !opponentHand.isEmpty()) {
            if (playerTurn) {
                System.out.println("\nYour hand: " + playerHand);
                System.out.print("Which card do you want to ask for? ");
                String requestedCard = scanner.nextLine().trim();

                boolean extraTurn = goFish(playerHand, opponentHand, ranks, requestedCard);
                playerBooks.addAll(checkForBooks(playerHand));

                if (!extraTurn) {
                    playerTurn = false; //switches turns
                }
            } else {
               
                if (!opponentHand.isEmpty()) {
                    String requestedCard = opponentHand.get(rand.nextInt(opponentHand.size()));
                    System.out.println("\nOpponent asks for: " + requestedCard);
                    boolean extraTurn = goFish(opponentHand, playerHand, ranks, requestedCard);
                    opponentBooks.addAll(checkForBooks(opponentHand));

                    if (!extraTurn) {
                        playerTurn = true; // switch turn
                    }
                } else {
                    playerTurn = true; // skip opponent turn if hand empty
                }
            }
        }

        System.out.println("\nGame over!");
        System.out.println("Your books: " + playerBooks.size() + " - " + playerBooks);
        System.out.println("Opponent books: " + opponentBooks.size() + " - " + opponentBooks);

        if (playerBooks.size() > opponentBooks.size()) {
            System.out.println("You win!");
        } else if (playerBooks.size() < opponentBooks.size()) {
            System.out.println("Opponent wins!");
        } else {
            System.out.println("It's a tie!");
        }

        scanner.close();
    }

    public static ArrayList<String> checkForBooks(ArrayList<String> hand) {
        ArrayList<String> books = new ArrayList<>();
        ArrayList<String> checked = new ArrayList<>();
        for (String card : hand) {
            if (!checked.contains(card) && Collections.frequency(hand, card) == 4) {
                books.add(card);
                for (int i = 0; i < 4; i++) {
                    hand.remove(card);
                }
            }
            checked.add(card);
        }
        return books;
    }

    public static boolean goFish(ArrayList<String> askerHand, ArrayList<String> responderHand, 
                                 ArrayList<String> deck, String requestedCard) {
        if (responderHand.contains(requestedCard)) {
            System.out.println((askerHand == responderHand ? "Opponent" : "Player") + " got " + requestedCard + "!");
            while (responderHand.contains(requestedCard)) {
                responderHand.remove(requestedCard);//hand giving cards
                askerHand.add(requestedCard);//hand asking for cards
            }
            return true; //gets another turn
        } else {
            System.out.println("Go Fish!");
            if (!deck.isEmpty()) {
                String drawnCard = deck.remove(deck.size()-1);
                askerHand.add(drawnCard);
                System.out.println("Drew: " + drawnCard);
            }
            return false; //ends turn
        }
    }
}

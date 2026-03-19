public class Player {
    private String playerName;
    private Card[] cards;
    private Card currentCard;
    private int lastCardIndex;
    private int totalCardsCount;

    public Player(String playerName, int totalCardsCount) {
        this.playerName = playerName;
        this.totalCardsCount = totalCardsCount;
        this.cards = new Card[totalCardsCount];
        this.currentCard = null;
        this.lastCardIndex = -1;
    }

    public void addCard(Card card) {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] == null) {
                cards[i] = card;
                return;
            }
        }
    }

    public void removeCard(Card card) {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] == card) {
                cards[i] = null;
                return;
            }
        }
    }

    public int getCardCount() {
        int count = 0;
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != null) {
                count++;
            }
        }
        return count;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void nextCard() {
        if (getCardCount() == 0) {
            currentCard = null;
            return;
        }

        int index = lastCardIndex;

        for (int i = 0; i < cards.length; i++) {
            index = (index + 1) % cards.length;
            if (cards[index] != null) {
                currentCard = cards[index];
                lastCardIndex = index;
                return;
            }
        }
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public boolean hasWon() {
        return getCardCount() == totalCardsCount;
    }
}
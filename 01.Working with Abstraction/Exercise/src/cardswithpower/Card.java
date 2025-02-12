package cardswithpower;

public class Card {
    private final int power;
    private RankPowers rank;
    private SuitPowers suit;

    public Card(String rank, String suit) {
        this.rank = RankPowers.valueOf(rank);
        this.suit = SuitPowers.valueOf(suit);
        this.power = RankPowers.valueOf(rank).getPower() + SuitPowers.valueOf(suit).getPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", rank, suit, power);
    }
}

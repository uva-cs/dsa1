package casino;

/* Class definition, must be in a file called Card.java */
public class Card {
	
	public enum Suit{
		Hearts, Diamonds, Spades, Clubs; 
	}
	
	private int rank; //1 (Ace) through 13 (King)
	private Suit suit; //"Spades", "Hearts", "Clubs", "Diamonds"

	/* Default constructor. Ace of Sp. is default card */
	public Card() {
		this.rank = 1;
		this.suit = Suit.Spades;
	}
	
	/*
	 * Constructor. Allows you to set the cards data when
	 * creating it. This is called overloading a method
	 */
	public Card(int rank, Suit suit) {
		this.setRank(rank);
		setSuit(suit);
	}
	
	public int getRank() { return this.rank; }
	public Suit getSuit() { return this.suit; }
	
	private void setRank(int newRank) {
		/* Ignore if trying to set to illegal value */
		if(newRank < 1 || newRank > 13) return;
		
		/* Otherwise, set it */
		this.rank = newRank;
	}
	private void setSuit(Suit newSuit) {
		/* No stress, enum already must have valid value */
		this.suit = newSuit;
	}
	
	/**
	 * This is a method, will return a description
	 * of this card as a String 
	 */
	public String toString() {
		String rank = "";
		switch(this.rank) {
			case 1:
				rank = "Ace";
				break;
			case 11:
				rank = "Jack";
				break;
			case 12:
				rank = "Queen";
				break;
			case 13:
				rank = "King";
				break;
			default:
				rank = "" + this.rank; //number and rank the same
				break;
		}
		
		return rank + " of " + this.suit; 	
	}
	
	@Override
	public boolean equals(Object other) {
		Card otherC = (Card)other;
		return otherC.rank == this.rank && otherC.suit == this.suit;
	}
	
	public Card clone()  {
		return new Card(this.rank, this.suit);
	}

}

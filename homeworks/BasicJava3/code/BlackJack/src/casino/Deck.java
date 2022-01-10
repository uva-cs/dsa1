package casino;

import casino.Card.Suit;

public class Deck {
	
	/* private: Others cannot change the deck directly */
	private Card[] deck;
	private int top = 0; //Top of the deck
	
	public Deck() {
		deck = new Card[52]; //deck has 52 cards
		
		/* Instantiate each individual card */
		int i = 0;
		for(int r = 1; r <= 13; r++) {
			for(Suit s : Suit.values()) {
				deck[i] = new Card(r, s);
				i++;
			}
		}
		
		/*Shuffle the deck*/
		shuffle();
	}
	
	/**
	 * Shuffles the deck
	 */
	public void shuffle() {
		for(int i = 0; i < deck.length-1; i++) {
			/*Get a random position between i and 51*/
			int r = (int)(Math.random()*(52-i))+i;
			
			/* Swap card i with that card */
			Card temp = deck[i];
			deck[i] = deck[r];
			deck[r] = temp;
		}
	}
	
	public int cardsLeft() {
		return deck.length - top;
	}
	
	/** 
	 * Deals the top card, indices < top are not in the deck
	 * Simulates this by moving the top pointer
	 */
	public Card dealTopCard() {
		if(top >= deck.length) restockDeck();
		
		top++;
		return deck[top-1];
	}
	
	public void restockDeck() {
		top = 0;
		shuffle();
	}
}

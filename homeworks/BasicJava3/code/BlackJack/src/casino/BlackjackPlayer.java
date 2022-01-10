package casino;

import java.util.ArrayList;

public abstract class BlackjackPlayer {
	
	/* Money:  */
	private int chips = 1000;
	protected ArrayList<Card> cards = new ArrayList<Card>();
	
	/* The dealer this player is playing with */
	public BlackjackDealer dealer;
	
	public abstract int getBet();
	public abstract Move getMove();
	public abstract void handOver(Card[] dealerHand);
	
	public int getChips() { return chips; }
	protected void takeChips(int amount) { this.chips -= amount; }
	protected void giveChips(int amount) { this.chips += amount; }
	
	public int handScore() {
		int tot = 0;
		int numAces = 0;
		for(Card c : cards) {
			int rank = c.getRank();
			if(rank > 10) rank = 10;
			if(rank == 1) { numAces++; rank = 11;}
			tot += rank;
		}
		while(tot > 21 && numAces > 0) {
			tot -= 10; numAces--;
		}
		
		return tot;
	}
	
	public void setDealer(BlackjackDealer dealer) {
		this.dealer = dealer;
	}
}

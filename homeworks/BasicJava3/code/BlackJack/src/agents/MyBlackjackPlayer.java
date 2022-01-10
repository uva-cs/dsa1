package agents;

import casino.BlackjackPlayer;
import casino.Card;
import casino.Move;

public class MyBlackjackPlayer extends BlackjackPlayer{

	@Override
	public int getBet() {
		return 10; //always bet 10
	}

	@Override
	public Move getMove() {
		/* Hits until we get a score of 16 or better */
		if(this.handScore() <= 16) return Move.HIT;
		return Move.STAY;
	}

	@Override
	public void handOver(Card[] dealerHand) {
		/**
		 * If you care about looking at the dealer's hand once
		 * the hand is over, then you can do it here. This method
		 * is called automatically after every hand and a copy of the dealer's
		 * final hand is given to you to process.
		 */
		
	}

	
}

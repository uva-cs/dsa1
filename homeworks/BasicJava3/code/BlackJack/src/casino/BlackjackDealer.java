package casino;

import java.util.ArrayList;

public class BlackjackDealer {
	
	private BlackjackPlayer player;
	private ArrayList<Card> dealerHand = new ArrayList<Card>();
	private ArrayList<Card> playerHand = new ArrayList<Card>(); //duplicate of player hand so no foul play occurs
	
	int playerChips = 1000;
	
	private DeckStack decks = new DeckStack(5);
	
	public BlackjackDealer(BlackjackPlayer p) {
		this.player = p;
	}
	
	private void hitDealer() { this.dealerHand.add(decks.dealTopCard()); }
	private void hitPlayer() {
		Card c = decks.dealTopCard();
		this.playerHand.add(c.clone());
		player.cards.add(c.clone());
	}
	
	public Card getVisibleCard() {
		return dealerHand.get(0);
	}
	
	public int cardsLeft() {
		return decks.cardsLeft();
	}
	
	protected void playHand() {
		/* Clear the player hands */
		this.player.cards.clear();
		this.dealerHand.clear();
		this.playerHand.clear();
		
		/* Need at least 18 cards to play a hand between two players */
		if(decks.cardsLeft() < 18) decks.restoreDecks();
		
		int bet = player.getBet();
		player.takeChips(bet);
		playerChips -= bet;
		
		/* Deal the cards */
		hitDealer();
		hitPlayer();
		hitDealer();
		hitPlayer();
		
		/* Get the player's first move */
		Move playerMove = player.getMove();
		while(playerMove != Move.STAY && handScore(this.playerHand) < 21) {
			if(playerMove == Move.HIT) hitPlayer();
			if(playerMove == Move.DOUBLE) {
				player.takeChips(bet);
				playerChips -= bet;
				bet*=2;    
				hitPlayer();
				break;
			}
				
			playerMove = player.getMove();
		}
		
		/* Dealer Goes: Hits until at 17 or more */
		while(handScore(this.dealerHand) < 17) hitDealer();
		
		
		/* See who wins and give money to player if necessary*/
		int d = handScore(this.dealerHand);
		int p = handScore(this.playerHand);
		
		System.out.println("END OF ROUND");
		System.out.println("___________________________");
		System.out.println("Player Chips Before: " + (this.player.getChips()+bet));
		
		//If dealer has black jack, game over
		int win = 0;
		if(d == 21 && this.dealerHand.size() == 2); //do nothing, keep player bet
		else if(p > 21); //player busts
		else if(d > 21) win=bet*2; //dealer busts, payout is 1.5x
		else if(p == 21 && this.playerHand.size() == 2) win = bet+((int)(bet*1.5)); //blackjack! payout is 2x
		else if(p > d) win = bet*2; //player wins, payout is 1.5x
		else if(p == d) win = bet; //tie, player gets the bet back
		player.giveChips(win);
		playerChips += win;
		
		if(!verifyChips()) {
			System.out.println("FATAL ERROR: Chip count doesn't match, player is trying to manipulate their chip amount!!!");
			System.exit(3);
		}
		
		System.out.println("Dealer Hand: " + this.dealerHand);
		System.out.println("Dealer Score: " + d + "\n");
		System.out.println("Player Hand: " + this.playerHand);
		System.out.println("Player Score: " + p);
		System.out.println("Player Chips After: " + (this.player.getChips()) + "\n");
		
		/* Give the player a copy of the dealer's hand for their referece */
		Card[] dHand = new Card[this.dealerHand.size()];
		for(int i=0; i<this.dealerHand.size(); i++) dHand[i] = this.dealerHand.get(i).clone();
		this.player.handOver(dHand);
	}
	
	public int handScore(ArrayList<Card> cards) {
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
	
	private boolean verifyChips() {
		return player.getChips() == this.playerChips;
	}

}

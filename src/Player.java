import java.util.ArrayList;

public class Player {
	
	private String name;
	private ArrayList<Card> handOfCards;
	private int totalWins;
	
	public Player(String name){
		this.name = name;
		this.totalWins = 0;
		this.handOfCards = new ArrayList<>();	
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getTotWins(){
		return this.totalWins;
	}
	
	public void addAWin(){
		this.totalWins++;
	}
	
	public void addCardToHand(Card card){
		this.handOfCards.add(card);
	}
	
	public int getTotalCardsFromHand(){
		return this.handOfCards.size();
	}
	
	public Card getACardFromHand(int index){
		return this.handOfCards.get(index);
	}
	
	public void returnCardsToDeck(DeckOfCards deck){
		for(Card card : handOfCards){
			deck.returnACardToDeck(card);
		}
		handOfCards.removeAll(handOfCards);
	}
	
	public void showHand(){
		for(Card c : handOfCards){
			System.out.println(c.toString());
		}
	}
}

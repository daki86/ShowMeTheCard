import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {
	private ArrayList<Card> deck;
	private Random getACardIndex;
	
	public DeckOfCards(){
		deck = new ArrayList<Card>();
		String nameOfSuit = " ";
		
		for(int suit = 1; suit <= 4; suit++){
			for(int value = 1; value <= 13; value++){
				switch (suit){
					case 1:
						nameOfSuit = "Heart";
						break;
					case 2:
						nameOfSuit = "Spade";
						break;
					case 3:
						nameOfSuit = "Club";
						break;
					case 4:
						nameOfSuit = "Dimond";
						break;
				}
				deck.add( new Card(value, nameOfSuit));
			}
		}
	}
	
	public Card dealOneCard(){
		getACardIndex = new Random();
		int cardIndex = getACardIndex.nextInt(deck.size());
		
		Card card = deck.get(cardIndex);
		deck.remove(cardIndex);
		
		return card;
	}
	
	public void returnACardToDeck(Card card){
		deck.add(card);
	}
	
	public void showDeckOfCards(){
		for(int cardIndex = 0; cardIndex < deck.size(); cardIndex++){
			System.out.println(deck.get(cardIndex));
		}
	}
	
	public String toString(){
		return deck.toString();
	}
}


public class Card {
	private int value; 
	private String suit;
	
	Card(int value, String suit){
		this.value = value;
		this.suit = suit;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public void setSuit(String stuit){
		this.suit = suit;
	}
	
	public String getSuit(){
		return this.suit;
	}
	
	public String toString(){
		String card;
		
		switch (this.value){
			case 1:
				card = "Ace of "+this.suit;
				break;
			case 11:
				card = "Jack of "+this.suit;
				break;
			case 12:
				card = "Queen of "+this.suit;
				break;	
			case 13:
				card = "King of "+this.suit;
				break;
			default:
				card = this.value+" of "+this.suit;
		}		
		return card;
	}
}

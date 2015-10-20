
public class ShowMeTheCard extends CardGame {
	
	private Card winningCard;
	
	public boolean checkWinner(Card playerCard){
		boolean rightCard = false;
		
		if(winningCard.getSuit().equals(playerCard.getSuit()) && winningCard.getValue() == playerCard.getValue()){
			rightCard = true;
		}
		
		return rightCard;
	}
	
	public void setWinningCard(int value, String suit){
		this.winningCard = new Card(value, suit);
	}
	
	public Card getWinningCard(){
		return this.winningCard;
	}
	
	 public void helpUser(){
	        System.out.println("\n");
	           
	        //Explain the Game
	        System.out.println("                     Game Rules");
	        
	         System.out.println("          ---------------*-------------");
	         System.out.println(" The game can be played among two to five players.");
	         System.out.println(" The player next to the dealer selects a card( Number");
	         System.out.println(" or Number and Suit ). The dealer then starts dealing the");
	         System.out.println(" cards and to whom the selected card comes first,");                
	         System.out.println(" is the winner. ");
	         System.out.println("          -------------<>---------------");
	             
	       System.out.println("\n");
	}
}

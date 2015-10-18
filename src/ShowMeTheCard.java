
public class ShowMeTheCard extends CardGame {
	
	private Card winningCard;
	
	public boolean checkWinner(Card playerCard){
		boolean rightCard = false;
		
		if(winningCard == playerCard){
			rightCard = true;
		}
		
		return rightCard;
	}
}

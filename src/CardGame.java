import java.util.ArrayList;

public class CardGame {
	private DeckOfCards deck;
	private ArrayList<Player> listOfPlayers;
	
	public CardGame(){
		deck = new DeckOfCards();
		listOfPlayers = new ArrayList<Player>();
	}
	
	public void addAPlayerToTheList( String name ){
		listOfPlayers.add(new Player(name));
	}
	
	public Player getAPlayerFromTheList( int playerIndex ){
		return listOfPlayers.get(playerIndex);
	}
	
	public void removeAPlayerFromTheListByIndex( int playerIndex ){
		listOfPlayers.remove(playerIndex);
	}
	
	public void removeAPlayerFromTheListByName( String playerName ){
		int playerIndex = 0;
		
		for(Player player : listOfPlayers){			
			if(player.getName().equalsIgnoreCase(playerName)){
				listOfPlayers.remove(playerIndex);
				break;
			}
			playerIndex++;
		}
	}
	
	public DeckOfCards getDeckOfCards(){
		return deck;
	}
	
	public int getTotalNumberOfPlayers(){
		return listOfPlayers.size();
	}
	
	public void showListOfPlayers(){
		for(Player player : listOfPlayers){
			System.out.println(player.getName());
		}
	}
	
	public void showDeck(){
		deck.showDeckOfCards();
	}
}

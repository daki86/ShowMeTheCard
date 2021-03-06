import java.util.ArrayList;
import java.util.Scanner;

public class CardGame {
	private DeckOfCards deck;
	private ArrayList<Player> listOfPlayers;
	private Player computer;
	
	public CardGame(){
		deck = new DeckOfCards();
		listOfPlayers = new ArrayList<Player>();
		computer = new Player("Computer");
	}
	
	public void addAPlayerToTheList( String name ){
		listOfPlayers.add(new Player(name));
	}
	
	public Player getAPlayerFromTheListByIndex( int playerIndex ){
		return listOfPlayers.get(playerIndex);
	}
		
	public Player getComputer(){
		return computer;
	}
	
	public int getAPlayerIndexFromTheListByName( String playerName ){		
		int playerIndex = 0;
		
		for(Player player : listOfPlayers){			
			if(player.getName().equalsIgnoreCase(playerName)){
				break;
			}
			playerIndex++;
		}
		return playerIndex;
	}
	
	public boolean CheckIfPlayerIsOnTheList( String playerName ){		
		boolean foundPlayer = false;
		
		for(Player player : listOfPlayers){			
			if(player.getName().equalsIgnoreCase(playerName)){
				foundPlayer = true;
				break;
			}
		}
		return foundPlayer;
	}
	
	public void removeAPlayerFromTheListByIndex( int playerIndex ){
		listOfPlayers.remove(playerIndex);
	}
	
	public boolean removeAPlayerFromTheListByName( String playerName ){
		boolean playerRemoved = false;
		int playerIndex = 0;
		
		for(Player player : listOfPlayers){			
			if(player.getName().equalsIgnoreCase(playerName)){
				listOfPlayers.remove(playerIndex);
				playerRemoved = true;
				break;
			}
			playerIndex++;
		}
		return playerRemoved;
	}
	
	public void removeAllPlayersFromTheList(){
		listOfPlayers.removeAll(listOfPlayers);
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
	
	public void showComputerTotWins(){
		System.out.println("\n"+computer.getName());
		System.out.println("Total wins: "+computer.getTotWins());
	}
	
	public void showListOfPlayersAndWins(){
		for(Player player : listOfPlayers){
			System.out.println("\n"+player.getName());
			System.out.println("Total wins: "+player.getTotWins());
		}
	}
	
	public void showDeck(){
		deck.showDeckOfCards();
	}
	
	public void pressAnyKeyToContinue(){ 
		System.out.println("Press enter to deal next round");
		Scanner keyboard = new Scanner(System.in);
		keyboard.nextLine();
	}
}

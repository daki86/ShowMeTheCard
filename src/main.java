import java.util.Scanner;
import java.util.ArrayList;

public class Main {	
	
	public static void main(String[] args) {	    		
    	
		ShowMeTheCard game = new ShowMeTheCard();
		
    	boolean choice = true;
    	boolean playAgain = true;
    	boolean removed = true;
    	
    	int totNrOfPlayers = 0;
    	String [] nameOfSuits = {"Heart", "Spade", "Club", "Dimond"};
    	//String [] orderOfValues = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    	
    	String name;
    	String input;
    	String temp;
    	
    	int option = 0;
    	int selectedSuit = 0;
    	int pickedValue = 0;
    	int playerThatPicksCard = 0;
    	int dealer = 0;
	    // request for input
	    Scanner scan = new Scanner(System.in);
	    Scanner txt = new Scanner(System.in);
          
             
        //Navigator to make a choice
        do{
            	
        	System.out.println("\n");
            System.out.println("                  <> Show Me The Card <>");
            System.out.println("               _____________*______________");
            	
            System.out.println("");
            System.out.println("(1) Play ");
            System.out.println("(2) Game Rules");
            System.out.println("(3) Show total wins");
            System.out.println("(4) Remove player");
            System.out.println("(5) Exit");
            System.out.print("\ninput: ");
            	
            if(!scan.hasNextInt()){
            	System.out.println("\nThe input must be a number 1 to 5 "); 
                scan.nextLine();     
            }
            else{
            	switch(scan.nextInt()){
                	case 1: 
                		playerThatPicksCard = 0;
                		playAgain = true;
                		if(game.getTotalNumberOfPlayers() == 0){
	                		do{
	                			System.out.print("\nMinimum players needed to play this game is 2 and maximum is 5.");
		                		System.out.print("\nEnter the total amount of players that will participate in the game");
		                		System.out.print("\n\ntotal: ");
		                		
		                		if(scan.hasNextInt()){
		                			totNrOfPlayers = scan.nextInt();
		                			if( totNrOfPlayers > 5 || totNrOfPlayers < 2 ){
			                			System.out.println("\n## Enter a number from 2 to 5 ##");
		                			}
		                		}else if(scan.hasNext()){
		                			temp = scan.next();
		                			System.out.println("\n## Thats not a valid input ##");
		                		}
		                		
	                		}while(totNrOfPlayers > 5 || totNrOfPlayers < 2 );
	                		
	                			System.out.println("\nEnter player's name\n");
		                		for(int i = 1; i <= totNrOfPlayers; i++){
		                			System.out.print("Player "+i+": ");
		                			name = txt.nextLine();
		                			game.addAPlayerToTheList(name);
		                		}
                		}else if(game.getTotalNumberOfPlayers() == 1){
                			do{
	                			System.out.print("\nThere is already one player on the list add atleast 1 to 4 more players to the list");
		                		System.out.print("\nEnter the amount of players you want to add to the existing list");
		                		System.out.print("\n\ntotal: ");
		                		
		                		if(scan.hasNextInt()){
		                			totNrOfPlayers = scan.nextInt();
		                			if( totNrOfPlayers > 4 || totNrOfPlayers < 1 ){
			                			System.out.println("\n## Enter a number from 1 to 4 ##");
		                			}
		                		}else if(scan.hasNext()){
		                			temp = scan.next();
		                			System.out.println("\n## Thats not a valid input ##");
		                		}
		                		
	                		}while(totNrOfPlayers > 4 || totNrOfPlayers < 1 );
                			
                			System.out.println("\nEnter player's name\n");
	                		for(int i = 1; i <= totNrOfPlayers; i++){
	                			System.out.print("Player "+(i+1)+": ");
	                			name = txt.nextLine();
	                			game.addAPlayerToTheList(name);
	                		}
                		}
	                	do{	
	                		if(playerThatPicksCard == game.getTotalNumberOfPlayers()){
	                			playerThatPicksCard = 0;
	                		}
	                		
	                		do{	
		                		System.out.println("\n"+game.getAPlayerFromTheList(playerThatPicksCard).getName()+" choose the card that we will be looking for");
		                		System.out.println("\nPick a value: ");
		                		System.out.println("Enter a number from 1 to 13 (1 = Ace, 11 = Jack, 12 = Queen and 13 = King)");
		                		System.out.print("input: ");
		                		
		                		if(scan.hasNextInt()){
		                			pickedValue = Integer.parseInt(scan.next());
		                			
		                			if(pickedValue < 1 || pickedValue > 13){
			                			System.out.println("\n## Enter a number from 1 to 13 ##");
			                		}
		                		}else if(scan.hasNext()){
		                			temp = scan.next();
		                			System.out.println("\n## Invalid input ##");
		                		}
			                		
		                		
	                		}while( pickedValue < 1 || pickedValue > 13 );
	                		
	                		do{
	                			System.out.print("\nPick a suit: ");
	                		
		                		for(int i = 0; i < 4; i++){
		                			if(i == 3){
		                				System.out.print(nameOfSuits[i]);
		                			}else
		                			System.out.print(nameOfSuits[i]+", ");
		                		}
		                		
		                		System.out.println("\nEnter a number from 1 to 4\n");
		                		System.out.print("input: ");
		                		
		                		if(scan.hasNextInt()){
		                			selectedSuit = Integer.parseInt(scan.next());
		                			
		                			if( selectedSuit < 1 || selectedSuit > 4 ){
		                				System.out.println("\n## Enter a number from 1 to 4 ##");
		                			}
		                		}else if(scan.hasNext()){
	                				temp = scan.next();
	                				System.out.println("\n## Invalid input ##");
	                			}
	                		}while( selectedSuit < 1 || selectedSuit > 4);	
	                		
	                		String pickedSuit = nameOfSuits[selectedSuit-1];
	                		
	                		game.setWinningCard(pickedValue, pickedSuit);
	                		
	                		int index = 0;
	                		int round = 0;
	                		boolean foundAWinner = false;
	                		
	                		do{
	                			if(index == game.getTotalNumberOfPlayers() || index == 0){
	                				index = 0;
	                				round++;
	                				if(playerThatPicksCard-1 < 0){
	                					dealer = game.getTotalNumberOfPlayers()-1;
	                				}else{
	                					dealer = playerThatPicksCard-1;
	                				}
	                				
	                				System.out.println("\n#######################################################");
	                				System.out.println("DEALER: "+game.getAPlayerFromTheList(dealer).getName());
	                				System.out.println("Card we are looking for: "+game.getWinningCard().toString());
	                				System.out.println("Round: "+round);
	                				System.out.println("#######################################################");
	                				game.pressAnyKeyToContinue();
	                			}
	                			System.out.println("\n"+game.getAPlayerFromTheList(index).getName()+" got:");
	                			game.getAPlayerFromTheList(index).addCardToHand(game.getDeckOfCards().dealOneCard());
	                			System.out.println("----------------");
	                			System.out.println(game.getAPlayerFromTheList(index).getACardFromHand(round-1).toString());
	                			System.out.println("----------------");
	                			
	                			for(int i = 0; i < game.getAPlayerFromTheList(index).getTotalCardsFromHand(); i++){
	                				if(game.checkWinner(game.getAPlayerFromTheList(index).getACardFromHand(i)) == true ){
	                					foundAWinner = true;
	                					System.out.println("\n####################");
	                					System.out.println("WINNER: "+game.getAPlayerFromTheList(index).getName());
	                					System.out.println("####################");
	                					game.getAPlayerFromTheList(index).addAWin();
	                				}
	                			}
	                			
	                			index++;
	                		}while(!foundAWinner);
	                		
	                		for(int i = 0; i < game.getTotalNumberOfPlayers(); i++){
	                			game.getAPlayerFromTheList(i).returnCardsToDeck(game.getDeckOfCards());
	                		}
	                		
	                		do{
		                		System.out.println("\nDo you want to play again?");
		                		System.out.println("yes/no");
		                		input = scan.next();
		                		if(input.equalsIgnoreCase("no")){
		                			playAgain = false;
		                		}else if( !input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no") ){
		                			System.out.println("\n## Invalid input ##");
		                		}
	                		}while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
	                		
	                		playerThatPicksCard++;
	                		
            			}while(playAgain);
	                	
                    	break;
                    case 2:  
                    	game.helpUser();
                    	break;
                    case 3:  
                    	if(game.getTotalNumberOfPlayers() != 0){
                    		System.out.println("\nPlayers total wins");
                    		System.out.println("#########################");
                    		game.showListOfPlayersAndWins();
                    		System.out.println("\n#########################");
                    	}else{
                    		System.out.println("\n## Ther are no players registered ##");
                    	}
                    	break;
                    case 4:
                    	if(game.getTotalNumberOfPlayers() != 0){
                    		do{
                    			System.out.println("\n(1) Remove a player from the list");
                    			System.out.println("(2) Remove all players from the list");
                    			System.out.print("\ninput: ");
                    			
                    			if(scan.hasNextInt()){
                    				option = Integer.parseInt(scan.next());
                    				if(option != 1 && option != 2){
                    					System.out.println("\n## Enter value 1 or 2 ##");
                    				}
                    			}else if(scan.hasNext()){
                    				temp = scan.next(); 
                    				System.out.println("\n## Invalid input! ##");
                    			}
                    			
                    		}while(option != 1 && option != 2);
                    		
                    		if(option == 1){
	                    		do{	
	                    			System.out.println("\nRemove a player from the list");
	                    			System.out.println("##############################");
	                    			game.showListOfPlayers();
	                    			System.out.println("##############################");
	                    			System.out.println("Enter the name of player you want to remove");
	                    			System.out.print("\nName: ");
	                    			name = scan.next();
	                    		
	                    			removed = game.removeAPlayerFromTheListByName(name);
	                    			if(removed){
	                    				System.out.println("\nPlayer: "+name+" was removed from the list");
	                    			}else{
	                    				System.out.println("\n## There is no player with the name "+name+" try again ##");
	                    			}
	                    		}while(!removed);		
                    		}else if(option == 2){
                    			game.removeAllPlayersFromTheList();
                    			System.out.println("\n## All players where removed from the list ##");
                    		}
                    		
                    	}else{
                    		System.out.println("\n## Ther are no players registered ##");
                    	}
                    	break;
                    case 5:
                    	choice = false;
                        System.out.println("\nBye!");
                        System.exit(0);
                        break;             
                    default:
                    	System.out.println("\n## You entered a wrong choice, "
                                          + "the input must be a number from 1 to 5 ##");
                        break;       
                    }
                }     
            }while(choice);
        scan.close();
    }
}

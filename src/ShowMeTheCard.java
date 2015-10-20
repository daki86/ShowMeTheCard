import java.util.Scanner;

public class ShowMeTheCard extends CardGame {
	
	private Card winningCard;
	
	
	public void playShowMeTheCards(int option){
		
		String [] nameOfSuits = {"Heart", "Spade", "Club", "Dimond"};
		
		int playerThatPicksCard = 0;
		int totNrOfPlayers = 0;
		int dealer = 0;
		int selectedSuit = 0;
    	int pickedValue = 0;
		
		String temp;
		String name;
		String input;
		
		boolean playAgain = true;
		Scanner scan = new Scanner(System.in);
		Scanner txt = new Scanner(System.in);
		
		if(option == 1){
			if(super.getTotalNumberOfPlayers() == 0){
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
	        			super.addAPlayerToTheList(name);
	        		}
			}else if(super.getTotalNumberOfPlayers() == 1){
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
	    			super.addAPlayerToTheList(name);
	    		}
			}
		}else if(option == 2){
			if(super.getTotalNumberOfPlayers() == 0){
				System.out.print("\nEnter your name: ");
				name = scan.next();
				super.addAPlayerToTheList(name);
			}else if(super.getTotalNumberOfPlayers() > 1){
				do{
					System.out.println("\nList of players");
					System.out.println("#########################");
					super.showListOfPlayers();
					System.out.println("#########################");
					System.out.print("\nEnter the name of the player that is playing vs a computer: ");
					
					name = scan.next();
					if(super.CheckIfPlayerIsOnTheList(name)){
						playerThatPicksCard = super.getAPlayerIndexFromTheListByName(name);
					}
				}while(!super.CheckIfPlayerIsOnTheList(name));
			}
		}
		
    	do{	
    		if(option == 1){
	    		if(playerThatPicksCard == super.getTotalNumberOfPlayers()){
	    			playerThatPicksCard = 0;
	    		}
    		}
    		
    		do{	
        		System.out.println("\n"+super.getAPlayerFromTheListByIndex(playerThatPicksCard).getName()+" choose the card that we will be looking for");
        		System.out.println("\nPick a value ");
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
    			System.out.print("\nPick a suit \n");
    		
        		for(int i = 0; i < 4; i++){
        			System.out.println((i+1)+": "+nameOfSuits[i]);
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
    		
    		setWinningCard(pickedValue, pickedSuit);
    		
    		int index = 0;
    		int round = 0;
    		boolean foundAWinner = false;
    		
    		do{
    			if( option == 1 ){
	    			if(index == super.getTotalNumberOfPlayers() || index == 0){
	    				index = 0;
	    				round++;
	    				if(playerThatPicksCard-1 < 0){
	    					dealer = super.getTotalNumberOfPlayers()-1;
	    				}else{
	    					dealer = playerThatPicksCard-1;
	    				}
	    				
	    				System.out.println("\n#######################################################");
	    				System.out.println("DEALER: "+super.getAPlayerFromTheListByIndex(dealer).getName());
	    				System.out.println("Card we are looking for: "+getWinningCard().toString());
	    				System.out.println("Round: "+round);
	    				System.out.println("#######################################################");
	    				super.pressAnyKeyToContinue();
	    			}
	    			System.out.println("\n"+super.getAPlayerFromTheListByIndex(index).getName()+" got:");
	    			super.getAPlayerFromTheListByIndex(index).addCardToHand(super.getDeckOfCards().dealOneCard());
	    			System.out.println("----------------");
	    			System.out.println(super.getAPlayerFromTheListByIndex(index).getACardFromHand(round-1).toString());
	    			System.out.println("----------------");
    			
	    			if(checkWinner(super.getAPlayerFromTheListByIndex(index).getACardFromHand(round-1)) == true ){
	    				foundAWinner = true;
	    				System.out.println("\n####################");
	    				System.out.println("WINNER: "+super.getAPlayerFromTheListByIndex(index).getName());
	    				System.out.println("####################");
	    				super.getAPlayerFromTheListByIndex(index).addAWin();
	    			}
	    			
	    			index++;
	    			
    			}else if( option == 2 ){
    				round++;
    				System.out.println("\n#######################################################");
    				System.out.println("DEALER: "+super.getComputer().getName());
    				System.out.println("Card we are looking for: "+getWinningCard().toString());
    				System.out.println("Round: "+round);
    				System.out.println("#######################################################");
    				super.pressAnyKeyToContinue();
    				
    				System.out.println("\n"+super.getAPlayerFromTheListByIndex(playerThatPicksCard).getName()+" got:");
	    			super.getAPlayerFromTheListByIndex(playerThatPicksCard).addCardToHand(super.getDeckOfCards().dealOneCard());
	    			System.out.println("----------------");
	    			System.out.println(super.getAPlayerFromTheListByIndex(playerThatPicksCard).getACardFromHand(round-1).toString());
	    			System.out.println("----------------");
	    			
	    			if(checkWinner(super.getAPlayerFromTheListByIndex(playerThatPicksCard).getACardFromHand(round-1)) == true ){
	    				foundAWinner = true;
	    				System.out.println("\n####################");
	    				System.out.println("WINNER: "+super.getAPlayerFromTheListByIndex(playerThatPicksCard).getName());
	    				System.out.println("####################");
	    				super.getAPlayerFromTheListByIndex(index).addAWin();
	    			}
	    			
	    			if(!foundAWinner){
		    			System.out.println("\n"+super.getComputer().getName()+" got:");
			    		super.getComputer().addCardToHand(super.getDeckOfCards().dealOneCard());
			    		System.out.println("----------------");
			    		System.out.println(super.getComputer().getACardFromHand(round-1).toString());
			    		System.out.println("----------------");
			    			
			    		if(checkWinner(super.getComputer().getACardFromHand(round-1)) == true ){
			    			foundAWinner = true;
			    			System.out.println("\n####################");
			    			System.out.println("WINNER: "+super.getComputer().getName());
			    			System.out.println("####################");
			    			super.getComputer().addAWin();
			    		}
	    			}
	    		}
    			
    		}while(!foundAWinner);
    		
    		for(int i = 0; i < super.getTotalNumberOfPlayers(); i++){
    			super.getAPlayerFromTheListByIndex(i).returnCardsToDeck(super.getDeckOfCards());
    		}
    		
    		if(option == 2)
    			super.getComputer().returnCardsToDeck(super.getDeckOfCards());
    		
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
    		
    		if( option == 1 ){
    			playerThatPicksCard++;
    		}
    		
		}while(playAgain);
		
	}
	
	
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
	         System.out.println(" The player next to the dealer selects a card");
	         System.out.println(" The dealer then starts dealing the cards and to");
	         System.out.println(" whom the selected card comes first, is the winner.");                
	         System.out.println("          -------------<>---------------");
	             
	       System.out.println("\n");
	}
}

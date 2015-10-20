import java.util.Scanner;
import java.util.ArrayList;

public class Main {	
	
	public static void main(String[] args) {	    		
    	
		ShowMeTheCard game = new ShowMeTheCard();
		
    	boolean choice = true;
    	boolean removed = true;
    	
    	String name;
    	String temp;
    	
    	int option = 0;

	    Scanner scan = new Scanner(System.in);          
             
        //Navigator to make a choice
        do{
            	
        	System.out.println("\n");
            System.out.println("                  <> Show Me The Card <>");
            System.out.println("               _____________*______________");
            	
            System.out.println("");
            System.out.println("(1) Play");
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
                		do{
                			System.out.println("\n(1) Play vs Players");
                			System.out.println("(2) Play vs Computer");
                			System.out.println("(3) Back");
                			System.out.print("\ninput: ");
                			
                			if(scan.hasNextInt()){
                				option = Integer.parseInt(scan.next());
                				if(option < 1 || option > 3){
                					System.out.println("\n## Enter a value from 1 to 3 ##");
                				}else
                					choice = true;
                			}else if(scan.hasNext()){
                				temp = scan.next(); 
                				System.out.println("\n## Invalid input ##");
                				choice = false;
                			}
                			
                		}while(!choice);
                		
                		if(option == 1 || option == 2){	
                			game.playShowMeTheCards(option);
                		}
                		
                			
                    	break;
                    case 2:  
                    	game.helpUser();
                    	break;
                    case 3:  
                    	if(game.getTotalNumberOfPlayers() != 0){
                    		System.out.println("\nPlayers total wins");
                    		System.out.println("#########################");
                    		game.showListOfPlayersAndWins();
                    		game.showComputerTotWins();
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
                    			System.out.println("(3) Back");
                    			System.out.print("\ninput: ");
                    			
                    			if(scan.hasNextInt()){
                    				option = Integer.parseInt(scan.next());
                    				if(option < 1 || option > 3){
                    					System.out.println("\n## Enter a value from 1 to 3 ##");
                    				}else
                    					choice = true;
                    			}else if(scan.hasNext()){
                    				temp = scan.next(); 
                    				System.out.println("\n## Invalid input ##");
                    				choice = false;
                    			}
                    			
                    		}while(!choice);
                    		
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

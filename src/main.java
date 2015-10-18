import java.util.Scanner;

public class Main {

	public static void main(String[] args) {	    
		
		menu(); 
	  
	}

	// This is the Main Navigator
    public static void menu(){
	    
    	boolean choice=true;
	    // request for input
	    Scanner scan=new Scanner(System.in);  
          
             
        //Navigator to make a choice
        do{
            	
        	System.out.println("\n");
            System.out.println("                  <> Show Me The Card <>");
            System.out.println("               _____________*______________");
            	
            System.out.println("");
            System.out.println("(1) Play ");
            System.out.println("(2) Game Rules");
            System.out.println("(3) Options");
            System.out.println("(4) Exit");
            System.out.print("\nenter: ");
            	
            if(!scan.hasNextInt()){
            	System.err.println("The input must be a number 1 to 4 "); 
                scan.nextLine();     
            }
            else{
            	switch(scan.nextInt()){
                	case 1: 
                		System.out.println("\nThis is Method for Play");
                    	break;
                    case 2:  
                    	helpUser();
                    	break;
                    case 3:  
                    	System.out.println("\nThis is Method for Options");
                    	break;
                    case 4:
                    	choice = false;
                        System.err.println("\n    Bye!");
                        break;             
                    default:
                    	System.err.println("\nYou entered a wrong choice ,"
                                          + "the input must be numbers 1 to 4");
                        break;       
                    }
                }     
            }while(choice);
    }
    
    // a help  method  for the rules of the game   
    public static void helpUser(){
        System.out.println("\n");
           
           //Explain the Game
        System.out.println("                     Game Rules");
        
         System.out.println("          ---------------*-------------");
         System.out.println(" The game can be played among two to four players.");
         System.out.println(" The player next to the dealer select a card(Number,");
         System.out.println(" Colour or even suit). The dealer then start sharing the");
         System.out.println(" cards and to whom the selected card comes first,");                
         System.out.println(" is the winner. ");
         System.out.println("          -------------<>---------------");
             
       System.out.println("\n");
    }

}

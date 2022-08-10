package gamedevsuno;

import java.util.Scanner;

public class CardDesignPrinciples {
    static Scanner input = new Scanner(System.in);
    static Card[] MainDeck = new Card[112];
    static Card[] TableDeck = new Card[112];
    static Card[] PlayerDeck = {};
    static Card[] ComputerDeck = {};
    static Card GameSystem = new Card();
    static String DeckStyle = "Half";
        
    public static void drawCard(int amt, Card[] deck)
    {
        for (int count = 0; count < amt; count++){
            Card rdm = GameSystem.RandomCard();
            
            for (Card check:MainDeck) {
                if (check == rdm) {
                    deck[count] = check;
                    System.out.println(rdm.getColor()+" "+rdm.getValue()+" Added to deck.");
                }
            }
        }
        
        System.out.println("Number of cards in current deck: "+MainDeck.length);
        System.out.println("Number of cards in main deck: "+deck.length);
    }
    
    public static void displayDeck()
    {
        int count = 0;
        for (Card card:PlayerDeck) {
            System.out.println((count+1)+" "+PlayerDeck[count]);
            count++;
        }
    }
    
    public static void main(String[] args) 
    {
        System.out.println("Welcome to GameDevs Uno! \nWould you like to play: \n1.Half deck \n2.Full deck");
        int deckchoice = input.nextInt();
        switch (deckchoice){
            case 1:
              System.out.println("Half deck selected! Generating 56 cards...");  
              DeckStyle = "Half";
              GameSystem.CreateDeck(MainDeck);
              break;
            case 2:
              System.out.println("Full deck selected! Generating 112 cards...");  
              DeckStyle = "Full";
              GameSystem.CreateDeck(MainDeck);
              GameSystem.CreateDeck(MainDeck);
              break;
            default:
              System.out.println("Not a valid option.");
              break;
        }
        
        System.out.println("Allocating cards to Player deck...");
        drawCard(7, PlayerDeck);
        
        System.out.println("Allocating cards to Computer deck...");
        drawCard(7, ComputerDeck);
        
        System.out.println("You go first! \nWhat card will you play?");
        displayDeck();
        
        
    }
}

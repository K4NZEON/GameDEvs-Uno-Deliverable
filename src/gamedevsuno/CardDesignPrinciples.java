package gamedevsuno;

import java.util.ArrayList;
import java.util.Scanner;

public class CardDesignPrinciples {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Card> MainDeck = new ArrayList<>();
    static ArrayList<Card> ReshuffleDeck = new ArrayList<>();
    static ArrayList<Card> TableDeck = new ArrayList<>();
    static ArrayList<Card> PlayerDeck = new ArrayList<>();
    static ArrayList<Card> ComputerDeck = new ArrayList<>();
    static Card FaceCard = new Card();
    static String DeckStyle = "Half";
    
    public static void CreateDeck(ArrayList<Card> deck){
        int count = 0;
        for(Card.Color c:Card.Color.values() ) //c = red
        {
            for(Card.Value v : Card.Value.values()) // v = one
            {
                deck.add(new Card(c,v));
                count++;
            }
        }
    }
        
    public static void drawCard(int amt, ArrayList<Card> deck)
    {
        for (int count = 0; count < amt; count++){
            Card rdm = new Card();
            boolean check = false;
            Card plc = new Card();
                    
            for (Card checkedcard: MainDeck) {
                if (checkedcard.getColor() == rdm.getColor() && checkedcard.getColor() == rdm.getColor()){
                    check = true;
                    if (check){
                        deck.add(checkedcard);
                        plc = checkedcard;
                        System.out.println(rdm.getColor()+" "+rdm.getValue()+" Drawn from main deck.");
                    }else{
                        System.out.println("Card not in main deck, \nretrying.");
                        count--;
                    }
                    break;
                }
            }
            if (check){
                MainDeck.remove(plc);
            }
        }
        
        System.out.println("\nNumber of cards in main deck: "+MainDeck.size());
        System.out.println("Number of cards in current deck: "+deck.size());
    }
    
    public static void displayDeck()
    {
        int count = 0;
        for (Card card:PlayerDeck) {
            System.out.println((count+1)+". "+card.getColor()+" "+card.getValue());
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
              CreateDeck(MainDeck);
              break;
            case 2:
              System.out.println("Full deck selected! Generating 112 cards...");  
              DeckStyle = "Full";
              CreateDeck(MainDeck);
              CreateDeck(MainDeck);
              break;
            default:
              System.out.println("Not a valid option.");
              break;
        }
        
        System.out.println("\nAllocating cards to Player deck...");
        drawCard(7, PlayerDeck);
        
        System.out.println("\nAllocating cards to Computer deck...");
        drawCard(7, ComputerDeck);
        
        GameOngoing:
        while (true){
            System.out.println("\nCurrent Face Card is: "+FaceCard.getColor()+" "+FaceCard.getValue()+"\n");
            int CardChoice = 0;
            displayDeck();
            System.out.println(String.valueOf(PlayerDeck.size() + 1 ) + ". " + "Draw card");
            System.out.println(String.valueOf((PlayerDeck.size() + 2)) + ". " + "Quit");
            
            do{
                System.out.println("\nWhat card will you play?");
            } while (!input.hasNextInt());

            CardChoice = input.nextInt() - 1;

            if (CardChoice == PlayerDeck.size() )
                drawCard(1, PlayerDeck);
            else if (CardChoice == PlayerDeck.size() + 1)
                break GameOngoing;
            else if (((Card)PlayerDeck.get(CardChoice)).validCard(FaceCard, PlayerDeck.get(CardChoice)) )
            {
                FaceCard = (Card)PlayerDeck.get(CardChoice);
                PlayerDeck.remove(CardChoice);
            } else System.out.println("Card doesn't have right color or action, Follow the rules!");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedevsuno;

import java.util.ArrayList;
import java.util.Random;

/**
 * card generation is delegated here 
 * "seperation of concerns"
 * @author srinivsi
 */
public class GenerateCard 
{
   // There are current 112 cards 
    private Card[] cards;
    private int cardDeck;
    private int size = 112;
    
    public GenerateCard (){
        cards = new Card[size];
    }
    
      
    public void reset(){
        Card.Color[] colors = Card.Color.values();
        cardDeck = 0;
        
        for(int i = 0; i < colors.length-1; i++)
        {
            Card.Color color = colors[i];
            
            cards[cardDeck++] = new Card(color, Card.Value.getValue(0));
            
            for(int j = i; j<10; j++)
            {
                cards[cardDeck++] = new Card(color, Card.Value.getValue(j));
                cards[cardDeck++] = new Card(color, Card.Value.getValue(j));
            }
            
            Card.Value[] values = new Card.Value[]{ Card.Value.PLUSTWO, Card.Value.SKIP, Card.Value.REVERSE}; 
                for(Card.Value value : values){
                    cards[cardDeck++] = new Card(color, value);
                    cards[cardDeck++] = new Card(color, value);
                }    
        }
        Card.Value[] values = new Card.Value[]{Card.Value.WILDCARD, Card.Value.PLUSFOUR};
        for (Card.Value value : values)
        {
            for(int i = 0; i < 4; i++)
            {
                cards[cardDeck++] = new Card(Card.Color.WILD, value);
            }
        }
    }
    
    public void changeDeckWith(ArrayList<Card> cards){
        this.cards = cards.toArray(new Card[cards.size()]);
        this.cardDeck = this.cards.length;
    }
    
    public boolean isEmpty(){
        return cardDeck == 0;
    }
    
    public void shuffle(){
        int n = cards.length;
        Random random = new Random();
        for (int i= 0; i < cards.length; i++) {
            int randomValue = i + random.nextInt(n - i );
            Card randomCard = cards[randomValue];
            cards[randomValue] = cards[i];
            cards[i] = randomCard;       
        }
    }
    
    public Card drawCard() throws IllegalArgumentException {
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot draw a card since there are no cards in the deck");
        }
        return cards[--cardDeck];
    }
    
    public Card[] drawCard (int n){
        if (n <0){
         throw new IllegalArgumentException("Just draw positive cards but tried to draw" + n + "cards.");
        }
        
        if (n > cardDeck){
            throw new IllegalArgumentException("Cannot draw " + n + " cards since there are only " + cardDeck + " cards.");
        }
        
        Card[] ret = new Card[n];
        
        for (int i = 0; i< n; i++){
            ret[i] = cards[--cardDeck];
        }
        return ret;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedevsuno;

/** enum , value safety and data type safety
 *
 * @author srinivsi
 */
public class Card
{
    public enum Suit { HEARTS,SPADES,CLUBS,DIAMONDS } ;
    public enum Value {ACE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING, JOKER}; 
    private Value value;
    private Suit suit;
    
    public Card(Suit s,Value v)
    {
        this.suit=s;
        this.value=v;
    }

    /**
     * @return the value
     */
    public Value getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Value value) {
        this.value = value;
    }

    /**
     * @return the suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * @param suit the suit to set
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }
}

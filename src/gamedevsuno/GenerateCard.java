/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedevsuno;

/**
 * card generation is delegated here 
 * "seperation of concerns"
 * @author srinivsi
 */
public class GenerateCard 
{
   // 52 cards 
    private int size = 60;
    Card[] deck = new Card[size];
    public void generate()
    {
       int count = 0;
        for( Card.Suit s:Card.Suit.values() ) //s= hearts
        {
            for( Card.Value v : Card.Value.values()) //ACE
            {
                deck[count]= new Card(s,v);
                count++;
            }
        }
    }
}

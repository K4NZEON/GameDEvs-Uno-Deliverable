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
public class GenerateCard extends Card
{
   // 112 cards 
    private int size = 112;
    Card[] deck = new Card[size];
    
    public GenerateCard(Color c,Value v)
    {
        this.color=c;
        this.value=v;
    }
    
    public GenerateCard()
    {
        
    }
    
    public void generate()
    {
       int count = 0;
        for( Card.Color c:Card.Color.values() ) //c = red
        {
            for( Card.Value v : Card.Value.values()) // v = one
            {
                deck[count]= new Card(c,v);
                count++;
            }
        }
    }
}

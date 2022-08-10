/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedevsuno;

import gamedevsuno.Card.Color;
import gamedevsuno.Card.Value;

public abstract class GenerateCard
{

   Card.Value value;
   Card.Color color;
   
   public void CreateDeck(Card[] deck){
        int count = 0;
        for(Card.Color c:Card.Color.values() ) //c = red
        {
            for(Card.Value v : Card.Value.values()) // v = one
            {
                deck[count]= new Card(c,v);
                count++;
            }
        }
    }
   
   public Card RandomCard(){
       int rdmValue = (0) + (int)(Math.random()* (14 - 0 + 1));
        
        switch(rdmValue)
        {
            case 0: 
                this.value = Value.ONE; 
                break;
            case 1:
                this.value = Value.TWO; 
                break;
            case 2:
                this.value = Value.THREE; 
                break;
            case 3:
                this.value = Value.FOUR; 
                break;
            case 4: 
                this.value = Value.FIVE; 
                break;
            case 5:
                this.value = Value.SIX; 
                break;
            case 6:
                this.value = Value.SEVEN; 
                break;
            case 7:
                this.value = Value.EIGHT; 
                break;
            case 8:
                this.value = Value.NINE; 
                break;
            case 9:
                this.value = Value.WILDCARD; 
                break;
            case 10:
                this.value = Value.SKIP; 
                break;
            case 11:
                this.value = Value.REVERSE; 
                break;
            case 12:
                this.value = Value.PLUSTWO; 
                break;
            case 13:
                this.value = Value.PLUSFOUR; 
                break;
        }
        
        int rdmColor = (0) + (int)(Math.random()* (4 - 0 + 1));
        
        switch(rdmColor)
        {
            case 0: 
                this.color = Color.RED; 
                break;
            case 1:
                this.color = Color.GREEN; 
                break;
            case 2:
                this.color = Color.BLUE; 
                break;
            case 3:
                this.color = Color.YELLOW; 
                break;
        }
        
        return new Card(this.color,this.value);
   }
}

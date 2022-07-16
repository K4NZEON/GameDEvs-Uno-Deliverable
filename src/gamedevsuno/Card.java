/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedevsuno;

/** enum , value safety and data type safety
 *
 * @author evansk
 */
public class Card
{
    public enum Color {RED, GREEN, BLUE, YELLOW} ;
    public enum Value {ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, WILDCARD, SKIP, REVERSE, PLUSTWO, PLUSFOUR}; 
    public Value value;
    public Color color;
    
    public Card(Color c,Value v)
    {
        this.color=c;
        this.value=v;
    }
    
    public Card(){
        
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
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
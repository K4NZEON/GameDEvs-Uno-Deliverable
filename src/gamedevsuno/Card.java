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
public class Card{

      public enum Color {RED, GREEN, BLUE, YELLOW, WILD;
    
        private static final Color [] colors = Color.values();
         
        public static Color getColor(int i){
            return Color.colors[i];
            
            }
    } 
    public enum Value {ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, WILDCARD, SKIP, REVERSE, PLUSTWO, PLUSFOUR;
        
        private static final Value[] values = Value.values();
        
        public static Value getValue(int i){
            return Value.values[i];
        }
        
    }
    
    private final Color color; // to never change the  color 
    private final Value value; // to never change the  value
   
    
    public Card(Color color, Value value){
        this.color = color;
        this.value = value;
    }

    /**
     * @return the value
     */
    public Value getValue() {
        return this.value;
    }


    /**
     * @return the color
     */
    public Color getColor() {
             return this.color;
    }

  
    public String toString() // it is usefull for testing
    {
        return color + "_" + value;
    }
}

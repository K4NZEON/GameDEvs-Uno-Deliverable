package gamedevsuno;

public class Card extends GenerateCard
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
    
    public Card()
    {
        int rdmValue = (0) + (int)(Math.random()* (13 - 0 + 1));
        
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
        
        int rdmColor = (0) + (int)(Math.random()* (3 - 0 + 1));
        
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
    }
    
    public boolean validCard(Card FaceCard, Card PlayCard)
    {
        if (PlayCard.getColor() == FaceCard.getColor())
            return true;
        else if (PlayCard.getValue() == FaceCard.getValue())
            return true;
        return false;
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

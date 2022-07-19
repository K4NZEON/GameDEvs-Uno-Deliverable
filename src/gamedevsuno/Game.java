/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamedevsuno;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author lilia
 */
public class Game {
    private int currPlayer;
    private String [] playersIds;
    
    private GenerateCard deck;
    private ArrayList<ArrayList<Card>> playerHand;
    private ArrayList<Card> AccumCard;
    
    private Card.Color validColor;
    private Card.Value validValue;
    
    boolean gameDir;
    
    public Game(String[] pids){
        deck = new GenerateCard();
        deck.shuffle();
        AccumCard = new ArrayList<Card>();
        
        playersIds = pids;
        currPlayer = 0;
        gameDir = false;
        
        playerHand = new ArrayList<ArrayList<Card>>();
        
        for (int i = 0; i < pids.length; i++){
            ArrayList<Card> hand = new ArrayList<Card>(Arrays.asList(deck.drawCard(7)));
            playerHand.add(hand);
        }
    }
    /**
     *
     * @param game
     */
    public void start(Game game){
            Card card = deck.drawCard();
            validColor = card.getColor();
            validValue = card.getValue();
            
            if (card.getValue() == Card.Value.WILDCARD){
                start(game);
            }
            
            if (card.getValue() == Card.Value.PLUSFOUR || card.getValue() == Card.Value.PLUSTWO){
                 start(game);
            }
            
            if (card.getValue() == Card.Value.SKIP ){
                JLabel message = new JLabel(playersIds[currPlayer] + " was skipped!");
                message.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message);
                
                if(gameDir ==false){
                    currPlayer = (currPlayer + 1 ) % playersIds.length;
                }
                else if(gameDir == true){
                    currPlayer = (currPlayer- 1 ) % playersIds.length;
                }
                
                else if(gameDir== true){
                    currPlayer = (currPlayer - 1) % playersIds.length;
                    if (currPlayer == -1) {
                        currPlayer = playersIds.length - 1;
                    }
                }
            }
            
            if (card.getValue() == Card.Value.REVERSE){
                JLabel message = new JLabel(playersIds[currPlayer] + " was skipped!");
                message.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message);
                gameDir = true;
                currPlayer =  playersIds.length - 1;
            }
            
            AccumCard.add(card);
        }
    
    public Card getTopCard(){
        return new Card(validColor,validValue);
    }
    
    public boolean isGameOver(){
        for (String player : this.playersIds){
            if (hasEmptyHand(player)){
                return true;
            }     
        }
        return false;
    }

    public String getCurrentPlayer(){
        return this.playersIds[this.currPlayer];
    }

    public String getPreviousPlayers(int i){
        int index = this.currPlayer - i;
            if (index == - 10){
                index = playersIds.length - 1;
            }
        return playersIds[index];
    }
    
    public String [] getPleyers() {
        return playersIds;
    }
    
    public ArrayList<Card> getPlayerHand(String pid){
        int index = Arrays.asList(playersIds).indexOf(pid);
        return playerHand.get(index);
    }
    
    public int getPlayerHandSize(String pid) {
        return getPlayerHand(pid).size();
    }
    
    public Card getPlayerCard(String pid, int choice){
        ArrayList<Card> hand = getPlayerHand(pid);
        return hand.get(choice);
    }
    public boolean hasEmptyHand(String pid){
        return getPlayerHand(pid).isEmpty();
    }
    
    public boolean validCardPlay(Card card){
        return card.getColor() == validColor || card.getValue() == validValue;
    }
    
    public void checkPlayerTurn(String pid) throws InvalidPlayerTurnException{
            
        if(this.playersIds[this.currPlayer] != pid){
            throw new  InvalidPlayerTurnException("It is not " + pid + " 's turn",pid);
        }
    }
    
    public void subbitDrasw(String pid) throws InvalidPlayerTurnException{
        checkPlayerTurn(pid);
        
        if(deck.isEmpty()){
            deck.changeDeckWith(AccumCard);
            deck.shuffle();
        }
        
        getPlayerHand(pid).add(deck.drawCard());
        if (gameDir == false){
            currPlayer = (currPlayer + 1) % playersIds.length;
        }
        
        else if(gameDir ==true){
            currPlayer = (currPlayer - 1 )% playersIds.length;
            if (currPlayer == -1) {
                currPlayer = playersIds.length -1;
            }
        }
    }
    
    public void setCardColor(Card.Color color){
        validColor = color;
    }
    
    public void submitPlayerCard(String pid, Card card, Card.Color declaredColor)
            throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidPlayerTurnException {
        checkPlayerTurn(pid);
        
        ArrayList<Card> pHand = getPlayerHand(pid);
        
        if (!validCardPlay(card)){
            if (card.getColor() == Card.Color.WILD){
                validColor = card.getColor();
                validValue = card.getValue();
            }
            
            if (card.getColor() != validColor){
                JLabel message = new JLabel("Invalid move, Expected Color: " + validColor + " bur got color " + card.getColor());
                message.setFont(new Font ("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message);
           
            }
            
            else if (card.getValue() != validValue){
                JLabel message2= new JLabel("Invalid move, Expected Value: " + validValue + " bur got color " + card.getValue());
                message2.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message2);
                
            }
            
        }
        pHand.remove(card);
        
        if (hasEmptyHand(this.playersIds[currPlayer])){
            JLabel message2 = new JLabel(this.playersIds[currPlayer] + " won the game! Congratulations!");
                message2.setFont(new Font ("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message2);
                System.exit(0);
        }
        
        validColor = card.getColor();
        validValue = card.getValue();
        AccumCard.add(card);
        
        if (gameDir == false){
            currPlayer = (currPlayer + 1) % playersIds.length;
        }
        else if(gameDir == true){
                currPlayer = (currPlayer - 1) % playersIds.length;
                if (currPlayer == -1 ){
                    currPlayer = playersIds.length -1;
                }
            }
        
        if (card.getColor() == Card.Color.WILD){
            validColor = declaredColor;
        }
        
        if (card.getValue() == Card.Value.PLUSTWO){
             pid = playersIds[currPlayer];
            getPlayerHand(pid).add(deck.drawCard());
            getPlayerHand(pid).add(deck.drawCard());
            JLabel message = new JLabel(pid + " drew 2 cards!");
        }
        
        if (card.getValue() == Card.Value.PLUSFOUR){
             pid = playersIds[currPlayer];
            getPlayerHand(pid).add(deck.drawCard());
            getPlayerHand(pid).add(deck.drawCard());
            getPlayerHand(pid).add(deck.drawCard());
            getPlayerHand(pid).add(deck.drawCard());
            JLabel message = new JLabel(pid + " drew 4 cards!");
        }
        
        if (card.getValue() == Card.Value.SKIP){
            JLabel message = new JLabel (playersIds[currPlayer] + " was Skipped!");
            message.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);
            if (gameDir == false){
                currPlayer = (currPlayer + 1) % playersIds.length;
            }
            
            else if(gameDir == true){
                currPlayer = (currPlayer -1) % playersIds.length;
                if(currPlayer == -1){
                    currPlayer = playersIds.length - 1;
                }
            }   
        }
        
                if (card.getValue() == Card.Value.REVERSE){
                JLabel message = new JLabel (pid + " changed the game direction!");
                message.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null,message);
                
                gameDir= true;
                if (gameDir == true){
                    currPlayer = (currPlayer - 2 ) % playersIds.length;
                    if (currPlayer == - 1){
                        currPlayer = playersIds.length - 2;
                    }  
                }
                else if (gameDir == false){
                    currPlayer = (currPlayer + 2) % playersIds.length;
                }
            }
    }
}

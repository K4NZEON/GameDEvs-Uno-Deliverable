/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamedevsuno;

/**
 *
 * @author lilia
 */

class InvalidPlayerTurnException extends Exception {
        String playerID;
        
        public InvalidPlayerTurnException(String message, String pid){
            super(message);
            playerID = pid;
        }
        
        public String getpid(){
            return playerID;
        }
    }   


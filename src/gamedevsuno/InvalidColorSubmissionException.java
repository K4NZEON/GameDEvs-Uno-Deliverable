/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamedevsuno;

/**
 *
 * @author lilia
 */
class InvalidColorSubmissionException extends Exception {
        private Card.Color expected;
        private Card.Color actual;
        
        public InvalidColorSubmissionException(String message, Card.Color actual, Card.Color expected){
            this.actual = actual;
            this.expected = expected;
        }
    }
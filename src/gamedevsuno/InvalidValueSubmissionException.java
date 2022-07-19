/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamedevsuno;

/**
 *
 * @author lilia
 */
class InvalidValueSubmissionException extends Exception {
        private Card.Value expected;
        private Card.Value actual;
        
        public InvalidValueSubmissionException(String message, Card.Value actual, Card.Value expected){
            this.actual = actual;
            this.expected = expected;
        }
}
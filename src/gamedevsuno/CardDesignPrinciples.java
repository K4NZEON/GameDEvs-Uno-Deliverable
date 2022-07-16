/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedevsuno;

/**
 * 
 * @author evansk
 */
public class CardDesignPrinciples {
//fetch test
    /** printing cards
     * main method responsible for user interaction
     */
    public static void main(String[] args) 
    {
        GenerateCard cd = new GenerateCard();
        cd.generate();
        for(  Card cc :cd.deck)
        {
        System.out.println(cc.getColor() + " " + cc.getValue());
        }
    }
}
package com.game.exceptions;

/**
 * Exception à appeler en cas de Dépassement de plateau
 */
public class PersonnageHorsPlateauException extends Exception{
    public PersonnageHorsPlateauException(int position){
        System.out.println("Vous êtes hors plateau ! Vous avez dépassé de " + (position - 64) + " cases.");
    }
}

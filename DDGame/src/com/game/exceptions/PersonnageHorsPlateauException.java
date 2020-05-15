package com.game.exceptions;

public class PersonnageHorsPlateauException extends Exception{
    public PersonnageHorsPlateauException(int position){
        System.out.println("Vous êtes hors plateau ! Vous avez dépassé de " + (position - 64) + " cases.");
    }
}

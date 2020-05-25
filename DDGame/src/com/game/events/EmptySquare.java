package com.game.events;

import com.game.Printer;
import com.game.characters.Hero;
import com.game.play.Board;

/**
 * Classe responsable d'evenements sur les cases vides
 */
public class EmptySquare extends Event{
    public EmptySquare(int posPlateau) {
        super(posPlateau);
    }

    public EmptySquare(int posPlateau, String name) {
        super(posPlateau, name);
    }

    public EmptySquare(int posPlateau, String name, String description) {
        super(posPlateau, name, description);
    }

    /**
     * Si le perso tombe sur une case vide, il bivouaque et regagne un point de vie.
     * @param perso
     * @param e
     * @param p
     */
    public void eventHandler(Hero perso, Event e, Printer p, Board board) {
        System.out.println("Rien ici, c'est une bonne occase de bivouaquer et de se refaire une santé.");
        if(perso.getHealth()<perso.getMAXHEALTH()){
            perso.setHealth((perso.getHealth()+1));
            System.out.println("Vous gagnez un pv et êtes maintenant à " + perso.getHealth() + " points de vie.");
        } else {
            System.out.println("Vous êtes déjà au top de votre forme, cela n'a aucun effet");
        }
    }

    @Override
    public String toString() {
        return "La case " + this.posPlateau + " est vide";
    }
}

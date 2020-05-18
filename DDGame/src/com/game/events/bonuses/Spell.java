package com.game.events.bonuses;

import com.game.Printer;
import com.game.characters.Hero;
import com.game.characters.Witcher;
import com.game.events.Bonus;
import com.game.events.Event;

public class Spell extends Bonus {

    public Spell() {
        this(0, "inconnu");
    }

    public Spell(int posPlateau, String name) {
        this(posPlateau, name, "inconnu", 0);
        if (name.equals("Boule de feu")) {
            this.bonusIncrease = 7;
        } else {
            this.bonusIncrease = 2;
        }
        this.description = "Ce sort inflige " + this.bonusIncrease + " points de dégats en plus.";
    }

    public Spell(int posPlateau, String name, String description, int bonusIncrease) {
        super(posPlateau, name, description, bonusIncrease);
    }

    // -- Commentaire Flo -- //
    // Ici aussi tu pourrais te débrouiller pour faire ça un peu plus sexy
    // Je ne vois pas pourquoi c'est eventHandler qui est responsable de vérifier l'intégrité des données
    // Ca devrait être la responsabilité du Witcher je pense (au minimum que setStrength lève une exception, 
    // si vraiment tu veux gérer ça ici
    // -- Fin commentaire Flo -- //
    
    public void eventHandler(Hero perso, Event e, Printer p) {
        if (perso instanceof Witcher) {
            int totalAfterBonus = perso.getStrength() + this.bonusIncrease;
            perso.findBonus(totalAfterBonus, this.bonusIncrease, this.name);
        } else {
            System.out.println(perso.getName() + " tombe sur " + this.name + " mais c'est pas tant son truc.");
        }
        this.posPlateau = 0;
    }
}

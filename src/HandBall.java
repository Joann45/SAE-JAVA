package src;

/**
 * La classe HandBall représente un sport en particulier.
 * Elle étend la classe Sport et ajoute un attribut spécifique pour la distance.
 */
public class HandBall extends Sport {
    
    /**
     * Construit une instance de HandBall.
     */
    public HandBall() {
        super("HandBall");
        this.nbMembresEquipe = 7;
    }
}

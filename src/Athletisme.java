package src;
/**
 * La classe Athletisme représente un sport en particulier.
 * Elle étend la classe Sport et ajoute un attribut spécifique pour la distance.
 */
public class Athletisme extends Sport {

    private final int distance;
    
    /**
     * Construit une instance de Athletisme avec la distance spécifiée.
     * @param distance la distance de l'épreuve (110m ou 400m)
     */
    public Athletisme(int distance) {
        super("Athletisme");
        this.distance = distance;
        this.nbMembresEquipe = 4;
    }

    /**
     * Retourne la distance de l'épreuve de natation.
     * @return la distance en mètres.
     */
    public int getDistance() {
        return this.distance;
    }
}

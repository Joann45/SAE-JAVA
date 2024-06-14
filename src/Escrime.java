
/**
 * La classe Escrime représente un sport en particulier.
 * Elle étend la classe Sport et ajoute un attribut spécifique pour l'arme.
 */
public class Escrime extends Sport {

    private final String arme;
    
    /**
     * Construit une instance de Escrime avec l'arme spécifiée.
     * @param arme l'arme de l'épreuve ("fleuret" ou "épée")
     */
    public Escrime(String arme) {
        super("Escrime");
        this.arme = arme;
    }

    /**
     * Retourne l'arme de l'épreuve d'escrime.
     * @return l'arme.
     */
    public String getArme() {
        return this.arme;
    }
    
}

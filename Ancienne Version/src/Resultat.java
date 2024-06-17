package src;
/**
*@author Joann
*/

/** Classe résultat */
public class Resultat {
    private int score;
    private Epreuve epreuve;

    /**
     * Constructeur de Résultat
     * @param score un score
     * @param epreuve une épreuve
     */
    public Resultat(int score, Epreuve epreuve) {
        this.score = score;
        this.epreuve = epreuve;
    }
    
    /**
     * Retourne le score
     * @return un entier qui est le score
     */
    public int getScore() {
        return score;
    }
    
    /**
     * Retourne l'épreuve
     * @return une épreuve
     */
    public Epreuve getEpreuve() {
        return epreuve;
    }

    /**
     * Modifier un score
     * @param score le nouveau score
     */
    public void setScore(int score) {
        this.score = score;
    }
    
    /**
     * Modifier l'épreuve du résultat
     * @param epreuve la nouvelle épreuve
     */
    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }

    @Override
    public String toString() {
        return "score = " + score;
    }
    
}

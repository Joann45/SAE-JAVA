package src;
/**
*@author Naima
*/

public interface Participant {
    
    /** Méthode abstraite retournant le score à l'épreuve en paramètre
     * @param compet une épreuve
     * @return un entier
     */
    public abstract int participer(Epreuve compet);

    /** Méthode abstraite retournant le nom de l'athlète ou de l'équipe
     * @return une chaine de caractère
     */
    public abstract String obtenirNom();

    /** Méthode abstraite retournant le score total
     * @return un entier
     */
    public abstract int getScoreTotal();
}
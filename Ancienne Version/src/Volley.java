package src;
/**
*@author Thomas
*/

/** Classe Volley qui étend la classe abstraite Equipe */
public class Volley extends Equipe {

    /**
     * Constructeur de Volley
     * @param nomEquipe nom de l'équipe
     */
    public Volley(String nomEquipe) {
        super(nomEquipe);
    }

    @Override
    /** Ajoute un membre à l'équipe de Volley (limite 6 joueurs)
     * @param sportif un athlete
     * @return true si l'athlete a été rajouté à l'équipe
     */
    public boolean ajouteMembres(Athlete sportif) {
        if (this.lesMembres.size()<6) {
            return this.lesMembres.add(sportif);
        }
        return false;
    }

    @Override
    /** Retourne le nom de l'équipe
     * @return string le nom de l'équipe
     */
    public String obtenirNom() {
        return this.getNomEquipe();
    }
}

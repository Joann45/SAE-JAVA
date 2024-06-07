/**
*@author Thomas
*/
import java.util.List;

public class Handball extends Equipe {

    public Handball(String nomEquipe) {
        super(nomEquipe);
    }

    @Override
    /** Ajoute un membre à l'équipe de Handball (limite 7 joueurs)
     * @param sportif un athlete
     * @return true si l'athlete a été rajouté à l'équipe
     */
    public boolean ajouteMembres(Athlete sportif) {
        if (this.lesMembres.size()<7) {
            return this.lesMembres.add(sportif);
        }
        return false;
    }

    @Override
    public String obtenirNom() {
        return this.getNomEquipe();
    } 
}

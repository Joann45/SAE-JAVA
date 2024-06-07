/**
*@author Thomas
*/
import java.util.List;

public class Relais extends Equipe {
    private Epreuve epreuve;

    public Relais(String nomEquipe, Epreuve epreuve) {
        super(nomEquipe);
        this.epreuve = epreuve;
    }
  
    public Epreuve getRelaisEpreuve() {
        return this.epreuve;
    }

    @Override
    /** Ajoute un membre à l'équipe de Relais (limite 4 joueurs)
     * @param sportif un athlete
     * @return true si l'athlete a été rajouté à l'équipe
     */
    public boolean ajouteMembres(Athlete sportif) {
        if (this.lesMembres.size()<4) {
            return this.lesMembres.add(sportif);
        }
        return false;
    }

    @Override
    public String obtenirNom() {
        return this.getNomEquipe();
    }    
}

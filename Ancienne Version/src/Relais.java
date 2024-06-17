package src;
/**
*@author Thomas
*/

/** Classe Relais (pour l'athletisme et la natation) qui étend la classe abstraite Equipe */
public class Relais extends Equipe {
    private Epreuve epreuve;

    /**
     * Constructeur d'une équipe de natation ou d'athlètisme (relais)
     * @param nomEquipe nom de l'équipe
     * @param epreuve le nom de l'épreuve pour distinguer entre natation et athlètisme
     */
    public Relais(String nomEquipe, Epreuve epreuve) {
        super(nomEquipe);
        this.epreuve = epreuve;
    }
  
    /**
     * retourne l'épreuve du relais
     * @return le type d'épreuve concerné par le relais
     */
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

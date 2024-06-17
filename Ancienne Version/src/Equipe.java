package src;
/**
*@author Thomas
*/

import java.util.ArrayList;
import java.util.List;

/** Classe abstraite Equipe implémentant l'interface Participant */
public abstract class Equipe implements Participant, Comparable<Equipe> {
    
    private final String nomEquipe;
    
    /** liste des membres de l'équipe (protected) pour que les classes qui étendent cette classe puisse l'utilisé */
    protected List<Athlete> lesMembres;

    private List<Resultat> lesResultats;

    /** Constructeur d'Equipe
     * @param nomEquipe : le nom de l'équipe
     */
    public Equipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
        this.lesMembres = new ArrayList<>();
        this.lesResultats = new ArrayList<>();
    }

    /** Retourne le nom de l'équipe
     * @return le nom de l'équipe
     */
    public String getNomEquipe() {
        return this.nomEquipe;
    }

    /** Retourne les membres de l'équipe
     * @return la liste des athlètes composant l'équipe
     */
    public List<Athlete> getMembres() {
        return this.lesMembres;
    }

    /** Retourne le pays de l'équipe
     * @return le pays des membres de l'équipe
     */
    public Pays getPays() {
        return this.lesMembres.get(0).getPays();
    }

    /** Ajoute un résultat à une épreuve pour l'équipe
     * @param score le score à l'épreuve
     * @param epreuve une épreuve
     */
    public void ajouteResultat(int score, Epreuve epreuve) {
        Resultat resultat = new Resultat(score, epreuve); // modifier (01/06/2024)
        lesResultats.add(resultat);
        epreuve.ajouterResultat(resultat); // ajouter (01/06/2024)
    }

    /** Ajoute un membre à l'équipe
     * @param sportif un athlete
     * @return true si l'athlete a été rajouté à l'équipe
     */
    public abstract boolean ajouteMembres(Athlete sportif);

// ------------------------------------------------------------------------------------ //

    @Override
    /** Retourne le score que l'équipe à remporté pour une epreuve
     * @param epreuve une epreuve
     * @return le score de l'équipe à l'épreuve
     */
    public int participer(Epreuve epreuve){
        int score = 0;
        for (Athlete sportif : this.lesMembres){
            score += sportif.participer(epreuve);
        } 
        return score;
    }

    /** Retourne le score que l'équipe à remporté pour une epreuve (Version 2)
     * @param epreuve une epreuve
     * @return le score de l'équipe à l'épreuve
     */
    public int participer2(Epreuve epreuve){
        int score = 0;
        for (Resultat result : this.lesResultats){
            if(result.getEpreuve().equals(epreuve))
            score += result.getScore();
        } 
        return score;
    }
    
    @Override
    public int getScoreTotal(){
        int score = 0;
        for (Athlete unAthlete:this.lesMembres){
            score += unAthlete.getScoreTotal();
        }
        return score;
    }

    @Override
    public int compareTo(Equipe uneEquipe){
        return Integer.compare(this.getScoreTotal(), uneEquipe.getScoreTotal())*-1;
    }
}

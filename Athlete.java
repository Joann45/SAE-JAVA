/**
*@author Naima
*/

import java.util.ArrayList;
import java.util.List;

public class Athlete implements Participant, Comparable<Athlete> {

    private final String nom;
    private final String prenom;
    private final char sexe;

    private int force;
    private int agilite;
    private int endurance;
    
    private Pays pays;
    private Sport sport;
    private Equipe uneEquipe;

    private List<Resultat> mesResultats;
    
    /**
     * @param nom
     * @param prenom
     * @param sexe
     * @param force
     * @param agilite
     * @param endurance
     * @param pays
     * @param sport
     */
    public Athlete(String nom, String prenom, char sexe, int force, int agilite, int endurance, Pays pays, Sport sport) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;

        this.force = force;
        this.agilite = agilite;
        this.endurance = endurance;

        this.pays = pays;
        this.sport = sport;
        this.uneEquipe = null;

        this.mesResultats = new ArrayList<>();
    }

    /**
     * @return le nom de l'athlète
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * @return le prénom de l'athlète
     */
    public String getPrenom() {
        return this.prenom;
    }

    /**
     * @return le sexe de l'athlète
     */
    public char getSexe() {
        return this.sexe;
    }

    /**
     * @return la force de l'athlète
     */
    public int getForce() {
        return this.force;
    }

    /**
     * @return le nom de l'athlète
     */
    public int getAgilite() {
        return this.agilite;
    }

    /**
     * @return l'endurance de l'athlète
     */
    public int getEndurance() {
        return this.endurance;
    }

    /**
     * @param force 
     * met à jour la force de l'athlète
     */ 
    public void setForce(int force) {
        this.force = force;
    }

    /**
     * @param agilite
     * met à jour l'agilité de l'athlète
     */
    public void setAgilite(int agilite) {
        this.agilite = agilite;
    }

    /**
     * @param endurance
     * met à jour l'endurance de l'athlète
     */
    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    /**
     * @return le pays de l'athlète
     */
    public Pays getPays() {
        return this.pays;
    }

    /**
     * @param pays 
     * met à jour le pays de l'athlète
     */ 
    public void setPays(Pays pays) {
        this.pays = pays;
    }

    /**
     * @return le sport de l'athlète
     */
    public Sport getSport() {
        return this.sport;
    }   

    /**
     * @return les résultats de l'athlète
     */
    public List<Resultat> getMesResultats() {
        return this.mesResultats;
    }

    /**
     * @return l'équipe de l'athlète
     */
    public Equipe getEquipe() {
        return this.uneEquipe;
    }    
    
    /**
     * @param equipe
     * met à jour l'équipe de l'athlète
     */
    public void inscrireDansEquipe(Equipe equipe) {
        this.uneEquipe = equipe;
    }

    /**
     * @param epreuve
     * renvoie le score d'un athlète pour une épreuve
     */
    @Override
    public int participer(Epreuve epreuve){
        int score = 0;
        for (Resultat res : this.mesResultats){
            if (res.getEpreuve() == epreuve){
                score += res.getScore();
            }
        } 
        return score;
    }

    /**
     * @return le nom et prénom dun athlète
     */
    @Override
    public String obtenirNom() {
        return this.nom + " " + this.prenom;
    }

    /**
     * @param score le score de l'équipe
     * @param epreuve l'épreuve
     * ajoute le score dans les résultats et dans épreuve
     */
    public void ajouteResultat(int score, Epreuve epreuve) {
        int res = score + this.endurance + this.agilite * this.force;
        Resultat resultat = new Resultat(res, epreuve);
        mesResultats.add(resultat);
        epreuve.ajouterResultat(resultat);
    }

    /**
     * @return le score total
     */
    public int scoreTot(){
        int score = 0;
        for (Resultat res: this.mesResultats){
            score += res.getScore();
        }
        return score;
    }

    /**
     * @return le nom de l'athlète
     */
    @Override
    public String toString() {
        return this.obtenirNom();
    }

    /**
     * @param unAthlete
     * @return 1 si le score de l'athlète est plus grand que le score de unAthlete, 0 si ils sont égaux, -1 si non 
     */
    @Override
    public int compareTo(Athlete unAthlete){
        return Integer.compare(scoreTot(), unAthlete.scoreTot())*-1;
    }

// ---------------------------------------------------------------------------------------------------------- //
}
// Naima

import java.util.List;
import java.util.*;

public class Athlete implements Participant {
    private String nom;
    private String prenom;
    private char sexe; // transformer en char
    private int force;
    private int agilite;
    private int endurance;
    private List<Resultat> mesResultats;
    private Pays pays;
    private Sport sport;

    // l'association d'Athlète à équipe ?
    
    public Athlete(String nom, String prenom, char sexe, int force, int agilite, int endurance, Pays pays, Sport sport) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.sport = sport;
        this.force = force;
        this.agilite = agilite;
        this.endurance = endurance;
        this.pays = pays;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public char getSexe() {
        return sexe;
    }

    public int getForce() {
        return force;
    }

    public int getAgilite() {
        return agilite;
    }

    public int getEndurance() {
        return endurance;
    }

    public List<Resultat> getMesResultats() {
        return mesResultats;
    }

    public Pays getPays() {
        return pays;
    }

    public Sport getSport() {
        return sport;
    }    
    
    public void ajouteResultat(int score, int place, Epreuve epreuve) {
        mesResultats.add(new Resultat(score, place, epreuve));
    }


    @Override
    public int getScoreTotal(){
        int score = 0;
        for (Resultat res : this.mesResultats){
            score += res.getScore();
        }
        return score;
    }

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

    // rajout d'un espace entre nom et prénom (Thomas - 18.05)
    @Override
    public String obtenirNom() {
        return this.nom + " " + this.prenom;
    }

}
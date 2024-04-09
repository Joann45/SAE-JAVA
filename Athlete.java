import java.util.List;
import java.util.*;

public class Athlete implements Participant {
    private String nom;
    private String prenom;
    private String sexe;
    private int force;
    private int agilite;
    private int endurance;
    private List<Resultat> mesResultats;
    private Pays pays;
    private Sport sport;
    
    public Athlete(String nom, String prenom, String sexe, int force, int agilite, int endurance, Pays pays, Sport sport) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.sport = sport;
        this.force = force;
        this.agilite = agilite;
        this.endurance = endurance;
        this.sport = sport;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSexe() {
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

    public int getScore(Epreuve epreuve){
        int score = 0;
        for (Resultat res : this.mesResultats){
            if (res.getEpreuve() == epreuve){
                score += res.getScore();
            }
        } 
        return score;
    }

    @Override
    public int participer(Epreuve compet) {
        return this.mesResultats.size();
    }

    @Override
    public String obtenirNom() {
        return this.nom + this.prenom;
    }

}
package src;
/**
*@author Joann
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Classe Epreuve */
public class Epreuve {

    private final Sport sport;
    private final String nomEpreuve;
    private char genre;
    private String competition;

    private List<Resultat> lesResultats;

    
    /** Constructeur d'Epreuve
     * @param sport un sport
     * @param nomEpreuve le nom d'une epreuve
     * @param genre le genre de l'epreuve M pour masculin et F pour féminin
     * @param competition indique si la competition est individuel et en equipe
     */
    public Epreuve(Sport sport, String nomEpreuve, char genre, String competition) {
        this.sport = sport;
        this.nomEpreuve = nomEpreuve;
        this.genre = genre;
        this.competition = competition;
        this.lesResultats = new ArrayList<>();
    }

    /**
     * Retourne le sport concerné par l'épreuve
     * @return le sport
     */
    public Sport getSport() {
        return this.sport;
    }

    /**
     * Retourne le nom de l'épreuve
     * @return une chaine de caractères
     */
    public String getNomEpreuve() {
        return this.nomEpreuve;
    }

    /**
     * Retourne le genre de l'épreuve
     * @return un caractère : M ou F
     */
    public char getGenreEpreuve() {
        return this.genre;
    }

    /**
     * Retourne le type de competition
     * @return une chaine de caractères
     */
    public String getCompetition() {
        return this.competition;
    }

    /**
     * Permet d'ajouter un résultat à l'épreuve
     * @param resultat le résultat à rajouter
     */
    public void ajouterResultat(Resultat resultat) {
        this.lesResultats.add(resultat);
    }

    /**
     * Retourne les résultats à l'épreuve
     * @return la liste des résultats à l'épreuve
     */
    public List<Resultat> getResultats() {
        return this.lesResultats;
    }

    /**
     * Renvoi une liste des epreuves trier en fonction des résultats à l'épreuve 
     * @return liste de résultats trier
     */
    public List<Resultat> ClassementEpreuve() {
        ComparateurResultat comp = new ComparateurResultat();
        Collections.sort(this.lesResultats, comp);
        return this.lesResultats;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null) {return false;}
        if(this == obj) {return true;}
        if (!(obj instanceof Epreuve)) {return false;}

        Epreuve tmp = (Epreuve) obj;
        return this.sport.equals(tmp.sport) && this.nomEpreuve.equals(tmp.nomEpreuve) && this.genre == tmp.genre && this.competition.equals(tmp.competition) && this.lesResultats.equals(tmp.lesResultats);
    }
        
    /**
     * Permet de modifier le genre de la competition
     * @param genre M ou F
     */
    public void setGenre(char genre) {
        this.genre = genre;
    }

    /**
     * Permet de modifier le type de competition
     * @param competition individuel ou par équipe
     */
    public void setCompetition(String competition) {
        this.competition = competition;
    }

    @Override
    public String toString() {
        return "Epreuve [sport=" + sport + ", nomEpreuve=" + nomEpreuve + ", genre=" + genre + ", competition="
                + competition + ", lesResultats=" + lesResultats + "]";
    }
}

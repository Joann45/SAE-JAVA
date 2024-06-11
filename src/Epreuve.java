package src;
/**
*@author Joann
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Epreuve {

    private final Sport sport;
    private final String nomEpreuve;
    private char genre;
    private String competition;

    private List<Resultat> lesResultats;

    public Epreuve(Sport sport, String nomEpreuve, char genre, String competition) {
        this.sport = sport;
        this.nomEpreuve = nomEpreuve;
        this.genre = genre;
        this.competition = competition;
        this.lesResultats = new ArrayList<>();
    }

    public Sport getSport() {
        return this.sport;
    }

    public String getNomEpreuve() {
        return this.nomEpreuve;
    }

    public char getGenreEpreuve() {
        return this.genre;
    }

    public String getCompetition() {
        return this.competition;
    }

    // Rajouter (01/06/2024)
    public void ajouterResultat(Resultat resultat) {
        this.lesResultats.add(resultat);
    }

    // Rajouter (01/06/2024)
    public List<Resultat> getResultats() {
        return this.lesResultats;
    }

    // Rajouter (01/06/2024)
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
    
// ---------------------------------------------------------------------------------------------------------- //

    

    public void setGenre(char genre) {
        this.genre = genre;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    @Override
    public String toString() {
        return "Epreuve [sport=" + sport + ", nomEpreuve=" + nomEpreuve + ", genre=" + genre + ", competition="
                + competition + ", lesResultats=" + lesResultats + "]";
    }
}

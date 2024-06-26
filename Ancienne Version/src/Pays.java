package src;

/**
*@author Naima
*/

import java.util.ArrayList;
import java.util.List;

/** Classe pays */
public class Pays {
    private final String nomPays;
    private List<Athlete> lesAthletes;

    /**
     * constructeur de pays
     * @param nomPays le nom d'un pays
     * 
    */
    public Pays(String nomPays) {
        this.nomPays = nomPays;
        this.lesAthletes = new ArrayList<>();
    }

    /**
     * @return le nom du pays
     */
    public String getNomPays() {
        return this.nomPays;
    }

    /**
     * @return les athlètes du pays
     */
    public List<Athlete> getLesAthletes() {
        return this.lesAthletes;
    }

    /**
     * @param lesAthletes une liste d'athlète
     * met à jour les athlètes 
     */
    public void setLesAthletes(List<Athlete> lesAthletes) {
        this.lesAthletes = lesAthletes;
    }

    /**
     * @param athlete un athlète
     * ajoute athlete dans les athlètes
     */
    public void ajouterAthlete(Athlete athlete){
        this.lesAthletes.add(athlete);
    }

    /**
     * calcule le score total de tout les athlètes
     * @return le score total
     */
    public int scoreTot(){
        int score = 0;
        for (Athlete unAthlete:this.lesAthletes){
            score += unAthlete.scoreTot();
        }
        return score;
    }

    /**
     * indique quel pays a le score le plus grand
     * @param unPays le nom d'un pays
     * @return 1 si le score du pays est plus grand que le score de unPays, 0 si ils sont égaux, -1 si non 
     */
    public int compareTo(Pays unPays){
        return Integer.compare(this.scoreTot(), unPays.scoreTot())*-1;
    }

    /**
     * @return le nom du pays et la liste des athlètes
     */
    @Override
    public String toString() {
        return "Le pays : " + nomPays + ", possède les Athletes : " + lesAthletes;
    }
}

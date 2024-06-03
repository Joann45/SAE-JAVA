// Naima

import java.util.ArrayList;
import java.util.List;

public class Pays {
    private String nomPays;
    private List<Athlete> lesAthletes;

    public Pays(String nomPays) {
        this.nomPays = nomPays;
        this.lesAthletes = new ArrayList<>();
    }

    public String getNomPays() {
        return nomPays;
    }

    // Pas trop utile = je pense pas qu'un pays change de nom ... (T - 18.05)
    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }

    public List<Athlete> getLesAthletes() {
        return lesAthletes;
    }

    public void setLesAthletes(List<Athlete> lesAthletes) {
        this.lesAthletes = lesAthletes;
    }

    // inutile ... getNomPays() au-dessus (T - 18.05)
    //
    //public String getPays() {
    //    return nomPays;
    //}

    public void ajouterAthlete(Athlete athlete){
        this.lesAthletes.add(athlete);
    }
}

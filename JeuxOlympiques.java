import java.util.ArrayList;
import java.util.List;

public class JeuxOlympiques {
    private List<Epreuve> lesEpreuves;
    private List<Pays> lesPays;
    private List<Athlete> lesAthletes;

    public JeuxOlympiques() {
        this.lesEpreuves = new ArrayList<>();
        this.lesPays = new ArrayList<>();
        this.lesAthletes = new ArrayList<>();
    }

    public void ajouterAthlete(String nom, String prenom, String sexe, Sport sport, int force, int agilite, int endurance, Pays pays) {
        new Athlete(nom, prenom, sexe, sport, force, agilite, endurance, pays);
    }

    public void ajouterEpreuve(String nomEpreuve, String genre, String competition) {
        new Epreuve(nomEpreuve, genre, competition);
    }

    public boolean lancerEpreuve() {
        return true;
    }

    public void enregistrerResultat() {

    }

    public List<Epreuve> consulterEpreuve() {
        return this.lesEpreuves;
    }

    public List<Pays> consulterPays() {
        return this.lesPays;
    }

    public List<Athlete> consulterAthlete() {
        return this.lesAthletes;
    }

    public int participer(Participant concurrent) {
        return 0;
    }
}
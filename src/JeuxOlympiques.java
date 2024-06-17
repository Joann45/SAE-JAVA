

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JeuxOlympiques {
    
    private Set<Epreuve> lesEpreuves;
    private List<Athlete> lesAthletes;
    private List<Equipe> lesEquipes;

    public JeuxOlympiques() {
        this.lesEpreuves = new HashSet<>();
        this.lesAthletes = new ArrayList<>();
        this.lesEquipes = new ArrayList<>();
    }

    public Set<Epreuve> getLesEpreuves() {
        return this.lesEpreuves;
    }

    public void ajouterEpreuve(Epreuve epreuve) {
        this.lesEpreuves.add(epreuve);
    }

    public void retirerEpreuve(Epreuve epreuve) {
        this.lesEpreuves.remove(epreuve);
    }


    public List<Athlete> getLesAthletes() {
        return this.lesAthletes;
    }

    public void ajouterAthlete(Athlete athlete) {
        this.lesAthletes.add(athlete);
    }

    public void ajouterAthlete(String nomA, String prenomA, char sexeA, int force, int agilite, int endurance, Pays paysA, Equipe equipe) {
        this.lesAthletes.add(new Athlete(nomA, prenomA, sexeA, force, agilite, endurance, paysA, equipe));
    }

    public void ajouterAthleteCSV(String fileName) {
        try {
            List<String> lignes = Files.readAllLines(Paths.get(fileName));
            for (String ligne : lignes) {
                String[] details = ligne.split(";");
                if (details.length == 8) {
                    String nom = details[0];
                    String prenom = details[1];
                    char sexe = details[2].charAt(0);
                    int force = Integer.parseInt(details[3]);
                    int agilite = Integer.parseInt(details[4]);
                    int endurance = Integer.parseInt(details[5]);
                    Pays pays = new Pays(details[6]);
                    Equipe tmp = new Equipe(details[7]);
                    if (!(this.lesEquipes.contains(tmp))) {
                        Athlete athlete = new Athlete(nom, prenom, sexe, force, agilite, endurance, pays, tmp);
                        ajouterAthlete(athlete);
                    }
                    else {
                        for (Equipe equip : this.lesEquipes) {
                            if (equip.equals(tmp)) {
                                Athlete athlete = new Athlete(nom, prenom, sexe, force, agilite, endurance, pays, equip);
                                ajouterAthlete(athlete);
                            }
                        }
                    }
                }
            }

        } catch (IOException e) {
        }
    }

    public Set<Pays> getLesPays() {
        Set<Pays> listePays = new HashSet<>();
        for (Athlete athlete : this.lesAthletes) {
            listePays.add(athlete.getPaysAthlete());
        }
        return listePays;
    }

    public void retirerAthlete(Athlete athlete) {
        this.lesAthletes.remove(athlete);
    }
    

    public List<Equipe> getLesEquipes() {
        return this.lesEquipes;
    }

    public void ajouterEquipe(Equipe equipe) {
        this.lesEquipes.add(equipe);
    }

    public void retirerEquipe(Equipe equipe) {
        this.lesEquipes.remove(equipe);
    }
}

package src;
/**
*@author Joann
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JeuxOlympiques {
    private Set<Epreuve> lesEpreuves;
    private Set<Pays> lesPays;
    private List<Athlete> lesAthletes;

    // Transformation de lesEpreuves et lesPays en ensemble
    public JeuxOlympiques() {
        this.lesEpreuves = new HashSet<>();
        this.lesPays = new HashSet<>();
        this.lesAthletes = new ArrayList<>();
    }

    public void ajouterAthlete(String nom, String prenom, char sexe, Sport sport, int force, int agilite, int endurance, Pays pays) {
        Athlete unAthlete = new Athlete(nom, prenom, sexe, force, agilite, endurance, pays, sport);
        this.lesAthletes.add(unAthlete);
        pays.ajouterAthlete(unAthlete);
        if (!this.lesPays.contains(pays)){ // plus nécessaire car lesPays devient un ensemble
            this.lesPays.add(pays);
        }
    }

    public void ajouterAthleteCsv(String fileName) {
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(cvsSplitBy);
                System.out.println("Nom : " + columns[0] + " , Prénom : " + columns[1] + " , Sexe : " + columns[2] + " , Force : " + columns[3] + " , Agilite : " + columns[4] + " , Endurance : " + columns[5] + " , Pays : " + columns[6] + " , Sport : " + columns[7]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

    public void ajouterEpreuve(Sport sport, String nomEpreuve, char genre, String competition) {
        Epreuve uneEpreuve = new Epreuve(sport, nomEpreuve, genre, competition);
        this.lesEpreuves.add(uneEpreuve);
    }

    public void ajouterEpreuve(Epreuve epreuve) {
        this.lesEpreuves.add(epreuve);
    }

    public void ajouterAthlete(Athlete athlete) {
        this.lesAthletes.add(athlete);
        athlete.getPays().ajouterAthlete(athlete);
        if (!this.lesPays.contains(athlete.getPays())){ // plus nécessaire car lesPays devient un ensemble
            this.lesPays.add(athlete.getPays());
        }
    }


/* 
    public boolean lancerEpreuve() {
        return true;
    }
*/

    // Oui on verra lors de la semaine SAE (Thomas - 18.05)
    public void enregistrerResultat(Participant participant, Epreuve epreuve, int score) {
        //* JDBC ??? */
        if (participant instanceof Athlete sportif) {
            sportif.ajouteResultat(score, epreuve);
        }
        else {
            Equipe equipe = (Equipe) participant;
            equipe.ajouteResultat(score, epreuve);
        }
        
    }

    public Set<Epreuve> consulterEpreuve() {
        return this.lesEpreuves;
    }

    public Set<Pays> consulterPays() {
        return this.lesPays;
    }

    public List<Athlete> consulterAthlete() {
        return this.lesAthletes;
    }

    public int participer(Participant participant, Epreuve epreuve) {
        if (participant instanceof Athlete sportif) {
            return sportif.participer(epreuve);
        }
        else {
            Equipe equipe = (Equipe) participant;
            return equipe.participer(epreuve);
        }
    }
}

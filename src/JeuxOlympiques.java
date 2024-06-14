package src;
/**
*@author Joann
*/

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/** Classe JeuxOlympiques */
public class JeuxOlympiques {
    private Set<Epreuve> lesEpreuves;
    private Set<Pays> lesPays;
    private List<Athlete> lesAthletes;

    /**
     * Constructeur de JeuxOlympiques (initialisation)
     */
    public JeuxOlympiques() {
        this.lesEpreuves = new HashSet<>();
        this.lesPays = new HashSet<>();
        this.lesAthletes = new ArrayList<>();
    }

    /**
     * Ajoute un athlète aux jeux olympiques
     * @param nom le nom de l'athlète
     * @param prenom le prénom de l'athlète
     * @param sexe le sexe de l'athlète
     * @param sport le sport que pratique l'athlète
     * @param force la force de l'athlète
     * @param agilite l'agilite de l'athlète
     * @param endurance l'endurance de l'athlète
     * @param pays le pays de l'athlète
     */
    public void ajouterAthlete(String nom, String prenom, char sexe, Sport sport, int force, int agilite, int endurance, Pays pays) {
        Athlete unAthlete = new Athlete(nom, prenom, sexe, force, agilite, endurance, pays, sport);
        this.lesAthletes.add(unAthlete);
        pays.ajouterAthlete(unAthlete);
        if (!this.lesPays.contains(pays)){ // plus nécessaire car lesPays devient un ensemble
            this.lesPays.add(pays);
        }
    }

    /**
     * Ajoute un athlète (version 2 - l'athlète est déjà créée)
     * @param athlete un athlète
     */
    public void ajouterAthlete(Athlete athlete) {
        this.lesAthletes.add(athlete);
        athlete.getPays().ajouterAthlete(athlete);
        if (!this.lesPays.contains(athlete.getPays())){ // plus nécessaire car lesPays devient un ensemble
            this.lesPays.add(athlete.getPays());
        }
    }

    /**
     * Ajoute un athlète aux JO depuis un fichier CSV
     * @param fileName le nom du fichier
     * @throws FileNotFoundException si le fichier n'est pas trouvé
     */
    public void ajouterAthleteCsv(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        scanner.nextLine();
        while(scanner.hasNextLine()){
            String[] data = scanner.nextLine().split(",");
            String nom = data[0];
            String prenom = data[1];
            char sexe = data[2].charAt(0);
            String paysS = data[6];
            Pays pays = new Pays(paysS);
            if (!(this.lesPays.contains(pays))) {
                this.lesPays.add(pays);
            }
            String sportS = data[7];
            Sport sport = new Sport(sportS);
            int force = Integer.parseInt(data[3]);
            int endurance = Integer.parseInt(data[5]);
            int agilite = Integer.parseInt(data[4]);
            Athlete unAthlete = new Athlete(nom, prenom, sexe, force, agilite, endurance, pays, sport);
            this.lesAthletes.add(unAthlete);
        }
        scanner.close();
    }

    /**
     * Ajoute une épreuve au JO
     * @param sport le sport concerné par l'Epreuve
     * @param nomEpreuve le nom de l'épreuve
     * @param genre le genre de l'épreuve : M ou F
     * @param competition le type de competition : ind. ou équipe
     */
    public void ajouterEpreuve(Sport sport, String nomEpreuve, char genre, String competition) {
        Epreuve uneEpreuve = new Epreuve(sport, nomEpreuve, genre, competition);
        this.lesEpreuves.add(uneEpreuve);
    }

    /**
     * Ajoute une épreuve (version 2 - l'épreuve est déjà créée)
     * @param epreuve le nom de l'épreuve
     */
    public void ajouterEpreuve(Epreuve epreuve) {
        this.lesEpreuves.add(epreuve);
    }

/* 
    public boolean lancerEpreuve() {
        return true;
    }
*/

    /**
     * Enregistre le résultat d'un participant (athlète ou équipe) à une épreuve
     * @param participant un athlète ou une équipe
     * @param epreuve une épreuve
     * @param score le score
     */
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

    /**
     * Permet d'afficher l'ensemble des epreuves
     * @return affiche l'ensemble des epreuves
     */
    public Set<Epreuve> consulterEpreuve() {
        return this.lesEpreuves;
    }

    /**
     * Permet d'afficher l'ensemble des pays
     * @return affiche l'ensemble des pays
     */
    public Set<Pays> consulterPays() {
        return this.lesPays;
    }

    /**
     * Permet d'afficher la liste des athlètes
     * @return affiche la liste des athlètes
     */
    public List<Athlete> consulterAthlete() {
        return this.lesAthletes;
    }

    /**
     * Participation d'un athlète ou d'une équipe à une épreuve retournant son score
     * @param participant un athlète ou une équipe
     * @param epreuve une épreuve
     * @return le score du participant à l'épreuve
     */
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

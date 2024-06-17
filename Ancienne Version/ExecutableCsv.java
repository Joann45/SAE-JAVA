
import java.io.FileNotFoundException;

import src.Epreuve;
import src.JeuxOlympiques;
import src.Sport;

public class ExecutableCsv {
    public static void main(String[] args) throws FileNotFoundException {
        JeuxOlympiques JO2025 = new JeuxOlympiques();

        // les sports
        Sport natation = new Sport("Natation");
        Sport volley = new Sport("Volley-Ball");
        Sport escrime = new Sport("Escrime");
        Sport athle = new Sport("Athlétisme");
        Sport hand = new Sport("HandBall");

        // les epreuves
        Epreuve natation100mBrasseF = new Epreuve(natation, "100m brasse", 'F', "individuel");
        Epreuve natation100mBrasseH = new Epreuve(natation, "100m brasse", 'M', "individuel");
        Epreuve natation4x100mF = new Epreuve(natation, "4x100m libre", 'F', "individuel");
        Epreuve natation4x100mH = new Epreuve(natation, "4x100m libre", 'M', "individuel");

        JO2025.ajouterEpreuve(natation100mBrasseF);
        JO2025.ajouterEpreuve(natation100mBrasseH);
        JO2025.ajouterEpreuve(natation4x100mF);
        JO2025.ajouterEpreuve(natation4x100mH);

        Epreuve handFind = new Epreuve(hand, "HandBall", 'F', "individuel");
        Epreuve handMind = new Epreuve(hand,"HandBall", 'M', "individuel");

        JO2025.ajouterEpreuve(handFind);
        JO2025.ajouterEpreuve(handMind);

        Epreuve volleyFind = new Epreuve(volley, "Volley-Ball", 'F', "individuel");
        Epreuve volleyHind = new Epreuve(volley, "Volley-Ball", 'F', "individuel");
        
        JO2025.ajouterEpreuve(volleyFind);
        JO2025.ajouterEpreuve(volleyHind);

        Epreuve escrimeFfind = new Epreuve(escrime, "fleuret", 'F', "individuel");
        Epreuve escrimeMfind = new Epreuve(escrime,"fleuret", 'M', "individuel");
        Epreuve escrimeFeind = new Epreuve(escrime, "épée", 'F', "individuel");
        Epreuve escrimeMeind = new Epreuve(escrime, "épée", 'M', "individuel");
    
        JO2025.ajouterEpreuve(escrimeFfind);
        JO2025.ajouterEpreuve(escrimeFeind);
        JO2025.ajouterEpreuve(escrimeMfind);
        JO2025.ajouterEpreuve(escrimeMeind);

        Epreuve athle110mF = new Epreuve(athle, "Athlétisme 110m haies", 'F', "individuel");
        Epreuve athle110mH = new Epreuve(athle,"Athlétisme 110m haies", 'M', "individuel");
        Epreuve athle400mF = new Epreuve(athle, "Athlétisme 4x100m haies", 'F', "individuel");
        Epreuve athle400mH = new Epreuve(athle, "Athlétisme 4x100m haies", 'M', "individuel");
    
        JO2025.ajouterEpreuve(athle110mF);
        JO2025.ajouterEpreuve(athle110mH);
        JO2025.ajouterEpreuve(athle400mF);
        JO2025.ajouterEpreuve(athle400mH);

        JO2025.ajouterAthleteCsv("donnees.csv");
        System.out.println(JO2025.consulterAthlete());
    }
}

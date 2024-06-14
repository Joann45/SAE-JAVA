// Thomas

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import src.Athlete;
import src.Epreuve;
import src.Equipe;
import src.Handball;
import src.JeuxOlympiques;
import src.Pays;
import src.Sport;
import src.Volley;

public class Executable {

    public static void main(String [] args) {
        JeuxOlympiques JO2024 = new JeuxOlympiques();

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

        JO2024.ajouterEpreuve(natation100mBrasseF);
        JO2024.ajouterEpreuve(natation100mBrasseH);
        JO2024.ajouterEpreuve(natation4x100mF);
        JO2024.ajouterEpreuve(natation4x100mH);

        Epreuve handFind = new Epreuve(hand, "HandBall", 'F', "individuel");
        Epreuve handMind = new Epreuve(hand,"HandBall", 'M', "individuel");

        JO2024.ajouterEpreuve(handFind);
        JO2024.ajouterEpreuve(handMind);

        Epreuve volleyFind = new Epreuve(volley, "Volley-Ball", 'F', "individuel");
        Epreuve volleyHind = new Epreuve(volley, "Volley-Ball", 'F', "individuel");
        
        JO2024.ajouterEpreuve(volleyFind);
        JO2024.ajouterEpreuve(volleyHind);

        Epreuve escrimeFfind = new Epreuve(escrime, "fleuret", 'F', "individuel");
        Epreuve escrimeMfind = new Epreuve(escrime,"fleuret", 'M', "individuel");
        Epreuve escrimeFeind = new Epreuve(escrime, "épée", 'F', "individuel");
        Epreuve escrimeMeind = new Epreuve(escrime, "épée", 'M', "individuel");
    
        JO2024.ajouterEpreuve(escrimeFfind);
        JO2024.ajouterEpreuve(escrimeFeind);
        JO2024.ajouterEpreuve(escrimeMfind);
        JO2024.ajouterEpreuve(escrimeMeind);

        Epreuve athle110mF = new Epreuve(athle, "Athlétisme 110m haies", 'F', "individuel");
        Epreuve athle110mH = new Epreuve(athle,"Athlétisme 110m haies", 'M', "individuel");
        Epreuve athle400mF = new Epreuve(athle, "Athlétisme 4x100m haies", 'F', "individuel");
        Epreuve athle400mH = new Epreuve(athle, "Athlétisme 4x100m haies", 'M', "individuel");
    
        JO2024.ajouterEpreuve(athle110mF);
        JO2024.ajouterEpreuve(athle110mH);
        JO2024.ajouterEpreuve(athle400mF);
        JO2024.ajouterEpreuve(athle400mH);

        // les pays
        Pays japon = new Pays("Japon");
        Pays kenya = new Pays("Kenya");
        Pays allemagne = new Pays("AAlemagne");
        Pays brésil = new Pays("Brésil");
        Pays france = new Pays("France");
        Pays chine = new Pays("Chine");
        Pays australie = new Pays("Australie");
        Pays maroc = new Pays("Maroc");
        Pays usa = new Pays("USA");
        Pays turquie = new Pays("Turquie");

        // les athlètes
        Athlete athlete0 = new Athlete("Koch", "Emma", 'M', 6, 10, 14, japon, natation);
        Athlete athlete1 = new Athlete("Guo", "Wei", 'F', 19, 1, 5, usa, volley);
        Athlete athlete2 = new Athlete("Michel", "Inès", 'F', 1, 7, 18, turquie, athle);
        Athlete athlete3 = new Athlete("Garcia", "Emma", 'M', 20, 8, 3, brésil, hand); ///
        Athlete athlete4 = new Athlete("Sun", "Yang", 'F', 11, 11, 5, kenya, hand);
        Athlete athlete5 = new Athlete("Ishikawa", "Kazuki", 'F', 18, 9, 6, australie, hand);
        Athlete athlete6 = new Athlete("Hu", "Xia", 'M', 4, 4, 15, usa, volley);
        Athlete athlete7 = new Athlete("Fournier", "Raphaël", 'F', 3, 16, 14, chine, natation);
        Athlete athlete8 = new Athlete("Ishikawa", "Naoki", 'M', 12, 13, 6, japon, volley);
        Athlete athlete9 = new Athlete("Becker", "Maximilian", 'F', 8, 20, 18, chine, athle); //
        Athlete athlete10 = new Athlete("Huang", "Zhou", 'F', 19, 9, 15, chine, natation);
        Athlete athlete11 = new Athlete("Zimmermann", "David", 'F', 1, 16, 8, chine, escrime);
        Athlete athlete12 = new Athlete("Sun", "Jing", 'M', 18, 12, 4, brésil, hand); ///
        Athlete athlete13 = new Athlete("Guerin", "Nolan", 'M', 10, 8, 12, australie, natation);
        Athlete athlete14 = new Athlete("Matsumoto", "Yuma", 'F', 9, 1, 8, turquie, natation);
        Athlete athlete15 = new Athlete("Girard", "Zoé", 'M', 5, 13, 9, france, natation);
        Athlete athlete16 = new Athlete("Schmidt", "Niklas", 'F', 16, 12, 11, usa, athle);
        Athlete athlete17 = new Athlete("Inoue", "Ryota", 'M', 18, 17, 9, usa, natation);
        Athlete athlete18 = new Athlete("Klein", "Luca", 'F', 13, 4, 1, maroc, natation);
        Athlete athlete19 = new Athlete("Neumann", "Anna", 'M', 8, 15, 16, usa, hand);
        Athlete athlete20 = new Athlete("He", "Hong", 'F', 10, 11, 15, allemagne, escrime);
        Athlete athlete21 = new Athlete("Dupont", "Manon", 'F', 12, 20, 11, chine, athle); //
        Athlete athlete22 = new Athlete("Kimura", "Haruka", 'F', 19, 8, 2, brésil, hand); ///
        Athlete athlete23 = new Athlete("Roux", "Nathan", 'M', 11, 18, 17, france, escrime);
        Athlete athlete24 = new Athlete("Gao", "Ma", 'F', 2, 2, 13, chine, hand);
        Athlete athlete25 = new Athlete("Guerin", "Lola", 'F', 12, 16, 5, maroc, escrime);
        Athlete athlete26 = new Athlete("Lefebvre", "Lola", 'M', 16, 6, 7, maroc, natation);
        Athlete athlete27 = new Athlete("Shibata", "Akira", 'M', 7, 16, 17, usa, escrime);
        Athlete athlete28 = new Athlete("Braun", "Lukas", 'M', 5, 16, 16, france, athle);
        Athlete athlete29 = new Athlete("Zhang", "Xin", 'F', 11, 5, 10, brésil, hand); ///
        Athlete athlete30 = new Athlete("Guo", "Zhang", 'M', 20, 8, 4, kenya, athle);
        Athlete athlete31 = new Athlete("Chen", "Xiang", 'F', 15, 14, 4, japon, escrime);
        Athlete athlete32 = new Athlete("Yamada", "Daiki", 'M', 19, 14, 12, turquie, natation);
        Athlete athlete33 = new Athlete("Kato", "Hinata", 'F', 14, 5, 10, chine, athle); //
        Athlete athlete34 = new Athlete("Giraud", "Sarah", 'M', 1, 2, 8, brésil, hand); ///
        Athlete athlete35 = new Athlete("Yamaguchi", "Kokoro", 'M', 18, 8, 2, brésil, hand); ///
        Athlete athlete36 = new Athlete("Sakamoto", "Yuna", 'F', 4, 17, 16, maroc, escrime);
        Athlete athlete37 = new Athlete("Schmitz", "Tom", 'F', 16, 4, 1, maroc, volley);
        Athlete athlete38 = new Athlete("Fontaine", "Nathan", 'F', 17, 9, 6, chine, athle); //
        Athlete athlete39 = new Athlete("Maeda", "Takeshi", 'F', 13, 7, 19, brésil, hand); ///

        JO2024.ajouterAthlete(athlete0);
        JO2024.ajouterAthlete(athlete1);
        JO2024.ajouterAthlete(athlete2);
        JO2024.ajouterAthlete(athlete3);
        JO2024.ajouterAthlete(athlete4);
        JO2024.ajouterAthlete(athlete5);
        JO2024.ajouterAthlete(athlete6);
        JO2024.ajouterAthlete(athlete7);
        JO2024.ajouterAthlete(athlete8);
        JO2024.ajouterAthlete(athlete9);
        JO2024.ajouterAthlete(athlete10);
        JO2024.ajouterAthlete(athlete11);
        JO2024.ajouterAthlete(athlete12);
        JO2024.ajouterAthlete(athlete13);
        JO2024.ajouterAthlete(athlete14);
        JO2024.ajouterAthlete(athlete15);
        JO2024.ajouterAthlete(athlete16);
        JO2024.ajouterAthlete(athlete17);
        JO2024.ajouterAthlete(athlete18);
        JO2024.ajouterAthlete(athlete19);
        JO2024.ajouterAthlete(athlete20);
        JO2024.ajouterAthlete(athlete21);
        JO2024.ajouterAthlete(athlete22);
        JO2024.ajouterAthlete(athlete23);
        JO2024.ajouterAthlete(athlete24);
        JO2024.ajouterAthlete(athlete25);
        JO2024.ajouterAthlete(athlete26);
        JO2024.ajouterAthlete(athlete27);
        JO2024.ajouterAthlete(athlete28);
        JO2024.ajouterAthlete(athlete29);
        JO2024.ajouterAthlete(athlete30);
        JO2024.ajouterAthlete(athlete31);
        JO2024.ajouterAthlete(athlete32);
        JO2024.ajouterAthlete(athlete33);
        JO2024.ajouterAthlete(athlete34);
        JO2024.ajouterAthlete(athlete35);
        JO2024.ajouterAthlete(athlete36);
        JO2024.ajouterAthlete(athlete37);
        JO2024.ajouterAthlete(athlete38);
        JO2024.ajouterAthlete(athlete39);

        // Création d'une équipe
        Equipe equipAthle1 = new Volley("Equipe de Relais athlétisme");

        equipAthle1.ajouteMembres(athlete9);
        equipAthle1.ajouteMembres(athlete21);
        equipAthle1.ajouteMembres(athlete33);
        equipAthle1.ajouteMembres(athlete38);

        Equipe equipHand1 = new Handball("Equipe de HandBall 1");

        equipHand1.ajouteMembres(athlete39);
        equipHand1.ajouteMembres(athlete35);
        equipHand1.ajouteMembres(athlete34);
        equipHand1.ajouteMembres(athlete29);
        equipHand1.ajouteMembres(athlete12);
        equipHand1.ajouteMembres(athlete3);
        equipHand1.ajouteMembres(athlete22);

        // ajout de résultat
        athlete9.ajouteResultat(10, athle110mH);
        athlete21.ajouteResultat(15, athle110mH);
        athlete33.ajouteResultat(5, athle110mH);
        athlete38.ajouteResultat(18, athle110mH);

        System.out.println("Test affichage résultat d'un athlète à un sport \n");
        System.out.println("Le score de l'athlète " + athlete9 + " à la discipline : " + athlete9.getSport() + " est de : " + athlete9.participer(athle110mH) + "\n");
        System.out.println("Le score de l'athlète " + athlete21 + " à la discipline : " + athlete21.getSport() + " est de : " + athlete21.participer(athle110mH) + "\n");
        System.out.println("Le score de l'athlète " + athlete33 + " à la discipline : " + athlete33.getSport() + " est de : " + athlete33.participer(athle110mH) + "\n");
        System.out.println("Le score de l'athlète " + athlete38 + " à la discipline : " + athlete38.getSport() + " est de : " + athlete38.participer(athle110mH) + "\n");

        JO2024.enregistrerResultat(equipAthle1, athle110mH, athlete9.participer(athle110mH)+athlete21.participer(athle110mH)+athlete33.participer(athle110mH)+athlete38.participer(athle110mH));

        athlete0.ajouteResultat(6, athle400mH);
        athlete1.ajouteResultat(8, natation4x100mF);
        athlete2.ajouteResultat(13, escrimeFfind);
        athlete3.ajouteResultat(8, escrimeMfind);
        athlete4.ajouteResultat(20, natation100mBrasseH);
        athlete5.ajouteResultat(16, athle400mF);
        athlete6.ajouteResultat(7, athle400mH);
        athlete7.ajouteResultat(18, escrimeMeind);
        athlete8.ajouteResultat(8, escrimeFfind);
        athlete9.ajouteResultat(1, volleyFind);
        athlete10.ajouteResultat(3, escrimeMfind);
        athlete11.ajouteResultat(14, athle400mF);
        athlete12.ajouteResultat(6, volleyFind);
        athlete13.ajouteResultat(16, handFind);
        athlete14.ajouteResultat(18, athle400mH);
        athlete15.ajouteResultat(18, escrimeMfind);
        athlete16.ajouteResultat(4, volleyFind);
        athlete17.ajouteResultat(20, natation100mBrasseH);
        athlete18.ajouteResultat(1, handMind);
        athlete19.ajouteResultat(8, natation4x100mF);
        athlete20.ajouteResultat(12, athle400mF);
        athlete21.ajouteResultat(14, escrimeMfind);
        athlete22.ajouteResultat(8, natation100mBrasseH);
        athlete23.ajouteResultat(16, natation100mBrasseH);
        athlete24.ajouteResultat(4, escrimeMeind);
        athlete25.ajouteResultat(20, natation4x100mH);
        athlete26.ajouteResultat(11, natation4x100mF);
        athlete27.ajouteResultat(3, natation4x100mF);
        athlete28.ajouteResultat(17, athle400mF);
        athlete29.ajouteResultat(17, escrimeMeind);
        athlete30.ajouteResultat(18, escrimeFfind);
        athlete31.ajouteResultat(18, natation100mBrasseH);
        athlete32.ajouteResultat(2, athle110mH);
        athlete33.ajouteResultat(12, escrimeFeind);
        athlete34.ajouteResultat(11, escrimeMfind);
        athlete35.ajouteResultat(17, natation4x100mH);
        athlete36.ajouteResultat(15, escrimeMeind);
        athlete37.ajouteResultat(7, escrimeMfind);
        athlete38.ajouteResultat(11, handFind);
        athlete39.ajouteResultat(18, escrimeFfind);

        // obtenir classement avec résultats

        System.out.println("Test affichage classement à l'épreuve Athlétisme 110m Homme \n");
        System.out.println(athle110mH.ClassementEpreuve() + "\n");
        
        System.out.println("Test affichage des athlètes \n");
        System.out.println(JO2024.consulterAthlete()+"\n");
        List<Athlete> listeTriee = new ArrayList<>();
        listeTriee.addAll(JO2024.consulterAthlete());
        Collections.sort(listeTriee);
        System.out.println("Test affichage des noms des athlètes trié par le score total \n");
        System.out.println(listeTriee+"\n");

        // obtenir résultat d'un athlète

        System.out.println("Test affichage des épreuves \n");
        System.out.println(JO2024.consulterEpreuve()+"\n");
        System.out.println("Test affichage des pays \n");
        System.out.println(JO2024.consulterPays()+"\n");
        System.out.println("Test affichage résultat d'un athlète (39) à un sport (escrime fleuret) - méthode participer \n");
        System.out.println(JO2024.participer(athlete39, escrimeFfind)+"\n");
        System.out.println("Test affichage résultat d'une équipe (1) à un sport (athletisme 110m) - méthode participer \n");
        System.out.println(JO2024.participer(equipAthle1, athle110mH)+"\n");
        System.out.println("Test affichage du nom et prénom de l'athlète 12 \n");
        System.out.println(athlete12.obtenirNom()+"\n");
        System.out.println("Test affichage des résultats de l'athlète 12 \n");
        System.out.println(athlete12.getMesResultats()+"\n");
        athlete1.inscrireDansEquipe(equipHand1);
        System.out.println("Test affichage des membres d'une équipe \n");
        System.out.println(equipHand1.getMembres());   
    }
}
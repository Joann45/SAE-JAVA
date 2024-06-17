import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Executable {
    public static void main(String[] args) throws Exception {
        /** Création des 8 sports */
        Sport hand = new HandBall();
        Sport volley = new VolleyBall();
        Sport fleuret = new Escrime("Fleuret");
        Sport epee = new Escrime("Épée");
        Sport haies = new Athletisme(110);
        Sport relais = new Athletisme(400);
        Sport brasse = new Natation(100);
        Sport nageLibre = new Natation(400);

        /** Création des 16 épreuves */
        Epreuve brasseH = new Epreuve("100m brasse Homme", 'H', brasse);
        Epreuve brasseF = new Epreuve("100m brasse Femme", 'F', brasse);
        Epreuve nageH = new Epreuve("4x100m nage libre Homme", 'H', nageLibre);
        Epreuve nageF = new Epreuve("4x100m nage libre Femme", 'F', nageLibre);
        Epreuve relaisH = new Epreuve("4x100m relais Homme", 'H', relais);
        Epreuve relaisF = new Epreuve("4x100m relais Femme", 'F', relais);
        Epreuve haiesH = new Epreuve("110m haies Homme", 'H', haies);
        Epreuve haiesF = new Epreuve("110m haies Femme", 'F', haies);
        Epreuve epeeH = new Epreuve("Épée Homme", 'H', epee);
        Epreuve epeeF = new Epreuve("Épée Femme", 'F', epee);
        Epreuve fleretH = new Epreuve("Fleuret Homme", 'H', fleuret);
        Epreuve fleretF = new Epreuve("Fleuret Femme", 'F', fleuret);
        Epreuve volleyH = new Epreuve("VolleyBall Homme", 'H', volley);
        Epreuve volleyF = new Epreuve("VolleyBall Femme", 'F', volley);
        Epreuve handH = new Epreuve("HandBall Homme", 'H', hand);
        Epreuve handF = new Epreuve("HandBall Femme", 'F', hand);

        /** Initialisation-Création Jeux Olympiques */
        JeuxOlympiques jO = new JeuxOlympiques();

        /** Ajout des épreuves au Jeux Olympiques */
        jO.ajouterEpreuve(brasseH);
        jO.ajouterEpreuve(brasseF);
        jO.ajouterEpreuve(nageH);
        jO.ajouterEpreuve(nageF);
        jO.ajouterEpreuve(relaisH);
        jO.ajouterEpreuve(relaisF);
        jO.ajouterEpreuve(haiesH);
        jO.ajouterEpreuve(haiesF);
        jO.ajouterEpreuve(epeeH);
        jO.ajouterEpreuve(epeeF);
        jO.ajouterEpreuve(fleretH);
        jO.ajouterEpreuve(fleretF);
        jO.ajouterEpreuve(volleyH);
        jO.ajouterEpreuve(volleyF);
        jO.ajouterEpreuve(handH);
        jO.ajouterEpreuve(handF);

        /** Création des Pays */
        Pays japon = new Pays("Japon");
        Pays kenya = new Pays("Kenya");
        Pays allemagne = new Pays("Allemagne");
        Pays brésil = new Pays("Brésil");
        Pays france = new Pays("France");
        Pays chine = new Pays("Chine");
        Pays australie = new Pays("Australie");
        Pays maroc = new Pays("Maroc");
        Pays usa = new Pays("USA");
        Pays turquie = new Pays("Turquie");


        /** Création des athlètes +  Ajouts de résultats */
        Athlete athlete1 = new Athlete("Michel", "Jack", 'M', 10, 2, 15, france, new Equipe("Michel Jack"));
        brasseF.ajouterResultat(athlete1, new Score(10, 1,  athlete1));

        /** Ajout d'athlètes au Jeux Olympiques 
         * A noter que les places sont à titre d'illustration :
         * ici les places sont attribués dans l'ordre d'apparition pour simplifier la création des athlètes qui a été effectué par commande python
        */
        Athlete athlete2 = new Athlete("Nakamura", "Akira", 'M', 4, 3, 20, maroc,  new Equipe("Nakamura Akira"));
        fleretF.ajouterResultat(athlete2, new Score(10, 1,  athlete2));
        Athlete athlete3 = new Athlete("He", "Ling", 'F', 10, 16, 11, australie,  new Equipe("He Ling"));
        epeeH.ajouterResultat(athlete3, new Score(1, 1,  athlete3));
        Athlete athlete4 = new Athlete("Kimura", "Haruto", 'F', 10, 1, 6, allemagne,  new Equipe("Kimura Haruto"));
        fleretH.ajouterResultat(athlete4, new Score(11, 1,  athlete4));
        Athlete athlete5 = new Athlete("Tanaka", "Aoi", 'M', 7, 20, 4, australie,  new Equipe("Tanaka Aoi"));
        haiesF.ajouterResultat(athlete5, new Score(4, 1,  athlete5));
        Athlete athlete6 = new Athlete("Schulze", "Luca", 'F', 8, 17, 15, turquie,  new Equipe("Schulze Luca"));
        relaisH.ajouterResultat(athlete6, new Score(20, 1,  athlete6));
        Athlete athlete7 = new Athlete("He", "Xiang", 'M', 4, 8, 4, france,  new Equipe("He Xiang"));
        fleretH.ajouterResultat(athlete7, new Score(13, 2,  athlete7));
        Athlete athlete8 = new Athlete("Liu", "Xue", 'M', 20, 4, 16, france,  new Equipe("Liu Xue"));
        handH.ajouterResultat(athlete8, new Score(6, 1,  athlete8));
        Athlete athlete9 = new Athlete("Mercier", "Ethan", 'M', 1, 11, 12, allemagne,  new Equipe("Mercier Ethan"));
        relaisF.ajouterResultat(athlete9, new Score(7, 1,  athlete9));
        Athlete athlete10 = new Athlete("Shimizu", "Naoki", 'M', 6, 19, 10, chine,  new Equipe("Shimizu Naoki"));
        epeeF.ajouterResultat(athlete10, new Score(6, 2,  athlete10));
        Athlete athlete11 = new Athlete("Sakai", "Yusuke", 'M', 17, 10, 3, france,  new Equipe("Sakai Yusuke"));
        epeeH.ajouterResultat(athlete11, new Score(16, 2,  athlete11));
        Athlete athlete12 = new Athlete("Muller", "Inès", 'F', 19, 9, 16, turquie,  new Equipe("Muller Inès"));
        fleretH.ajouterResultat(athlete12, new Score(11, 3,  athlete12));
        Athlete athlete13 = new Athlete("Huang", "Guo", 'M', 13, 4, 7, france,  new Equipe("Huang Guo"));
        relaisF.ajouterResultat(athlete13, new Score(16, 2,  athlete13));
        Athlete athlete14 = new Athlete("Ishii", "Asuka", 'M', 13, 10, 11, turquie,  new Equipe("Ishii Asuka"));
        epeeH.ajouterResultat(athlete14, new Score(12, 3,  athlete14));
        Athlete athlete15 = new Athlete("Zhao", "Xue", 'F', 1, 11, 17, japon,  new Equipe("Zhao Xue"));
        fleretF.ajouterResultat(athlete15, new Score(8, 2,  athlete15));
        Athlete athlete16 = new Athlete("Murakami", "Yui", 'F', 17, 13, 3, usa,  new Equipe("Murakami Yui"));
        relaisF.ajouterResultat(athlete16, new Score(3, 3,  athlete16));
        Athlete athlete17 = new Athlete("Robin", "Sarah", 'F', 18, 12, 20, kenya,  new Equipe("Robin Sarah"));
        fleretF.ajouterResultat(athlete17, new Score(17, 3,  athlete17));
        Athlete athlete18 = new Athlete("Zhou", "Liu", 'M', 20, 9, 16, usa,  new Equipe("Zhou Liu"));
        epeeF.ajouterResultat(athlete18, new Score(16, 3,  athlete18));
        Athlete athlete19 = new Athlete("Lin", "Wang", 'F', 14, 14, 12, turquie,  new Equipe("Lin Wang"));
        nageF.ajouterResultat(athlete19, new Score(11, 1,  athlete19));
        Athlete athlete20 = new Athlete("Schulze", "Emma", 'M', 8, 7, 4, brésil,  new Equipe("Schulze Emma"));
        handF.ajouterResultat(athlete20, new Score(16, 1,  athlete20));
        Athlete athlete21 = new Athlete("Murakami", "Ryota", 'F', 17, 3, 18, usa,  new Equipe("Murakami Ryota"));
        epeeF.ajouterResultat(athlete21, new Score(18, 4,  athlete21));
        Athlete athlete22 = new Athlete("Liu", "Wu", 'M', 14, 3, 15, maroc,  new Equipe("Liu Wu"));
        handF.ajouterResultat(athlete22, new Score(17, 2,  athlete22));
        Athlete athlete23 = new Athlete("Watanabe", "Kokoro", 'M', 20, 20, 6, japon,  new Equipe("Watanabe Kokoro"));
        nageH.ajouterResultat(athlete23, new Score(13, 1,  athlete23));
        Athlete athlete24 = new Athlete("Yamaguchi", "Yuna", 'F', 12, 11, 11, maroc,  new Equipe("Yamaguchi Yuna"));
        fleretF.ajouterResultat(athlete24, new Score(13, 4,  athlete24));
        Athlete athlete25 = new Athlete("Zhou", "Wang", 'F', 16, 9, 6, turquie,  new Equipe("Zhou Wang"));
        volleyH.ajouterResultat(athlete25, new Score(20, 1,  athlete25));
        Athlete athlete26 = new Athlete("Sakamoto", "Ren", 'M', 3, 15, 8, maroc,  new Equipe("Sakamoto Ren"));
        brasseF.ajouterResultat(athlete26, new Score(6, 2,  athlete26));
        Athlete athlete27 = new Athlete("Bernard", "Clara", 'M', 5, 6, 15, kenya,  new Equipe("Bernard Clara"));
        nageH.ajouterResultat(athlete27, new Score(13, 2,  athlete27));
        Athlete athlete28 = new Athlete("Nakamura", "Kazuki", 'F', 8, 10, 3, kenya,  new Equipe("Nakamura Kazuki"));
        relaisH.ajouterResultat(athlete28, new Score(5, 2,  athlete28));
        Athlete athlete29 = new Athlete("Guo", "Wang", 'F', 17, 6, 19, kenya,  new Equipe("Guo Wang"));
        brasseH.ajouterResultat(athlete29, new Score(15, 1,  athlete29));
        Athlete athlete30 = new Athlete("Mercier", "Camille", 'F', 12, 4, 12, kenya,  new Equipe("Mercier Camille"));
        fleretF.ajouterResultat(athlete30, new Score(11, 5,  athlete30));
        Athlete athlete31 = new Athlete("Giraud", "Sacha", 'F', 17, 19, 6, allemagne,  new Equipe("Giraud Sacha"));
        handF.ajouterResultat(athlete31, new Score(7, 3,  athlete31));
        Athlete athlete32 = new Athlete("Ogawa", "Yuna", 'M', 8, 12, 8, kenya,  new Equipe("Ogawa Yuna"));
        handF.ajouterResultat(athlete32, new Score(17, 4,  athlete32));
        Athlete athlete33 = new Athlete("Perez", "Tom", 'M', 14, 11, 13, turquie,  new Equipe("Perez Tom"));
        haiesH.ajouterResultat(athlete33, new Score(3, 1,  athlete33));

        /** Création d'une équipe + Ajout de résultats */
        Equipe equipe1 = new Equipe("Equipe Number ONE");
        Athlete athlete40 = new Athlete("Bernard", "Gabriel", 'M', 6, 10, 8, france,  equipe1);
        handH.ajouterResultat(athlete40, new Score(11, 1,  athlete40));
        equipe1.ajouteAthlete(athlete40);
        Athlete athlete41 = new Athlete("Durand", "Paul", 'M', 16, 11, 10, france,  equipe1);
        handH.ajouterResultat(athlete41, new Score(16, 1,  athlete41));
        equipe1.ajouteAthlete(athlete41);
        Athlete athlete42 = new Athlete("Faure", "Mathis", 'M', 11, 17, 7, france,  equipe1);
        handH.ajouterResultat(athlete42, new Score(14, 1,  athlete42));
        equipe1.ajouteAthlete(athlete42);
        Athlete athlete43 = new Athlete("Fontaine", "Nathan", 'M', 17, 10, 2, france,  equipe1);
        handH.ajouterResultat(athlete43, new Score(6, 1,  athlete43));
        equipe1.ajouteAthlete(athlete43);
        Athlete athlete44 = new Athlete("Morel", "Camille", 'M', 3, 11, 4, france,  equipe1);
        handH.ajouterResultat(athlete44, new Score(10, 1,  athlete44));
        equipe1.ajouteAthlete(athlete44);
        Athlete athlete45 = new Athlete("Mercier", "Emma", 'M', 19, 19, 12, france,  equipe1);
        handH.ajouterResultat(athlete45, new Score(10, 1,  athlete45));
        equipe1.ajouteAthlete(athlete45);
        Athlete athlete46 = new Athlete("Thomas", "Juliette", 'M', 3, 10, 15, france,  equipe1);
        handH.ajouterResultat(athlete46, new Score(18, 1,  athlete46));
        equipe1.ajouteAthlete(athlete46);

        Equipe equipe2 = new Equipe("Equipe Number TWO");
        Athlete athlete34 = new Athlete("Huang", "Xiang", 'H', 6, 13, 17, chine,  equipe2);
        volleyH.ajouterResultat(athlete34, new Score(8, 1,  athlete34));
        equipe2.ajouteAthlete(athlete34);
        Athlete athlete35 = new Athlete("Yang", "Guo", 'H', 17, 11, 13, chine,  equipe2);
        volleyH.ajouterResultat(athlete35, new Score(13, 1,  athlete35));
        equipe2.ajouteAthlete(athlete35);
        Athlete athlete36 = new Athlete("Wang", "Shuang", 'H', 4, 5, 18, chine,  equipe2);
        volleyH.ajouterResultat(athlete36, new Score(20, 1,  athlete36));
        equipe2.ajouteAthlete(athlete36);
        Athlete athlete37 = new Athlete("Gao", "Lan", 'H', 18, 1, 19, chine,  equipe2);
        volleyH.ajouterResultat(athlete37, new Score(2, 1,  athlete37));
        equipe2.ajouteAthlete(athlete37);
        Athlete athlete38 = new Athlete("Zhao", "Xiang", 'H', 1, 11, 4, chine,  equipe2);
        volleyH.ajouterResultat(athlete38, new Score(16, 1,  athlete38));
        equipe2.ajouteAthlete(athlete38);
        Athlete athlete39 = new Athlete("Ma", "Jing", 'H', 13, 17, 16, chine,  equipe2);
        volleyH.ajouterResultat(athlete39, new Score(7, 2,  athlete39));
        equipe2.ajouteAthlete(athlete39);


        /** Ajout d'une équipe et d'athlètes au Jeux Olympiques */
        jO.ajouterAthlete(athlete1);
        jO.ajouterAthlete(athlete2);
        jO.ajouterAthlete(athlete3);
        jO.ajouterAthlete(athlete4);
        jO.ajouterAthlete(athlete5);
        jO.ajouterAthlete(athlete6);
        jO.ajouterAthlete(athlete7);
        jO.ajouterAthlete(athlete8);
        jO.ajouterAthlete(athlete9);
        jO.ajouterAthlete(athlete10);
        jO.ajouterAthlete(athlete11);
        jO.ajouterAthlete(athlete12);
        jO.ajouterAthlete(athlete13);
        jO.ajouterAthlete(athlete14);
        jO.ajouterAthlete(athlete15);
        jO.ajouterAthlete(athlete16);
        jO.ajouterAthlete(athlete17);
        jO.ajouterAthlete(athlete18);
        jO.ajouterAthlete(athlete19);
        jO.ajouterAthlete(athlete20);
        jO.ajouterAthlete(athlete21);
        jO.ajouterAthlete(athlete22);
        jO.ajouterAthlete(athlete23);
        jO.ajouterAthlete(athlete24);
        jO.ajouterAthlete(athlete25);
        jO.ajouterAthlete(athlete26);
        jO.ajouterAthlete(athlete27);
        jO.ajouterAthlete(athlete28);
        jO.ajouterAthlete(athlete29);
        jO.ajouterAthlete(athlete30);
        jO.ajouterAthlete(athlete31);
        jO.ajouterAthlete(athlete32);
        jO.ajouterAthlete(athlete33);
        jO.ajouterAthlete(athlete34);
        jO.ajouterAthlete(athlete35);
        jO.ajouterAthlete(athlete36);
        jO.ajouterAthlete(athlete37);
        jO.ajouterAthlete(athlete38);
        jO.ajouterAthlete(athlete39);
        jO.ajouterAthlete(athlete40);
        jO.ajouterAthlete(athlete41);
        jO.ajouterAthlete(athlete42);
        jO.ajouterAthlete(athlete43);
        jO.ajouterAthlete(athlete44);
        jO.ajouterAthlete(athlete45);
        jO.ajouterAthlete(athlete46);


        jO.ajouterEquipe(equipe1);
        jO.ajouterEquipe(equipe2);

        /** Affichages des athlètes */
        System.out.println(System.lineSeparator() + "Affichage des athlètes des JO : " + System.lineSeparator());
        System.out.println(jO.getLesAthletes());

        /** Affichages des équipes */
        System.out.println(System.lineSeparator() + "Affichage des équipes des JO : " + System.lineSeparator());
        System.out.println(jO.getLesEquipes());

        /** Affichages des épreuves */
        System.out.println(System.lineSeparator() + "Affichage des épreuves au JO : " + System.lineSeparator());
        System.out.println(jO.getLesEpreuves());

        /** Affichages des pays */
        System.out.println(System.lineSeparator() + "Affichage des pays au JO : " + System.lineSeparator());
        System.out.println(jO.getLesPays());

        /** Classement selon médailles des athlètes */
        System.out.println(System.lineSeparator() + "Affichage classement selon médailles au JO : " + System.lineSeparator());


        /** Classement selon résultat Athlètes */
        System.out.println(System.lineSeparator() + "Affichage classement selon résultat total des Athlètes au JO : " + System.lineSeparator());
        List<Athlete> listeTrieeA = new ArrayList<>();
        listeTrieeA.addAll(jO.getLesAthletes());
        Collections.sort(listeTrieeA);
        System.out.println(listeTrieeA);

        /** Classement selon résultat Equipe */
        System.out.println(System.lineSeparator() + "Affichage classement selon résultat total des équipes au JO : " + System.lineSeparator());
        List<Equipe> listeTrieeE = new ArrayList<>();
        listeTrieeE.addAll(jO.getLesEquipes());
        Collections.sort(listeTrieeE);
        System.out.println(listeTrieeE + System.lineSeparator());

        /** Connaitre le nombre de médailles d'un athlète */
        System.out.println(System.lineSeparator() + "Affichage du nombre de médailles d'un athlète : " + System.lineSeparator());
        System.out.println("Nombre de médailles d'or : " + athlete10.getNbOr());
        System.out.println("Nombre de médailles d'argent : " + athlete10.getNbArgent());
        System.out.println("Nombre de médailles de bronze : " + athlete10.getNbBronze());
    }
}

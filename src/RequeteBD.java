package src;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class RequeteBD {
    ConnexionMySQL laConnexion;
	Statement st;
	public RequeteBD(ConnexionMySQL laConnexion){
		this.laConnexion=laConnexion;
    }

    public Integer getMaxId(String table) throws SQLException{
        if (table.equals("JOPAYS")){return null;}
        int maxId = 0;
        this.st = this.laConnexion.createStatement();
        System.out.println("SELECT * FROM "+table);
        ResultSet rs = st.executeQuery("SELECT * FROM "+table);
        while (rs.next()){
            System.out.println(rs.getInt(1));
            if (rs.getInt(1)>maxId){
                maxId = rs.getInt(1);
            }
        }
        rs.close();
        return maxId+1;
    }

    public ArrayList<Sport> getSport() throws SQLException{
        ArrayList<Sport> listeS = new ArrayList<>();
        this.st = this.laConnexion.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM JOSPORT");
        while (rs.next()){
            if (rs.getString("nomSport").equals("Athletisme")){listeS.add(new Athletisme(rs.getInt("distance")));}
            else if (rs.getString("nomSport").equals("Escrime")){listeS.add(new Escrime(rs.getString("arme")));}
            else if (rs.getString("nomSport").equals("Handball")){listeS.add(new HandBall());}
            else if (rs.getString("nomSport").equals("Natation")){listeS.add(new Natation(rs.getInt("distance")));}
            else if (rs.getString("nomSport").equals("Volleyball")){listeS.add(new VolleyBall());}
        }
        rs.close();
        return listeS;
    }

    public ArrayList<Athlete> classementAthletes() throws SQLException{
        ArrayList<Athlete> listeA = new ArrayList<>();
        this.st = this.laConnexion.createStatement();
        ResultSet rs = st.executeQuery("SELECT nomPays,nomEquipe,forceA,agiliteA,enduranceA,sexeA,nomA,prenomA,nbOrA,nbArgentA,nbBronzeA FROM JOATHLETE NATURAL JOIN JOEQUIPE");
        while(rs.next()){
            listeA.add(new Athlete(rs.getString("nomA"), rs.getString("prenomA"), rs.getString("sexeA").charAt(0), rs.getInt("forceA"), rs.getInt("agiliteA"), rs.getInt("enduranceA"), new Pays(rs.getString("nomPays")), new Equipe(rs.getString("nomEquipe")), rs.getInt("nbOrA"), rs.getInt("nbArgentA"),rs.getInt("nbBronzeA")));
        }
        rs.close();
        Collections.sort(listeA,new ComparatorMedaillesParticipant());
        return listeA;
    }

    public ArrayList<Pays> classementPays() throws SQLException{
        int i = 0;
        ArrayList<Pays> listeP = new ArrayList<>();
        this.st = this.laConnexion.createStatement();
        ResultSet rs1 = st.executeQuery("SELECT nomPays FROM JOPAYS");
        while (rs1.next()){
            listeP.add(new Pays(rs1.getString("nomPays")));
            System.out.println(listeP);
            System.out.println("SELECT nomPays,nomEquipe,forceA,agiliteA,enduranceA,sexeA,nomA,prenomA,nbOrA,nbArgentA,nbBronzeA FROM JOATHLETE NATURAL JOIN JOEQUIPE WHERE nomPays = \""+ rs1.getString("nomPays")+"\"");
            ResultSet rs2 = st.executeQuery("SELECT nomEquipe,forceA,agiliteA,enduranceA,sexeA,nomA,prenomA,nbOrA,nbArgentA,nbBronzeA FROM JOATHLETE NATURAL JOIN JOEQUIPE NATURAL JOIN JOPAYS WHERE nomPays = \""+ rs1.getString("nomPays")+"\"");
            while (rs2.next()){
                System.out.println("1");
                listeP.get(i).ajouterAthlete(new Athlete(rs2.getString("nomA"), rs2.getString("prenomA"), rs2.getString("sexeA").charAt(0), rs2.getInt("forceA"), rs2.getInt("agiliteA"), rs2.getInt("enduranceA"), listeP.get(i), new Equipe(rs1.getString("nomPays")), rs2.getInt("nbOrA"), rs2.getInt("nbArgentA"),rs2.getInt("nbBronzeA")));
                for (int j = 0; j<rs2.getInt("nbOrA");j++){
                    listeP.get(i).setPlacement(1);          
                }
                for (int k = 0; k<rs2.getInt("nbArgentA");k++){
                    listeP.get(i).setPlacement(2);
                }
                for (int l = 0; l<rs2.getInt("nbBronzeA");l++){
                    listeP.get(i).setPlacement(3);
                }
                System.out.println("3");
            }
            System.out.println("test");
            rs2.close();
            i++;
        }
        rs1.close();
        Collections.sort(listeP);
        return listeP;
    }

    public ArrayList<Equipe> classementEquipe() throws SQLException{
        int i = 0;
        ArrayList<Equipe> listeE = new ArrayList<>();
        this.st = this.laConnexion.createStatement();
        ResultSet rs1 = st.executeQuery("SELECT idEquipe, nomEquipe FROM JOEQUIPE");
        while (rs1.next()){
            listeE.add(new Equipe(rs1.getString("nomEquipe")));
            ResultSet rs2 = st.executeQuery("SELECT nomPays,nomEquipe,forceA,agiliteA,enduranceA,sexeA,nomA,prenomA,nbOrA,nbArgentA,nbBronzeA FROM JOATHLETE NATURAL JOIN JOEQUIPE WHERE idEquipe = "+rs1.getInt("idEquipe"));
            while (rs2.next()){
                listeE.get(i).ajouteAthlete(new Athlete(rs2.getString("nomA"), rs2.getString("prenomA"), rs2.getString("sexeA").charAt(0), rs2.getInt("forceA"), rs2.getInt("agiliteA"), rs2.getInt("enduranceA"), new Pays(rs2.getString("nomPays")), listeE.get(i), rs2.getInt("nbOrA"), rs2.getInt("nbArgentA"),rs2.getInt("nbBronzeA")));
                for (int j = 0; j<rs2.getInt("nbOrA");j++){
                    listeE.get(i).setPlacement(1);
                }
                for (int k = 0; k<rs2.getInt("nbArgentA");k++){
                    listeE.get(i).setPlacement(2);
                }
                for (int l = 0; l<rs2.getInt("nbBronzeA");l++){
                    listeE.get(i).setPlacement(3);
                }
            }
            rs2.close();
            i++;
        }
        rs1.close();
        Collections.sort(listeE, new ComparatorMedaillesParticipant());
        return listeE;
    }

    public void creerPays(String nomPays) throws SQLException{
        ResultSet testPays = st.executeQuery("SELECT count(*) nb FROM JOPAYS WHERE nomPays = \""+nomPays+"\"");
        while (testPays.next()) {
            if (testPays.getInt("nb")==0){
                System.out.println("INSERT INTO JOPAYS VALUES (\""+nomPays+"\")");
                st.executeQuery("INSERT INTO JOPAYS VALUES (\""+nomPays+"\")");
            }
        }
        testPays.close();
    }

    public int creerEquipe(Equipe equipe) throws SQLException{
        ResultSet testEquipe =st.executeQuery("SELECT * FROM JOEQUIPE WHERE nomEquipe = \""+equipe.obtenirNom()+"\" AND nbOrEquipe = "+equipe.getNbOr()+" AND nbArgentEquipe = "+ equipe.getNbArgent()+" AND nbBronzeEquipe = "+equipe.getNbBronze());
        while (testEquipe.next()){
            return testEquipe.getInt("idEquipe");     
        }
        testEquipe.close();
        System.out.println("test");
        int idDeEquipe = getMaxId("JOEQUIPE");
        System.out.println("INSERT INTO JOEQUIPE VALUES ("+idDeEquipe+",\""+equipe.obtenirNom()+"\")");
        st.executeQuery("INSERT INTO JOEQUIPE VALUES ("+idDeEquipe+",\""+equipe.obtenirNom()+"\","+equipe.getNbOr()+","+ equipe.getNbArgent()+","+equipe.getNbBronze()+")");
        return idDeEquipe;
    }

    public int creerAthlete(Athlete athlete) throws SQLException{
        this.st = this.laConnexion.createStatement();
        String nomDuPays = athlete.getPaysAthlete().getNomPays();
        System.out.println(nomDuPays);
        int idDeEquipe = creerEquipe(athlete.getEquipe());
        System.out.println(idDeEquipe);
        int idAthlete = getMaxId("JOATHLETE");
        System.out.println(idAthlete);
        creerPays(nomDuPays);
        creerEquipe(athlete.getEquipe());
        ResultSet testAthlete = st.executeQuery("SELECT * FROM JOATHLETE WHERE nomA = \""+athlete.getNom()+"\" AND prenomA = \""+athlete.getPrenom()+"\" AND idEquipe = "+ idDeEquipe+" AND nomPays = \""+nomDuPays+"\"");
        while (testAthlete.next()){
            testAthlete.close();
            return testAthlete.getInt("idA");
        }
        testAthlete.close();
        st.executeQuery("INSERT INTO JOATHLETE VALUES ("+getMaxId("JOATHLETE")+",\""+athlete.getNom()+"\",\""+athlete.getPrenom()+"\",'"+athlete.getSexeAthlete()+"',"+athlete.getForce()+","+athlete.getAgilite()+","+athlete.getEndurance()+","+athlete.getNbOr()+","+athlete.getNbArgent()+","+athlete.getNbBronze()+","+idDeEquipe+",\""+nomDuPays+"\")");
        return idAthlete;

    }

    public int creerSport(Sport sport) throws SQLException{
        int idSport = getMaxId("JOSPORT");
        String nomSport = sport.getNomSport();
        Integer nbAthlete = sport.getNbMembresEquipe();
        Integer distance = null;
        String arme = null;
        this.st = this.laConnexion.createStatement();
        if (sport instanceof Natation){
            Natation sport2 = (Natation) sport;
            distance = sport2.getDistance();
        }
        else if (sport instanceof Athletisme){
            Athletisme sport2 = (Athletisme) sport;
            sport2.getDistance();
        }
        else if (sport instanceof Escrime){
            Escrime sport2 = (Escrime) sport;
            arme = sport2.getArme();
        }
        if (arme == null){
            ResultSet testSport = st.executeQuery("SELECT * FROM JOSPORT WHERE nomSport = \""+nomSport+"\" AND nbMembresEquipe = "+ nbAthlete+ " AND distance = "+distance+" AND arme = null");
            while (testSport.next()){
                testSport.close();
                return testSport.getInt("idS");
            }
            testSport.close();
            st.executeQuery("INSERT INTO JOSPORT VALUES ("+idSport+",\""+nomSport+"\","+nbAthlete+","+distance+","+null+")");
            return idSport;
        }
        else{
            ResultSet testSport = st.executeQuery("SELECT * FROM JOSPORT WHERE nomSport = \""+nomSport+"\" AND nbMembresEquipe = "+ nbAthlete+ " AND distance = "+distance+" AND arme = \""+arme+"\"");
            while (testSport.next()){
                testSport.close();
                return testSport.getInt("idS");
            }
            testSport.close();
            st.executeQuery("INSERT INTO JOSPORT VALUES ("+idSport+",\""+nomSport+"\","+nbAthlete+","+distance+",\""+arme+"\")");
            return idSport;
        }
    }

    public int creerEpreuve(Epreuve epreuve) throws SQLException{
        this.st = this.laConnexion.createStatement();
        int idEpreuve = getMaxId("JOEPREUVE");
        int idSport = creerSport(epreuve.getSport());
        ResultSet testEpreuve = st.executeQuery("SELECT * FROM JOEPREUVE WHERE nomEpreuve = \""+epreuve.getNomEpreuve()+"\" AND genreEpreuve = \'"+epreuve.getGenre()+"\' AND idS = "+ idSport);
        while (testEpreuve.next()){
            testEpreuve.close();
            return testEpreuve.getInt("idEpreuve");
        }
        testEpreuve.close();
        st.executeQuery("INSERT INTO JOEPREUVE VALUES ("+idEpreuve+", \""+epreuve.getNomEpreuve()+"\", \'"+epreuve.getGenre()+"\',"+idSport+")");
        return idEpreuve;
    }   

    public void creerParticipantEpreuve(Participant participant, Epreuve epreuve) throws SQLException{
        boolean estDejaPresent = false;
        this.st = this.laConnexion.createStatement();
        int idEpreuve = creerEpreuve(epreuve); 
        if (participant instanceof Athlete){
            Athlete a1 = (Athlete) participant;
            int idAthlete = creerAthlete(a1);
            ResultSet testParticiper = st.executeQuery("SELECT * FROM JOPARTICIPER WHERE idEpreuve = "+idEpreuve+" AND idA = "+idAthlete);
            while (testParticiper.next()) {
                estDejaPresent = true;
            }
            testParticiper.close();
            if (!estDejaPresent){
                st.executeQuery("INSERT INTO JOPARTICIPER VALUES("+idEpreuve+","+idAthlete+")");
            }
        }
        else{
            Equipe e1 = (Equipe) participant;
            int idEquipe = creerEquipe(e1);
            ResultSet testParticiper = st.executeQuery("SELECT * FROM JOACCUEILLIR WHERE idEpreuve = "+idEpreuve+" AND idA = "+idEquipe);
            while (testParticiper.next()) {
                estDejaPresent = true;
            }
            testParticiper.close();
            if (!estDejaPresent){
                st.executeQuery("INSERT INTO JOACCUEILLIR VALUES("+idEpreuve+","+idEquipe+")");
            }
        }
    }

    public int creerScore(Score score) throws SQLException{
        int idAthlete = creerAthlete(score.getAthlete());
        int idEpreuve = creerEpreuve(score.getEpreuve());
        int idScore = getMaxId("JOSCORE");
        this.st = this.laConnexion.createStatement();
        ResultSet testParticiper = st.executeQuery("SELECT * FROM JOSCORE WHERE positionScore = "+score.getPlacement()+" AND score = "+score.getScore()+" AND idA = "+idAthlete+" AND idEpreuve = "+idEpreuve);
        while (testParticiper.next()) {
            ResultSet rs = st.executeQuery("SELECT * FROM ATHLETE WHERE idA = "+testParticiper.getInt("idA"));
            while (rs.next()){
                modifierAthlete(new Athlete(rs.getString("nomA"), rs.getString("prenomA"), rs.getString("sexeA").charAt(0), rs.getInt("forceA"), rs.getInt("agiliteA"), rs.getInt("enduranceA"), score.getAthlete().getPaysAthlete(), score.getAthlete().getEquipe()));
            }
            return testParticiper.getInt("idScore");
        }
        testParticiper.close();
        return idScore;
    }

    public void enleverAthlete(int id) throws SQLException{
        this.st = this.laConnexion.createStatement();
        st.executeQuery("DELETE FROM JOPARTICIPER WHERE idA = "+id);
        System.out.println("1");
        st.executeQuery("DELETE FROM JOSCORE WHERE idA = "+id);
        System.out.println("2");
        st.executeQuery("DELETE FROM JOATHLETE WHERE idA = "+ id);
        System.out.println("3");
    }

    public void enleverEquipe(Equipe equipe) throws SQLException{
        this.st = this.laConnexion.createStatement();
        int idEquipe = creerEquipe(equipe);
        for (Athlete athlete:equipe.getMembres()){
            enleverAthlete(creerAthlete(athlete));
        }
        st.executeQuery("DELETE FROM JOACCUEILLIR WHERE idEquipe = "+idEquipe);
        st.executeQuery("DELETE FROM JOEQUIPE WHERE idEquipe = "+idEquipe);
    }

    public void enleverEpreuve(Epreuve epreuve) throws SQLException{
        this.st = this.laConnexion.createStatement();
        int idEpreuve = creerEpreuve(epreuve);
        st.executeQuery("DELETE FROM JOACCUEILLIR WHERE idEpreuve = "+idEpreuve);
        st.executeQuery("DELETE FROM JOSCORE WHERE idEpreuve = "+idEpreuve);
        st.executeQuery("DELETE FROM JOEPREUVE WHERE idEpreuve = "+idEpreuve);
    }

    public void enleverScore(Score score) throws SQLException{
        this.st = this.laConnexion.createStatement();
        int idScore = creerScore(score);
        int idA = creerAthlete(score.getAthlete());
        if (score.getPlacement() == 1){
            st.executeQuery("UPDATE ATHLETE SET nbOrA = nbOrA-1 WHERE idA = "+idA);
        }
        else if (score.getPlacement() == 2){
            st.executeQuery("UPDATE ATHLETE SET nbOrA = nbArgentA-1 WHERE idA = "+idA);
        }
        else if (score.getPlacement() == 3){
            st.executeQuery("UPDATE ATHLETE SET nbOrA = nbBronzeA-1 WHERE idA = "+idA);
        }
        st.executeQuery("DELETE FROM JOSCORE WHERE idScore = "+idScore);
    }

    public void enleverSport(Sport sport) throws SQLException{
        this.st = this.laConnexion.createStatement();
        int idSport = creerSport(sport);
        st.executeQuery("DELETE FROM JOEPREUVE WHERE idS = "+idSport);
        st.executeQuery("DELETE FROM JOSPORT WHERE idS = "+idSport);
    }

    public void modifierAthlete(Athlete a2) throws SQLException{
        this.st = this.laConnexion.createStatement();
        int idA = creerAthlete(a2);
        int idDeEquipe = creerEquipe(a2.getEquipe());
        enleverAthlete(creerAthlete(a2));
        st.executeQuery("INSERT INTO JOATHLETE VALUES ("+idA+",\""+a2.getNom()+"\",\""+a2.getPrenom()+"\",\""+a2.getSexeAthlete()+"\","+a2.getNbOr()+","+a2.getNbArgent()+","+a2.getNbBronze()+","+idDeEquipe+",\""+a2.getPaysAthlete().getNomPays()+"\")");
    }
}

/**
 * La classe Athlete représente un pays.
 * Elle possède un attribut qui est le nom du pays.
 */
public class Athlete implements Participant, Comparable<Athlete> {
    
    private final String nomAthlete;
    private final String prenomAthlete;
    private final char sexeAthlete;
    
    private int force;
    private int agilite;
    private int endurance;
    private int nbOr = 0;
    private int nbArgent = 0;
    private int nbBronze = 0;

    private double score;

    private Pays paysAthlete;

    private Equipe equipe;

    /**
     * Construit une instance de Pays avec le nom spécifié.
     * @param nomP le nom du pays
     */
    public Athlete(String nomA, String prenomA, char sexeA, int force, int agilite, int endurance, Pays paysA, Equipe equipe) {
        this.nomAthlete = nomA;
        this.prenomAthlete = prenomA;
        this.sexeAthlete = sexeA;
        this.force = force;
        this.agilite = agilite;
        this.endurance = endurance;
        this.paysAthlete = paysA;
        this.equipe = equipe;
    }
    @Override
    public int getNbOr(){
        return this.nbOr;
    }
    @Override
    public int getNbArgent(){
        return this.nbArgent;
    }
    @Override
    public int getNbBronze(){
        return this.nbBronze;
    }

    /**
     * Retourne le nom et prénom de l'athlète.
     * @return le nom et prénom.
     */
    @Override
    public String obtenirNom() {
        return this.nomAthlete + " " + this.prenomAthlete;
    }

    @Override
    public double getScore(){
        return this.score;
    }

    @Override
    public void setScore(double score){
        this.score += score;
    }

    @Override
    public void setPlacement(int place){
        if (place == 1) {
            this.nbOr++;
            equipe.setPlacement(1);
            paysAthlete.setPlacement(1);
        }
        if (place == 2) {
            this.nbArgent++;
            equipe.setPlacement(2);
            paysAthlete.setPlacement(2);
        }
        if (place == 3) {
            this.nbBronze++;
            equipe.setPlacement(3);
            paysAthlete.setPlacement(3);
        }
    }
    
    /**
     * Retourne le sexe de l'athlète.
     * @return le genre.
     */
    public char getSexeAthlete() {
        return this.sexeAthlete;
    }

    /**
     * Retourne la force de l'athlète.
     * @return sa force.
     */
    public int getForce() {
        return this.force;
    }

    /**
     * Modifie la force de l'athlète.
     */
    public void setForce(int force) {
        this.force = force;
    }

    /**
     * Retourne l'agilité de l'athlète.
     * @return son agilité.
     */
    public int getAgilite() {
        return this.agilite;
    }

    /**
     * Modifie l'agilité de l'athlète.
     */
    public void setAgilite(int agilite) {
        this.agilite = agilite;
    }

    /**
     * Retourne l'endurance de l'athlète.
     * @return son endurance.
     */
    public int getEndurance() {
        return this.endurance;
    }

    /**
     * Modifie l'endurance de l'athlète.
     */
    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    /**
     * Retourne le pays de l'athlète.
     * @return son pays.
     */
    public Pays getPaysAthlete() {
        return this.paysAthlete;
    }

    /**
     * Modifie le pays de l'athlète.
     */
    public void setPaysAthlete(Pays paysAthlete) {
        this.paysAthlete = paysAthlete;
    }

    public Equipe getEquipe() {return this.equipe;}

    /**
     * Retourne un affichage indiquant le nombre de médailles de l'athlète
     * @return une phrase donnant le nb de médailles de l'athlète
     */
    public String getMedaillesAthlete() {
        return this.obtenirNom() + " a : " + System.lineSeparator() + "- " + this.nbOr + " médaille(s) d'or" + System.lineSeparator() + "- " + this.nbArgent + " médaille(s) d'argent" + System.lineSeparator() + "- " + this.nbBronze + " médaille(s) de bronze" ;
    }

    @Override
    public double participer(Epreuve epreuve) {
        Score unScore = epreuve.getScore(this);
        return unScore.getScore();
    }

    @Override
    public int getPlacement(Epreuve epreuve) {
        Score unScore = epreuve.getScore(this);
        return unScore.getPlacement();
    }

    @Override
    public String toString() {
        return obtenirNom();
    }

    @Override
    public int compareTo(Athlete unAthlete) {
        return Double.compare(this.score, unAthlete.score) * -1;
    }

@Override
public boolean equals(Object o){
    if (o == null){return false;}
    if (o==this){return true;}
    if (!(o instanceof Athlete)){return false;}
    Athlete a1 = (Athlete) o;
    return this.prenomAthlete.equals(a1.prenomAthlete) && this.nomAthlete.equals(a1.prenomAthlete) && this.paysAthlete.equals(a1.paysAthlete);
}
    
}

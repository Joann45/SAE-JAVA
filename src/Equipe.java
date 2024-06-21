package src;
import java.util.HashSet;
import java.util.Set;

public class Equipe implements Participant, Comparable<Equipe>{
    
    private final String nomEquipe;
    private double score;
    private int nbOr = 0;
    private int nbArgent = 0;
    private int nbBronze = 0;
    private Set<Athlete> lesMembres;
    private Set<Epreuve> lesEpreuves;
    
    public Equipe(String nomEquipe){
        this.nomEquipe = nomEquipe;
        this.lesMembres = new HashSet<>();
        this.lesEpreuves = new HashSet<>();
    }

    public void ajouteAthlete(Athlete athlete){
        if (!this.lesMembres.isEmpty()) {
            Pays paysEquipe = getPaysEquipe();
            if (athlete.getPaysAthlete().equals(paysEquipe)) {
                this.lesMembres.add(athlete);
            }
            else {System.out.println("L'athlète qui a voulu être ajouté n'est pas du même pays que les autres athlètes de l'équipe !");}
        }
        else {this.lesMembres.add(athlete);}
    }

    public void enleverAthlete(Athlete athlete){
        this.lesMembres.remove(athlete);
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
        if (place == 1) {this.nbOr++;}
        if (place == 2) {this.nbArgent++;}
        if (place == 3) {this.nbBronze++;}
    }

    public Pays getPaysEquipe() {
        for (Athlete athlete: this.lesMembres){
            return athlete.getPaysAthlete();
        }
        return null;
    }

    public Set<Athlete> getMembres(){
        return this.lesMembres;
    }

    public void ajouteEpreuve(Epreuve epreuve){
        this.lesEpreuves.add(epreuve);
    }

    @Override
    public String obtenirNom(){
        return this.nomEquipe;
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
    public String toString(){
        String res = "Nom de l'équipe: "+this.nomEquipe + System.lineSeparator();
        res += "Nationalité de l'équipe: "+getPaysEquipe();
        res += "Liste des athlètes: ";  
        for (Athlete athlete: this.lesMembres){
            res += athlete + ", ";
        }
        res += System.lineSeparator();
        return res;
    }

    @Override
    public int compareTo(Equipe uneEquipe) {
        return Double.compare(this.score, uneEquipe.score) * -1;
    }
}

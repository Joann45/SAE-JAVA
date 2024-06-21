import java.util.HashSet;
import java.util.Set;

/**
 * La classe Pays représente un pays.
 * Elle possède un attribut qui est le nom du pays.
 */
public class Pays implements Comparable<Pays>{
    
    private final String nomPays;
    private int nbOr = 0;
    private int nbArgent = 0;
    private int nbBronze = 0;
    private Set<Athlete> lesAthletes;

    /**
     * Construit une instance de Pays avec le nom spécifié.
     * @param nomP le nom du pays
     */
    public Pays(String nomP) {
        this.nomPays = nomP;
        this.lesAthletes = new HashSet<>();
    }

    public void ajouterAthlete(Athlete athlete){
        this.lesAthletes.add(athlete);
    }

    public void retirerAthlete(Athlete athlete){
        this.lesAthletes.remove(athlete);
    }

    public void setPlacement(int place){
        if (place == 1) {this.nbOr++;}
        if (place == 2) {this.nbArgent++;}
        if (place == 3) {this.nbBronze++;}
    }

    public int getNbOr(){
        return this.nbOr;
    }

    public int getNbArgent(){
        return this.nbArgent;
    }

    public int getNbBronze(){
        return this.nbBronze;
    }

    /**
     * Retourne le nom du pays.
     * @return le nom.
     */
    public String getNomPays() {
        return this.nomPays;
    }

    @Override
    public String toString() {
        return this.nomPays;
    }

    @Override
    public boolean equals(Object o){
        if (o == null){
            return false;
        }
        if (o == this){
            return true;
        }
        if (! (o instanceof Pays)){
            return false;
        }
        Pays p = (Pays) o;
        return this.nomPays.equals(p.getNomPays());
    }

    @Override
    public int hashCode(){
        return this.nomPays.hashCode();
    }

    @Override
    public int compareTo(Pays p){
        if (Integer.compare(this.nbOr, p.nbOr)!=0){return Integer.compare(this.nbOr, p.nbOr);}
        if (Integer.compare(this.nbArgent, p.nbArgent)!=0){return Integer.compare(this.nbArgent, p.nbArgent);}
        return Integer.compare(this.nbBronze, p.nbBronze);
    }
}

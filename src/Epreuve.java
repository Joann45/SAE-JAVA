package src;
import java.util.HashMap;
import java.util.Map;

public class Epreuve implements Comparable<Epreuve> {
    
    private char genre;
    private String nomEpreuve;

    private Sport sport;

    private double score;

    private Map<Participant, Score> equipeResultat;

    /**
     * Construit une instance d'Epreuve
     * @param nomE le nom de l'épreuve
     * @param genre le genre de l'épreuve ('M' pour masculin ou 'F' pour féminin)
     * @param sport le sport concerné par l'épreuve
     */
    public Epreuve(String nomE, char genre, Sport sport) {
        this.nomEpreuve = nomE;
        this.genre = genre;
        this.sport = sport;
        this.equipeResultat = new HashMap<>();
    }

    public String getNomEpreuve() {
        return this.nomEpreuve;
    }

    public char getGenre() {
        return this.genre;
    }

    public Sport getSport() {
        return this.sport;
    }

    /**
     * Ajoute un résultat d'une équipe à l'épreuve
     * @param equipe une équipe
     * @param resultat son résultat
     */
    public void ajouterResultat(Participant participant, Score resultat) {
        this.equipeResultat.put(participant, resultat);
        this.score += resultat.getScore();
    }

    /**
     * Modifie le résultat d'une équipe à l'épreuve
     * @param equipe une équipe
     * @param ancienScore son ancien score
     * @param newRes son nouveau score
     */
    public void modifierResultat(Participant participant, Score ancienScore, Score newRes) {
        this.equipeResultat.replace(participant, ancienScore, newRes);
        this.score = this.score - ancienScore.getScore() + newRes.getScore();
    }

    /**
     * Retire le résultat d'une équipe à l'épreuve
     * @param equipe une équipe
     * @param res son résultat
     */
    public void retirerResultat(Participant participant, Score res) {
        this.equipeResultat.remove(participant, res);
        this.score -= res.getScore();
    }
    
    /**
     * Retourne le score d'une équipe à l'épreuve
     * @param equipe une équipe
     * @return un Score qu'a réalisé l'équipe dans cet épreuve.
     */
    public Score getScore(Participant participant) {
        return this.equipeResultat.get(participant);
    }

    @Override
    public String toString(){
        String res = "Nom de l'épreuve: "+ this.nomEpreuve + System.lineSeparator();
        res += "Genre de l'épreuve: " + this.genre + System.lineSeparator();
        res += "Sport :" + this.sport + System.lineSeparator();
        res += "Les scores de chaque participant: ";
        for (Map.Entry<Participant, Score> kv : this.equipeResultat.entrySet()){
            res += "("+kv.getKey()+", "+ kv.getValue()+")";
        }
        res += System.lineSeparator();
        return res;
    }
    
    @Override
    public int compareTo(Epreuve uneEpreuve) {
        return Double.compare(this.score, uneEpreuve.score) * -1;
    }

}

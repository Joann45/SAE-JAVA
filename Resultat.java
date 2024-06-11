/**
*@author Joann
*/


public class Resultat {
    private int score;
    private Epreuve epreuve;

    public Resultat(int score, Epreuve epreuve) {
        this.score = score;
        this.epreuve = epreuve;
    }
    
    public int getScore() {
        return score;
    }
    
    public Epreuve getEpreuve() {
        return epreuve;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }

    @Override
    public String toString() {
        return "score = " + score;
    }
    
}

public class Resultat {
    private int score;
    private int place;
    private Epreuve epreuve;

    public Resultat(int score, int place, Epreuve epreuve) {
        this.score = score;
        this.place = place;
        this.epreuve = epreuve;
    }
    
    public int getScore() {
        return score;
    }
    public int getPlace() {
        return place;
    }
    public Epreuve getEpreuve() {
        return epreuve;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }
}

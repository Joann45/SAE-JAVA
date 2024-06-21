package src;

public class Score {
    
    private int position;
    private double score;
    
    private Epreuve epreuve;

    private Athlete athlete;

    public Score(double res, int place, Athlete athlete, Epreuve epreuve) {
        this.score = res;
        this.position = place;
        this.athlete = athlete;
        this.epreuve = epreuve;
        athlete.setPlacement(place);
        athlete.setScore(this.score);
        
    }
    public Epreuve getEpreuve(){
        return this.epreuve;
    }

    public double getScore() {
        return this.score;
    }

    public Athlete getAthlete(){
        return this.athlete;
    }

    public int getPlacement(){
        return this.position;
    }

    @Override
    public String toString() {
        return "score = " + this.score;
    }    

    
}

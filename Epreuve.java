import java.util.List;

public class Epreuve {
    private String nomEpreuve;
    private String genre;
    private String competition;
    private List<Resultat> lesResultats;

    public Epreuve(String nomEpreuve, String genre, String competition) {
        this.nomEpreuve = nomEpreuve;
        this.genre = genre;
        this.competition = competition;
    }

    public String getNomEpreuve() {
        return nomEpreuve;
    }
    public String getGenreEpreuve() {
        return genre;
    }
    public String getCompetition() {
        return competition;
    }
    public List<Resultat> getLesResultats() {
        return lesResultats;
    }

    public void setNomEpreuve(String nomEpreuve) {
        this.nomEpreuve = nomEpreuve;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public void setLesResultats(List<Resultat> lesResultats) {
        this.lesResultats = lesResultats;
    }


}

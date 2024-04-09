import java.util.List;

public class Classement {
    private List<Resultat> lesResultats;

    public Classement(List<Resultat> lesResultats) {
        this.lesResultats = lesResultats;
    }

    public List<Resultat> getClassement() {
        return lesResultats;
    }   
}

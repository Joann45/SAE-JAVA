import java.util.List;

public abstract class Equipe implements Participant{
    private String nomEquipe;
    
    protected List<Athlete> lesAthletes;

    public Equipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public abstract List<Athlete> getMembres();

    public abstract boolean ajouteMembres(Athlete sportif);
}

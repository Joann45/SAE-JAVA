import java.util.List;

public class Volley extends Equipe {

    public Volley(String nomEquipe) {
        super(nomEquipe);
    }

    @Override
    public List<Athlete> getMembres() {
        return this.lesAthletes;
    }

    @Override
    public boolean ajouteMembres(Athlete sportif) {
        this.lesAthletes.add(sportif);
        return true;
    }

    @Override
    public int participer(Epreuve compet) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'participer'");
    }

    @Override
    public String obtenirNom() {
        return this.getNomEquipe();
    }
}

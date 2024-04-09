import java.util.List;

public class Relais extends Equipe {
    private Epreuve epreuve;

    public Relais(String nomEquipe, Epreuve epreuve) {
        super(nomEquipe);
        this.epreuve = epreuve;
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
